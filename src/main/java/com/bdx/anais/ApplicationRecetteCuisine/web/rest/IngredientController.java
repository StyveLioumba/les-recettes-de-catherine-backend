package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Ingredient;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/api/ingredient/create")
    public ResponseEntity<Ingredient> recordIngredient(@RequestBody IngredientRecordDTO ingredientDTO){
        return ingredientService.recordIngredient(ingredientDTO);
    }
    @GetMapping("api/ingredient/all")
    public Page<Ingredient> findAllIngredient(@RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return ingredientService.findAllIngredient(page, size);
    }

    @DeleteMapping("api/ingredient/delete")
    public void deleteIngredient(String id){
        ingredientService.deleteIngredient(id);
    }
    @GetMapping("api/ingredient/{id}")
    public ResponseEntity<Ingredient> findPatient(@PathVariable String id){
        return ingredientService.findIngredient(id);
    }

    @PutMapping("api/ingredient/update")
    public ResponseEntity<Ingredient> updatePatient(IngredientUpdateDTO ingredientDTO2){
        return ingredientService.updateIngredient(ingredientDTO2);
    }

    @GetMapping("/api/ingredients")
    public List<Ingredient> insertion(){
        return ingredientService.insertion();
    }
}
