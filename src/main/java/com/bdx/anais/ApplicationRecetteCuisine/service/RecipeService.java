package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.CategorieRecetteEnum;
import com.bdx.anais.ApplicationRecetteCuisine.repository.RecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class RecipeService {

    private RecipeRepo recipeRepo;

    public ResponseEntity<Recipe> recordRecipe(RecipeRecordDTO recipeDTO) {
        Recipe recipe = new Recipe(recipeDTO) ;
        recipe = recipeRepo.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.CREATED);
    }
    public Page<Recipe> findAllRecipe(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        return recipeRepo.findAll(page);
    }

    public void deleteRecipe(String idRecipe) {
        recipeRepo.deleteById(UUID.fromString(idRecipe));
    }

    public ResponseEntity<Recipe> findRecipe(String id) {
        UUID uuidRecipe = UUID.fromString(id);
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase"));
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);

    }
    public ResponseEntity<Recipe> updateRecipe(RecipeUpdateDTO recipeUpdateDTO) {
        Recipe recipe = this.findRecipe(recipeUpdateDTO.getIdRecipe()).getBody();
        CategorieRecetteEnum recetteEnum = CategorieRecetteEnum.valueOf(recipeUpdateDTO.getCategorieRecette().toUpperCase());
        assert recipe != null;
        recipe.setName(recipeUpdateDTO.getName());
        recipe.setPicture(recipeUpdateDTO.getPicture());
        recipe.setPreparationTimeMinutes(recipeUpdateDTO.getPreparationTimeMinutes());
        recipe.setCookingTimeMinutes(recipeUpdateDTO.getCookingTimeMinutes());
        recipe.setTotalTimeMinutes(recipeUpdateDTO.getPreparationTimeMinutes()+ recipeUpdateDTO.getCookingTimeMinutes());
        recipe.setTips(recipeUpdateDTO.getTips());
        recipe.setCategorieRecetteEnum(recetteEnum);
        recipeRepo.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }
}
