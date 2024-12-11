package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngRecipeController {

    @Autowired
    private IngRecipeService ingRecipeService;

    @PostMapping("/api/ingredient_recipe/create")
    public ResponseEntity<IngredientRecipe> recordIngRecipe(@RequestBody IngRecipeRecordDTO ingRecipeRecordDTO){
        return ingRecipeService.recordIngRecipe(ingRecipeRecordDTO);
    }

    @GetMapping("api/ingredient_recipe/all")
    public Page<IngredientRecipe> findAllIngRecipe(@RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return ingRecipeService.findAllIngRecipe(page, size);
    }

    @DeleteMapping("api/ingredient_recipe/delete")
    public void deleteIngRecipe(String idIngredient, String idRecipe){
        ingRecipeService.deleteIngRecipe(idIngredient,idRecipe);
    }

    @GetMapping("api/ingredient_recipe/id")
    public ResponseEntity<IngredientRecipe> findIngRecipe(@RequestParam String idIngredient, String idRecipe){
        return ingRecipeService.findIngRecipe(idIngredient,idRecipe);
    }

    @PutMapping("api/ingredient_recipe/update")
    public ResponseEntity<IngredientRecipe> updateStep(IngRecipeRecordDTO ingRecipeRecordDTO){
        return ingRecipeService.updateIngRecipe(ingRecipeRecordDTO);
    }
}
