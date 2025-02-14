package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.RecipeService;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/api/recipe/create")
    public ResponseEntity<Recipe> recordRecipe(@RequestBody RecipeRecordDTO recipeDTO) {
        Recipe recipe = recipeService.recordRecipe(recipeDTO);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.CREATED);
    }

    @GetMapping("api/recipe/all")
    public ResponseEntity<ApiResponse<List<Recipe>>> findAllRecipe(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        ApiResponse<List<Recipe>> recipes = recipeService.findAllRecipe(page, size);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @DeleteMapping("api/recipe/delete/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("api/recipe/{id}")
    public ResponseEntity<Recipe> findRecipe(@PathVariable String id) {
        return recipeService.findRecipe(id);
    }


    @PutMapping("api/recipe/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable String id,@RequestBody RecipeUpdateDTO recipeDTO2) {
        return recipeService.updateRecipe(id,recipeDTO2);
    }

    @PostMapping(value = "api/recipe/uploadRecipePictures/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadFile(@RequestParam("files") MultipartFile[] files, @PathVariable String id) {
        recipeService.updateRecipePicture(files,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
