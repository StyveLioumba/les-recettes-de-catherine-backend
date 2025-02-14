package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.advice.StorageException;
import com.bdx.anais.ApplicationRecetteCuisine.domain.CategorieRecetteEnum;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import com.bdx.anais.ApplicationRecetteCuisine.repository.RecipeRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.shared.Utils;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.MetaData;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class RecipeService {

    private final Path rootLocation = Paths.get("src/main/resources/pictures");

    private RecipeRepo recipeRepo;

    public Recipe recordRecipe(RecipeRecordDTO recipeDTO) {
        Recipe recipe = new Recipe();

        recipe.setName(recipeDTO.getName());
        recipe.setPicture(recipeDTO.getPicture());
        recipe.setTotalTimeMinutes(recipeDTO.getPreparationTimeMinutes() + recipeDTO.getCookingTimeMinutes());
        recipe.setPreparationTimeMinutes(recipeDTO.getPreparationTimeMinutes());
        recipe.setCookingTimeMinutes(recipeDTO.getCookingTimeMinutes());
        recipe.setTips(recipeDTO.getTips());
        recipe.setCategorieRecetteEnum(recipeDTO.getCategorieRecetteEnum());

        recipe = recipeRepo.save(recipe);
        return recipe;
    }

    public ApiResponse<List<Recipe>> findAllRecipe(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        Page<Recipe> recipePage = recipeRepo.findAll(page);
        List<Recipe> recipeList = recipePage.getContent();

        MetaData metaData = Utils.getMetaData(recipePage);

        return ApiResponse.<List<Recipe>>builder()
                .status(HttpStatus.OK.getReasonPhrase().toLowerCase())
                .code(HttpStatus.OK.value())
                .content(recipeList)
                .meta(metaData)
                .build();
    }

    public void deleteRecipe(String idRecipe) {
        Recipe recipe = recipeRepo.findById(UUID.fromString(idRecipe)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + idRecipe + " not found in the DataBase"));
        recipeRepo.deleteById(UUID.fromString(idRecipe));
        if (recipe.getPicture() != null) {
            deleteImage(recipe.getPicture());
        }
    }

    public ResponseEntity<Recipe> findRecipe(String id) {
        UUID uuidRecipe = UUID.fromString(id);
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase"));
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);

    }

    public ResponseEntity<Recipe> updateRecipe(String id ,RecipeUpdateDTO recipeUpdateDTO) {
        UUID uuidRecipe = UUID.fromString(id);
        Recipe recipe = recipeRepo.findById(uuidRecipe).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + uuidRecipe + " not found in the DataBase"));
        CategorieRecetteEnum recetteEnum = CategorieRecetteEnum.valueOf(recipeUpdateDTO.getCategorieRecetteEnum().toUpperCase());
        //assert recipe != null;

        if (!Objects.equals(recipe.getPicture(), recipeUpdateDTO.getPicture())){
            deleteImage(recipe.getPicture());
        }
        recipe.setName(recipeUpdateDTO.getName());
        recipe.setPicture(recipeUpdateDTO.getPicture());
        recipe.setPreparationTimeMinutes(recipeUpdateDTO.getPreparationTimeMinutes());
        recipe.setCookingTimeMinutes(recipeUpdateDTO.getCookingTimeMinutes());
        recipe.setTotalTimeMinutes(recipeUpdateDTO.getPreparationTimeMinutes() + recipeUpdateDTO.getCookingTimeMinutes());
        recipe.setTips(recipeUpdateDTO.getTips());
        recipe.setCategorieRecetteEnum(recetteEnum);
        recipeRepo.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @Transactional
    public void updateRecipePicture(MultipartFile[] files, String recipeId) {
        Arrays.stream(files).forEach(file -> {
            Path destinationFile = saveFile(file);
            Recipe recipe = recipeRepo.findById(UUID.fromString(recipeId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe " + recipeId + " not found in the DataBase"));
            recipe.setPicture(destinationFile.getFileName().toString());
            recipeRepo.save(recipe);
        });
    }

    public Path saveFile(MultipartFile file) {
        Path destinationFile ;
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            // Génère un nom unique pour le fichier
            String uniqueFileName = generateUniqueFileName(file.getOriginalFilename());

            destinationFile = this.rootLocation.resolve(
                    Paths.get(uniqueFileName))
                    .normalize()
                    .toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }

        return destinationFile;
    }


    public String generateUniqueFileName(String originalFilename) {
        // Récupère l'extension du fichier
        String extension = "";
        int dotIndex = originalFilename.lastIndexOf('.');
        if (dotIndex > 0) {
            extension = originalFilename.substring(dotIndex);
        }

        // Formater la date et l'heure sans espace (ex: 20250214_153045)
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Générer une partie aléatoire (sans tirets)
        String randomPart = UUID.randomUUID().toString().replace("-", "");

        // Concaténer pour obtenir le nom final
        return timestamp + "_" + randomPart + extension;
    }

    public boolean deleteImage(String fileName) {
        try {
            // Résolution du chemin complet du fichier
            Path filePath = rootLocation.resolve(fileName).normalize().toAbsolutePath();

            // Vérification que le fichier est bien dans le dossier rootLocation
            if (!filePath.getParent().equals(rootLocation.toAbsolutePath())) {
                throw new SecurityException("Accès non autorisé : tentative de suppression d'un fichier en dehors du répertoire autorisé.");
            }

            // Supprime le fichier s'il existe et retourne true, sinon false
            return Files.deleteIfExists(filePath);
        } catch (IOException ex) {
            throw new RuntimeException("Erreur lors de la suppression du fichier " + fileName, ex);
        }
    }
}
