package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Ingredient;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.IngredientService;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/api/ingredient/create")
    public ResponseEntity<Ingredient> recordIngredient(@RequestBody IngredientRecordDTO ingredientDTO) {
        return ingredientService.recordIngredient(ingredientDTO);
    }

    @GetMapping("api/ingredient/all")
    public ResponseEntity<ApiResponse<List<Ingredient>>> findAllIngredient(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        ApiResponse<List<Ingredient>> ingredients = ingredientService.findAllIngredient(page, size);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @DeleteMapping("api/ingredient/delete/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
    }

    @GetMapping("api/ingredient/{id}")
    public ResponseEntity<Ingredient> findPatient(@PathVariable String id) {
        return ingredientService.findIngredient(id);
    }

    @PutMapping("api/ingredient/update/{id}")
    public ResponseEntity<Ingredient> updatePatient(@PathVariable String id, @RequestBody IngredientUpdateDTO ingredientDTO2) {
        return ingredientService.updateIngredient(id, ingredientDTO2);
    }

    @GetMapping("/api/ingredients")
    public List<Ingredient> insertion() {
        return ingredientService.getIngredient();
    }
}
