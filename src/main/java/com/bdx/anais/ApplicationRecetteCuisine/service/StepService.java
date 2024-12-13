package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.repository.StepRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class StepService {

    private StepRepo stepRepo;
    private RecipeService recipeService;


    public ResponseEntity<Step> recordStep(StepRecordDTO stepDTO) {
        Step step = new Step(stepDTO);
        step.setNumStep(stepDTO.getNumero_etape());
//        if (stepRepo.countStep() == 0){
//            step.setNumStep(1); ;
//        } else {
//            step.setNumStep(stepRepo.findMaxVisitId(stepDTO.getIdRecette()) + 1);
//        }

        Recipe recipe = recipeService.findRecipe(stepDTO.getIdRecette()).getBody();
        step.setRecipe(recipe);
        step.setDescription(stepDTO.getDescription());
        stepRepo.save(step);
        return new ResponseEntity<Step>(step, HttpStatus.CREATED);


    }
    public Page<Step> findAllStep(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        return stepRepo.findAll(page);
    }


    public void deleteStep(String idStep) {
        stepRepo.deleteById(UUID.fromString(idStep));
    }


    public ResponseEntity<Step> findStep(String idStep){
        UUID uuidStep = UUID.fromString(idStep);
        Step step = stepRepo.findById(uuidStep).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Step " + uuidStep + " not found in the DataBase"));
        return new ResponseEntity<Step>(step, HttpStatus.OK);
    }


    public ResponseEntity<Step> updateStep(StepUpdateDTO stepUpdateDTO) {
        Step step = this.findStep(stepUpdateDTO.getStepId()).getBody();
        Recipe recipe = recipeService.findRecipe(stepUpdateDTO.getIdRecette()).getBody();
        assert step != null;
        step.setNumStep(stepUpdateDTO.getNum_etape());
        step.setDescription(stepUpdateDTO.getDescription());
        step.setRecipe(recipe);
        stepRepo.save(step);
        return new ResponseEntity<Step>(step, HttpStatus.OK);
    }
}
