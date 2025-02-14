package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngRecipeService;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.IngredientRecipeResponse;
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
    public ResponseEntity<IngredientRecipeResponse> recordIngRecipe(@RequestBody IngRecipeRecordDTO ingRecipeRecordDTO) {
        IngredientRecipeResponse ingredientRecipe = ingRecipeService.recordIngRecipe(ingRecipeRecordDTO);
        return new ResponseEntity<>(ingredientRecipe, HttpStatus.CREATED);
    }

    @GetMapping("api/ingredient_recipe/all")
    public ResponseEntity<ApiResponse<List<IngredientRecipe>>> findAllIngRecipe(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        ApiResponse<List<IngredientRecipe>> ingredientRecipes = ingRecipeService.findAllIngRecipe(page, size);
        return new ResponseEntity<>(ingredientRecipes, HttpStatus.OK);
    }

    @DeleteMapping("api/ingredient_recipe/delete")
    public void deleteIngRecipe(@RequestParam(name = "idIngredient") String idIngredient, @RequestParam(name = "idRecipe") String idRecipe) {
        ingRecipeService.deleteIngRecipe(idIngredient, idRecipe);
    }

    @GetMapping("api/ingredient_recipe/find")
    public ResponseEntity<IngredientRecipe> findIngRecipe(@RequestParam(name = "idIngredient") String idIngredient, @RequestParam(name = "idRecipe") String idRecipe) {
        return ingRecipeService.findIngRecipe(idIngredient, idRecipe);
    }

    @GetMapping("api/ingredient_recipe/findByRecipeId/{RecipeId}")
    public ResponseEntity<List<IngredientRecipeResponse>> findIngRecipeByRecipeId( @PathVariable String RecipeId) {
        return ingRecipeService.findIngRecipeByRecipeId(RecipeId);
    }

    @PutMapping("api/ingredient_recipe/update")
    public ResponseEntity<IngredientRecipe> updateStep(@RequestParam(name = "idIngredient") String idIngredient, @RequestParam(name = "idRecipe") String idRecipe, @RequestBody IngRecipeRecordDTO ingRecipeRecordDTO) {
        return ingRecipeService.updateIngRecipe(idIngredient, idRecipe, ingRecipeRecordDTO);
    }
}
