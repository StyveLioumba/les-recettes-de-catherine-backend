package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<IngredientRecipe> findAllIngRecipe(@RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return ingRecipeService.findAllIngRecipe(page, size).getContent();
    }

    @DeleteMapping("api/ingredient_recipe/delete")
    public void deleteIngRecipe(String idIngredient, String idRecipe){
        ingRecipeService.deleteIngRecipe(idIngredient,idRecipe);
    }

    @GetMapping("api/step/id")
    public ResponseEntity<Step> findIngRecipe(@RequestParam String idIngredient, String idRecipe){
        return ingRecipeService.findIngRecipe(idIngredient,idRecipe);
    }

    @PutMapping("api/step/update")
    public ResponseEntity<Step> updateStep(StepUpdateDTO stepUpdateDTO){
        return ingRecipeService.updateStep(stepUpdateDTO);
    }
}
