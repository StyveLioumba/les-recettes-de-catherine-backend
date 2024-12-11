package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.repository.RecipeRepo;
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

import java.util.Optional;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class StepService {

    private StepRepo stepRepo;
    private RecipeService recipeService;


    public ResponseEntity<Step> recordStep(StepRecordDTO stepDTO) {
        Step step = new Step(stepDTO);
        Recipe recipe = recipeService.findRecipe(stepDTO.getIdRecette()).getBody();
        step.setRecipe(recipe);
        stepRepo.save(step);
        return new ResponseEntity<Step>(step, HttpStatus.CREATED);


    }
    public Page<Step> findAllStep(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        return stepRepo.findAll(page);
    }


    public void deleteStep(String idStep) {
        UUID uuid = UUID.fromString(idStep);
        Optional<Step> step = stepRepo.findById(uuid);
        if (step.isPresent()) {
            stepRepo.delete(step.get());
        } else {
            throwStepNotFound(uuid);
        }

    }
    public ResponseEntity<Step> findStep(String idStep){
        UUID uuid = UUID.fromString(idStep);
        Optional<Step> step = stepRepo.findById(uuid);
        if(step.isEmpty()){
            throwStepNotFound(uuid);
        }
        return new ResponseEntity<Step>(step.get(), HttpStatus.OK);

    }
    private void throwRecipeNotFound(UUID uuidRecipe){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe" + uuidRecipe + " not found in the DataBase");
    }

    private void throwStepNotFound(UUID uuidStep){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Step" + uuidStep + " not found in the DataBase");
    }

    public ResponseEntity<Step> updateStep(StepUpdateDTO stepUpdateDTO) {
        Step step = this.findStep(stepUpdateDTO.getStepId()).getBody();
        Recipe recipe = recipeService.findRecipe(stepUpdateDTO.getIdRecette()).getBody();
        assert step != null;
        step.setNumStep(stepUpdateDTO.getNum_recette());
        step.setDescription(stepUpdateDTO.getDescription());
        step.setRecipe(recipe);
        stepRepo.save(step);
        return new ResponseEntity<Step>(step, HttpStatus.OK);
    }
}
