package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.repository.RecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.repository.StepRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.shared.Utils;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class StepService {

    private StepRepo stepRepo;
    private RecipeRepo recipeRepo;


    public ResponseEntity<Step> recordStep(StepRecordDTO stepDTO) {

        UUID uuidRecipe = UUID.fromString(stepDTO.getIdRecette());
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase"));

        Step step = new Step();
        step.setRecipe(recipe);
        step.setNumStep(stepDTO.getNumStep());
        step.setDescription(stepDTO.getDescription());

        stepRepo.findByNumStepAndDescriptionAndRecipe(step.getNumStep(), step.getDescription(), recipe).ifPresent(s -> {
            //throw new ResponseStatusException(HttpStatus.CONFLICT, "Step already exists in the DataBase");
            deleteStep(s.getId().toString());
        });

        step = stepRepo.save(step);
        return new ResponseEntity<>(step, HttpStatus.CREATED);
    }

    public ApiResponse<List<Step>> findAllStep(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        Page<Step> stepPage = stepRepo.findAll(page);
        List<Step> stepList = stepPage.getContent();

        MetaData metaData = Utils.getMetaData(stepPage);

        return ApiResponse.<List<Step>>builder()
                .status(HttpStatus.OK.getReasonPhrase().toLowerCase())
                .code(HttpStatus.OK.value())
                .content(stepList)
                .meta(metaData)
                .build();
    }


    public void deleteStep(String idStep) {
        stepRepo.deleteById(UUID.fromString(idStep));
    }


    public ResponseEntity<Step> findStep(String idStep) {
        UUID uuidStep = UUID.fromString(idStep);
        Step step = stepRepo.findById(uuidStep).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Step " + uuidStep + " not found in the DataBase"));
        return new ResponseEntity<Step>(step, HttpStatus.OK);
    }


    public ResponseEntity<Step> updateStep(String id, StepUpdateDTO stepUpdateDTO) {
        Step step = this.findStep(id).getBody();
        UUID uuidRecipe = UUID.fromString(stepUpdateDTO.getIdRecette());
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase"));
        assert step != null;
        step.setNumStep(stepUpdateDTO.getNumStep());
        step.setDescription(stepUpdateDTO.getDescription());
        step.setRecipe(recipe);
        stepRepo.save(step);
        return new ResponseEntity<Step>(step, HttpStatus.OK);
    }
}
