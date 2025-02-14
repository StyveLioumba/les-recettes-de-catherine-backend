package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.*;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngRecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngredientRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.shared.Utils;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.IngredientRecipeResponse;
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
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class IngRecipeService {

    private IngRecipeRepo ingRecipeRepo;
    private RecipeService recipeService;
    private IngredientService ingredientService;
    private IngredientRepo ingredientRepo;

    public IngredientRecipeResponse recordIngRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        IngredientRecipe ingredientRecipe = new IngredientRecipe();

        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());

        Recipe recipe = recipeService.findRecipe(ingRecipeRecordDTO.getIdRecipe()).getBody();
        Ingredient ingredient = ingredientService.findIngredient(ingRecipeRecordDTO.getIdIngredient()).getBody();

        ingredientRecipe.setIngredient(ingredient);
        ingredientRecipe.setRecipe(recipe);
        ingredientRecipe = ingRecipeRepo.save(ingredientRecipe);

        return new IngredientRecipeResponse(ingredient,ingredientRecipe.getQuantity(),ingredientRecipe.getUnity());
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
        Ingredient ingredient = ingredientService.findIngredient(idIngredient).getBody();
        IngredientRecipeId ingredientRecipeId = new IngredientRecipeId(recipe, ingredient);
        IngredientRecipe ingredientRecipe = ingRecipeRepo.findById(ingredientRecipeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient " + ingredientRecipeId + " not found in the DataBase"));
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);

    }

    public ResponseEntity<List<IngredientRecipeResponse>> findIngRecipeByRecipeId(String idRecipe) {
        List<IngredientRecipe> ingredientRecipes = ingRecipeRepo.findIngredientRecipeBy(UUID.fromString(idRecipe)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found in the DataBase"));

        List<IngredientRecipeResponse>  ingredientRecipeResponses = ingredientRecipes.stream().map(ingredientRecipe ->{

            Ingredient ingredient = ingredientRepo.findById(ingredientRecipe.getIngredient().getIdIngredient()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found in the DataBase"));

            return new IngredientRecipeResponse(ingredient,ingredientRecipe.getQuantity(),ingredientRecipe.getUnity());
        }).toList();

        return new ResponseEntity<List<IngredientRecipeResponse>>(ingredientRecipeResponses, HttpStatus.OK);

    }

    public ResponseEntity<IngredientRecipe> updateIngRecipe(String idIngredient, String idRecipe,IngRecipeRecordDTO ingRecipeRecordDTO) {
        EnumUnity enumUnity = EnumUnity.valueOf(ingRecipeRecordDTO.getUnity().toUpperCase());
        IngredientRecipe ingredientRecipe = this.findIngRecipe(idIngredient, idRecipe).getBody();
        assert ingredientRecipe != null;
        ingredientRecipe.setUnity(enumUnity);
        ingredientRecipe.setQuantity(ingRecipeRecordDTO.getQuantity());
        ingRecipeRepo.save(ingredientRecipe);
        return new ResponseEntity<IngredientRecipe>(ingredientRecipe, HttpStatus.OK);
    }


}
