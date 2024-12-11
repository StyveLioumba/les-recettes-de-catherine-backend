package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.*;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngRecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngredientRepo;
import com.bdx.anais.ApplicationRecetteCuisine.repository.RecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
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
public class IngRecipeService {

    private IngRecipeRepo ingRecipeRepo;
    private RecipeService recipeService;
    private IngredientService ingredientService;
    private IngredientRepo ingredientRepo;
    private RecipeRepo recipeRepo;

    public ResponseEntity<IngredientRecipe> recordIngRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        IngredientRecipe ingredientRecipe = new IngredientRecipe(ingRecipeRecordDTO);
        Recipe recipe = recipeService.findRecipe(ingRecipeRecordDTO.getIdRecipe()).getBody();
        Ingredient ingredient = ingredientService.findIngredient(ingRecipeRecordDTO.getIdIngredient()).getBody();
        ingredientRecipe.setIngredient(ingredient);
        ingredientRecipe.setRecipe(recipe);
        ingRecipeRepo.save(ingredientRecipe);
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.CREATED);


    }
    public Page<IngredientRecipe> findAllIngRecipe(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        return ingRecipeRepo.findAll(page);
    }

    public void deleteIngRecipe(String idIngredient, String idRecipe) {
        UUID uuidIngredient = UUID.fromString(idIngredient);
        UUID uuidRecipe = UUID.fromString(idRecipe);
        Optional<Step> step = stepRepo.findById(uuidRecipe);
        if (step.isPresent()) {
            stepRepo.delete(step.get());
        } else {
            throwStepNotFound(uuidRecipe);
        }

    }
    public ResponseEntity<Step> findIngRecipe(String idIngredient, String idRecipe) {
        UUID uuidRecipe = UUID.fromString(idRecipe);
        UUID uuidIngredient = UUID.fromString(idIngredient);
        Optional<Recipe> recipe = recipeRepo.findById(uuidRecipe);
        Optional<Ingredient> ingredient = ingredientRepo.findById(uuidIngredient);
        if(recipe.isEmpty() || ingredient.isEmpty() ){
            throwNotFound(uuidRecipe,uuidIngredient);
        }
        Optional<IngredientRecipeId> ingredientRecipeId = new IngredientRecipeId(recipe,ingredient)
        Optional<Ingredient> ingredientRecipe = ingRecipeRepo.findById();
        return new ResponseEntity<IngredientRecipe>(ING) HttpStatus.OK);

    }
    private void throwNotFound(UUID uuidRecipe, UUID uuidIngredient){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " or Ingredient "+ uuidIngredient + " not found in the DataBase");
    }

    private void throwStepNotFound(UUID uuidStep){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Step " + uuidStep + " not found in the DataBase");
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
