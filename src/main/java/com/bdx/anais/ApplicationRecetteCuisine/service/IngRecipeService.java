package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.*;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngRecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.shared.Utils;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class IngRecipeService {

    private IngRecipeRepo ingRecipeRepo;
    private RecipeService recipeService;
    private IngredientService ingredientService;

    public IngredientRecipe recordIngRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        IngredientRecipe ingredientRecipe = new IngredientRecipe();

        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());

        Recipe recipe = recipeService.findRecipe(ingRecipeRecordDTO.getIdRecipe()).getBody();
        Ingredient ingredient = ingredientService.findIngredient(ingRecipeRecordDTO.getIdIngredient()).getBody();

        ingredientRecipe.setIngredient(ingredient);
        ingredientRecipe.setRecipe(recipe);
        ingredientRecipe = ingRecipeRepo.save(ingredientRecipe);
        return ingredientRecipe;
    }


    public ApiResponse<List<IngredientRecipe>> findAllIngRecipe(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        Page<IngredientRecipe> ingredientRecipePage = ingRecipeRepo.findAll(page);
        List<IngredientRecipe> ingredientRecipeList = ingredientRecipePage.getContent();


        MetaData metaData = Utils.getMetaData(ingredientRecipePage);

        return ApiResponse.<List<IngredientRecipe>>builder()
                .status(HttpStatus.OK.getReasonPhrase().toLowerCase())
                .code(HttpStatus.OK.value())
                .content(ingredientRecipeList)
                .meta(metaData)
                .build();
    }

    public void deleteIngRecipe(String idIngredient, String idRecipe) {
        Recipe recipe = recipeService.findRecipe(idRecipe).getBody();
        Ingredient ingredient = ingredientService.findIngredient(idIngredient).getBody();
        ingRecipeRepo.deleteById(new IngredientRecipeId(recipe, ingredient));
    }


    public ResponseEntity<IngredientRecipe> findIngRecipe(String idIngredient, String idRecipe) {
        Recipe recipe = recipeService.findRecipe(idRecipe).getBody();
        Ingredient ingredient = ingredientService.findIngredient(idRecipe).getBody();
        IngredientRecipeId ingredientRecipeId = new IngredientRecipeId(recipe, ingredient);
        IngredientRecipe ingredientRecipe = ingRecipeRepo.findById(ingredientRecipeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient " + ingredientRecipeId + " not found in the DataBase"));
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);

    }

    public ResponseEntity<IngredientRecipe> updateIngRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        IngredientRecipe ingredientRecipe = this.findIngRecipe(ingRecipeRecordDTO.getIdIngredient(), ingRecipeRecordDTO.getIdRecipe()).getBody();
        assert ingredientRecipe != null;
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());
        ingRecipeRepo.save(ingredientRecipe);
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);
    }


}
