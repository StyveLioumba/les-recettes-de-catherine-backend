package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngRecipeController {

    @Autowired
    private IngRecipeService ingRecipeService;

    @PostMapping("/api/ingredient_recipe/create")
    public ResponseEntity<IngredientRecipe> recordIngRecipe(@RequestBody IngRecipeRecordDTO ingRecipeRecordDTO) {
        IngredientRecipe ingredientRecipe = ingRecipeService.recordIngRecipe(ingRecipeRecordDTO);
        return new ResponseEntity<>(ingredientRecipe, HttpStatus.CREATED);
    }

    @GetMapping("api/ingredient_recipe/all")
    public ResponseEntity<List<IngredientRecipe>> findAllIngRecipe(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        List<IngredientRecipe> ingredientRecipes = ingRecipeService.findAllIngRecipe(page, size);
        return new ResponseEntity<>(ingredientRecipes, HttpStatus.OK);
    }

    @DeleteMapping("api/ingredient_recipe/delete")
    public void deleteIngRecipe(String idIngredient, String idRecipe) {
        ingRecipeService.deleteIngRecipe(idIngredient, idRecipe);
    }

    @GetMapping("api/ingredient_recipe/id")
    public ResponseEntity<IngredientRecipe> findIngRecipe(@RequestParam String idIngredient, String idRecipe) {
        return ingRecipeService.findIngRecipe(idIngredient, idRecipe);
    }

    @PutMapping("api/ingredient_recipe/update")
    public ResponseEntity<IngredientRecipe> updateStep(IngRecipeRecordDTO ingRecipeRecordDTO) {
        return ingRecipeService.updateIngRecipe(ingRecipeRecordDTO);
    }
}
