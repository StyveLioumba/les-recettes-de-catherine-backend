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

import java.util.Arrays;
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
        IngredientRecipe ingredientRecipe = new IngredientRecipe();

        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());

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
        Recipe recipe = recipeService.findRecipe(idRecipe).getBody();
        Ingredient ingredient = ingredientService.findIngredient(idIngredient).getBody();
        ingRecipeRepo.deleteById(new IngredientRecipeId(recipe, ingredient));
    }


    public ResponseEntity<IngredientRecipe> findIngRecipe(String idIngredient, String idRecipe) {
        UUID uuidRecipe = UUID.fromString(idRecipe);
        UUID uuidIngredient = UUID.fromString(idIngredient);
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new IllegalArgumentException("Mon message "));
        Ingredient ingredient = ingredientRepo.findById(uuidIngredient).orElseThrow(() -> new IllegalArgumentException("Mon message "));

        IngredientRecipeId ingredientRecipeId = new IngredientRecipeId(recipe, ingredient);

        IngredientRecipe ingredientRecipe = ingRecipeRepo.findById(ingredientRecipeId).orElseThrow(() -> new IllegalArgumentException("Mon message "));

        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);

    }

    public ResponseEntity<IngredientRecipe> updateIngRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        IngredientRecipe ingredientRecipe = this.findIngRecipe(ingRecipeRecordDTO.getIdIngredient(),ingRecipeRecordDTO.getIdRecipe()).getBody();
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());
        ingRecipeRepo.save(ingredientRecipe);
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);
    }



}
