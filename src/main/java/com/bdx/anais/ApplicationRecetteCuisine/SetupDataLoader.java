package com.bdx.anais.ApplicationRecetteCuisine;

import com.bdx.anais.ApplicationRecetteCuisine.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private IngredientService ingredientService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        ingredientService.initialInsertion();

        alreadySetup = true;
    }
}
