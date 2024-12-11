package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
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

import java.util.Optional;
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

    public void deleteRecipe(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Recipe> recipe = recipeRepo.findById(uuid);
        if (recipe.isPresent()) {
            recipeRepo.delete(recipe.get());
        } else {
            throwIngredientNotFound(uuid);
        }

    }
    public ResponseEntity<Recipe> findRecipe(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Recipe> recipe = recipeRepo.findById(uuid);
        if(recipe.isEmpty()){
            throwIngredientNotFound(uuid);
        }
        return new ResponseEntity<Recipe>(recipe.get(), HttpStatus.OK);

    }
    private void throwIngredientNotFound(UUID uuidRecipe){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase");
    }

    public ResponseEntity<Recipe> updateRecipe(RecipeUpdateDTO recipeDTO2) {
        Recipe recipe = this.findRecipe(recipeDTO2.getIdRecipe()).getBody();
        assert recipe != null;
        recipe.setName(recipeDTO2.getName());
        recipe.setPicture(recipeDTO2.getPicture());
        recipe.setPreparationTimeMinutes(recipeDTO2.getPreparationTimeMinutes());
        recipe.setCookingTimeMinutes(recipeDTO2.getCookingTimeMinutes());
        recipe.setTotalTimeMinutes(recipeDTO2.getPreparationTimeMinutes()+ recipeDTO2.getCookingTimeMinutes());
        recipe.setTips(recipeDTO2.getTips());
        recipe.setTyperecette(recipeDTO2.getTypeRecette());
        recipeRepo.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }
}
