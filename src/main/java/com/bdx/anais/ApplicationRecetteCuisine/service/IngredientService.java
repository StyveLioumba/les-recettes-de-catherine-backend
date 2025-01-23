package com.bdx.anais.ApplicationRecetteCuisine.service;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Ingredient;
import com.bdx.anais.ApplicationRecetteCuisine.repository.IngredientRepo;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Service
public class IngredientService {

    private IngredientRepo ingredientRepo;

    public List<Ingredient> insertion() {
        ingredientRepo.deleteAll();
        ArrayList<Ingredient> listIngredients = new ArrayList<Ingredient>();

        //Les légumes
        listIngredients.add(new Ingredient("pomme de terre"));
        listIngredients.add(new Ingredient("carotte"));
        listIngredients.add(new Ingredient("tomate"));
        listIngredients.add(new Ingredient("courgette"));
        listIngredients.add(new Ingredient("oignon rouge"));
        listIngredients.add(new Ingredient("oignon jaune"));
        listIngredients.add(new Ingredient("poivron rouge"));
        listIngredients.add(new Ingredient("poivron vert"));
        listIngredients.add(new Ingredient("poivron jaune"));
        listIngredients.add(new Ingredient("pomme de terre"));
        listIngredients.add(new Ingredient("patate douce"));
        listIngredients.add(new Ingredient("épinard congelé"));
        listIngredients.add(new Ingredient("épinard frais"));
        listIngredients.add(new Ingredient("chou vert"));
        listIngredients.add(new Ingredient("chou-fleur"));
        listIngredients.add(new Ingredient("brocoli"));
        listIngredients.add(new Ingredient("chou rouge"));
        listIngredients.add(new Ingredient("pousse soja"));
        listIngredients.add(new Ingredient("chou blanc"));
        listIngredients.add(new Ingredient("chou de Bruxelles"));
        listIngredients.add(new Ingredient("navet"));
        listIngredients.add(new Ingredient("radis"));
        listIngredients.add(new Ingredient("betterave rouge"));
        listIngredients.add(new Ingredient("concombre"));
        listIngredients.add(new Ingredient("aubergine"));
        listIngredients.add(new Ingredient("courge"));
        listIngredients.add(new Ingredient("potiron"));
        listIngredients.add(new Ingredient("citrouille"));
        listIngredients.add(new Ingredient("poireau"));
        listIngredients.add(new Ingredient("fenouil"));
        listIngredients.add(new Ingredient("céleri branche"));
        listIngredients.add(new Ingredient("céleri rave"));
        listIngredients.add(new Ingredient("artichaut"));
        listIngredients.add(new Ingredient("asperge verte"));
        listIngredients.add(new Ingredient("asperge blanche"));
        listIngredients.add(new Ingredient("champignon de Paris"));
        listIngredients.add(new Ingredient("girolle"));
        listIngredients.add(new Ingredient("pleurote"));
        listIngredients.add(new Ingredient("topinambour"));
        listIngredients.add(new Ingredient("salsifis"));
        listIngredients.add(new Ingredient("manioc"));
        listIngredients.add(new Ingredient("panais"));
        listIngredients.add(new Ingredient("bette"));
        listIngredients.add(new Ingredient("cresson"));
        listIngredients.add(new Ingredient("laitue"));
        listIngredients.add(new Ingredient("roquette"));
        listIngredients.add(new Ingredient("mâche"));
        listIngredients.add(new Ingredient("endive"));
        listIngredients.add(new Ingredient("chicorée"));
        listIngredients.add(new Ingredient("haricot vert"));
        listIngredients.add(new Ingredient("haricot beurre"));
        listIngredients.add(new Ingredient("pois gourmand"));
        listIngredients.add(new Ingredient("pois mange-tout"));
        listIngredients.add(new Ingredient("gombo"));
        listIngredients.add(new Ingredient("câpres"));


        //fruit
        listIngredients.add(new Ingredient("pomme"));
        listIngredients.add(new Ingredient("poire"));
        listIngredients.add(new Ingredient("banane"));
        listIngredients.add(new Ingredient("orange"));
        listIngredients.add(new Ingredient("mandarine"));
        listIngredients.add(new Ingredient("clémentine"));
        listIngredients.add(new Ingredient("citron"));
        listIngredients.add(new Ingredient("citron vert"));
        listIngredients.add(new Ingredient("pamplemousse"));
        listIngredients.add(new Ingredient("ananas"));
        listIngredients.add(new Ingredient("mangue"));
        listIngredients.add(new Ingredient("papaye"));
        listIngredients.add(new Ingredient("kiwi"));
        listIngredients.add(new Ingredient("fruit de la passion"));
        listIngredients.add(new Ingredient("fraise"));
        listIngredients.add(new Ingredient("framboise"));
        listIngredients.add(new Ingredient("myrtille"));
        listIngredients.add(new Ingredient("mûre"));
        listIngredients.add(new Ingredient("cassis"));
        listIngredients.add(new Ingredient("groseille"));
        listIngredients.add(new Ingredient("cerise"));
        listIngredients.add(new Ingredient("abricot"));
        listIngredients.add(new Ingredient("pêche"));
        listIngredients.add(new Ingredient("nectarine"));
        listIngredients.add(new Ingredient("prune"));
        listIngredients.add(new Ingredient("raisin blanc"));
        listIngredients.add(new Ingredient("raisin noir"));
        listIngredients.add(new Ingredient("melon"));
        listIngredients.add(new Ingredient("pastèque"));
        listIngredients.add(new Ingredient("figue"));
        listIngredients.add(new Ingredient("datte"));
        listIngredients.add(new Ingredient("grenade"));
        listIngredients.add(new Ingredient("litchi"));
        listIngredients.add(new Ingredient("noix de coco"));
        listIngredients.add(new Ingredient("avocat")); // Fruit botanique
        listIngredients.add(new Ingredient("olive noire")); // Fruit botanique
        listIngredients.add(new Ingredient("olive verte"));
        listIngredients.add(new Ingredient("kaki"));
        listIngredients.add(new Ingredient("coing"));
        listIngredients.add(new Ingredient("mirabelle"));


        //herbes aromatiques
        listIngredients.add(new Ingredient("persil"));
        listIngredients.add(new Ingredient("coriandre"));
        listIngredients.add(new Ingredient("basilic"));
        listIngredients.add(new Ingredient("thym"));
        listIngredients.add(new Ingredient("romarin"));
        listIngredients.add(new Ingredient("menthe"));
        listIngredients.add(new Ingredient("ciboulette"));
        listIngredients.add(new Ingredient("estragon"));
        listIngredients.add(new Ingredient("fenouil"));
        listIngredients.add(new Ingredient("sauge"));
        listIngredients.add(new Ingredient("origan"));
        listIngredients.add(new Ingredient("sarriette"));
        listIngredients.add(new Ingredient("laurier"));
        listIngredients.add(new Ingredient("aneth"));
        listIngredients.add(new Ingredient("mélisse"));
        listIngredients.add(new Ingredient("cerfeuil"));

        //épices et vinigraite
        listIngredients.add(new Ingredient("piment"));
        listIngredients.add(new Ingredient("sel"));
        listIngredients.add(new Ingredient("poivre"));
        listIngredients.add(new Ingredient("ail"));
        listIngredients.add(new Ingredient("ail semoule"));
        listIngredients.add(new Ingredient("échalote"));
        listIngredients.add(new Ingredient("gingembre"));
        listIngredients.add(new Ingredient("curry"));
        listIngredients.add(new Ingredient("curcuma"));
        listIngredients.add(new Ingredient("paprika"));
        listIngredients.add(new Ingredient("cumin"));
        listIngredients.add(new Ingredient("cannelle"));
        listIngredients.add(new Ingredient("safran"));
        listIngredients.add(new Ingredient("cardamome"));
        listIngredients.add(new Ingredient("muscade"));

        //liquides
        listIngredients.add(new Ingredient("eau"));
        listIngredients.add(new Ingredient("bouillon de volaille"));
        listIngredients.add(new Ingredient("bouillon de légumes"));
        listIngredients.add(new Ingredient("vin"));
        listIngredients.add(new Ingredient("grand marnier"));
        listIngredients.add(new Ingredient("rhum"));
        listIngredients.add(new Ingredient("jus de citron"));

        // sauces
        listIngredients.add(new Ingredient("sauce tomate"));
        listIngredients.add(new Ingredient("sauce béchamel"));
        listIngredients.add(new Ingredient("sauce piquante"));
        listIngredients.add(new Ingredient("sauce barbecue"));
        listIngredients.add(new Ingredient("sauce Worcestershire"));
        listIngredients.add(new Ingredient("ketchup"));
        listIngredients.add(new Ingredient("moutarde"));
        listIngredients.add(new Ingredient("mayonnaise"));
        listIngredients.add(new Ingredient("sauce soja"));
        listIngredients.add(new Ingredient("vinaigre balsamique"));
        listIngredients.add(new Ingredient("vinaigre de vin"));
        listIngredients.add(new Ingredient("vinaigre de cidre"));
        listIngredients.add(new Ingredient("huile d'olive"));
        listIngredients.add(new Ingredient("huile de tournesol"));
        listIngredients.add(new Ingredient("huile de coco"));
        listIngredients.add(new Ingredient("huile de césame"));
        listIngredients.add(new Ingredient("huile de basilic"));


        // viande
        //boeuf
        listIngredients.add(new Ingredient("rumsteck"));
        listIngredients.add(new Ingredient("côte de bœuf"));
        listIngredients.add(new Ingredient("entrecôte"));
        listIngredients.add(new Ingredient("steak de bœuf"));
        listIngredients.add(new Ingredient("viande de bœuf haché"));
        listIngredients.add(new Ingredient("steak  haché de bœuf"));
        listIngredients.add(new Ingredient("jarret de bœuf"));
        listIngredients.add(new Ingredient("hough de bœuf"));
        listIngredients.add(new Ingredient("rôti de bœuf"));
        listIngredients.add(new Ingredient("queue de bœuf"));
        listIngredients.add(new Ingredient("bœuf braisé"));
        listIngredients.add(new Ingredient("côte de veau"));
        listIngredients.add(new Ingredient("escalope de veau"));
        listIngredients.add(new Ingredient("rôti de veau"));
        //porc
        listIngredients.add(new Ingredient("filet mignon de porc"));
        listIngredients.add(new Ingredient("côte de porc"));
        listIngredients.add(new Ingredient("rôti de porc"));
        listIngredients.add(new Ingredient("saucisse de porc"));
        listIngredients.add(new Ingredient("boudin noir"));
        listIngredients.add(new Ingredient("boudin blanc"));
        listIngredients.add(new Ingredient("lardons"));
        listIngredients.add(new Ingredient("chair à sauccisse"));

        //agneau
        listIngredients.add(new Ingredient("épaule d'agneau"));
        listIngredients.add(new Ingredient("côte d'agneau"));
        listIngredients.add(new Ingredient("gigot d'agneau"));
        listIngredients.add(new Ingredient("filet d'agneau"));
        listIngredients.add(new Ingredient("agneau en rôti"));
        //poulet
        listIngredients.add(new Ingredient("cuisse de poulet"));
        listIngredients.add(new Ingredient("filet de poulet"));
        listIngredients.add(new Ingredient("blanc de poulet"));
        listIngredients.add(new Ingredient("poulet rôti"));
        listIngredients.add(new Ingredient("escalope de poulet"));
        //dinde
        listIngredients.add(new Ingredient("escalope de dinde"));
        listIngredients.add(new Ingredient("filet de dinde"));
        listIngredients.add(new Ingredient("cuisse de dinde"));
        //canard
        listIngredients.add(new Ingredient("filet de canard"));
        listIngredients.add(new Ingredient("confit de canard"));
        listIngredients.add(new Ingredient("magret de canard"));
        listIngredients.add(new Ingredient("canard entier"));
        //chevreuil
        listIngredients.add(new Ingredient("viande de chevreuil"));
        listIngredients.add(new Ingredient("filet de chevreuil"));
        listIngredients.add(new Ingredient("côte de chevreuil"));
        //sanglier
        listIngredients.add(new Ingredient("viande de sanglier"));
        listIngredients.add(new Ingredient("filet de sanglier"));
        listIngredients.add(new Ingredient("côte de sanglier"));
        listIngredients.add(new Ingredient("rôti de sanglier"));
        listIngredients.add(new Ingredient("saucisse de Toulouse"));


        //chacuterie
        listIngredients.add(new Ingredient("jambon blanc"));
        listIngredients.add(new Ingredient("jambon fumé"));
        listIngredients.add(new Ingredient("jambon serano"));
        listIngredients.add(new Ingredient("bacon"));
        listIngredients.add(new Ingredient("andouillette"));
        listIngredients.add(new Ingredient("saucisson sec"));
        listIngredients.add(new Ingredient("pâté"));
        listIngredients.add(new Ingredient("terrine"));
        listIngredients.add(new Ingredient("mortadelle"));
        listIngredients.add(new Ingredient("salami"));
        listIngredients.add(new Ingredient("chorizo"));
        listIngredients.add(new Ingredient("coppa"));
        listIngredients.add(new Ingredient("rosette"));
        listIngredients.add(new Ingredient("rillettes"));
        listIngredients.add(new Ingredient("pâté de campagne"));


        //poissons
        listIngredients.add(new Ingredient("saumon fumée"));
        listIngredients.add(new Ingredient("filet de saumon"));
        listIngredients.add(new Ingredient("bar"));
        listIngredients.add(new Ingredient("dorade"));
        listIngredients.add(new Ingredient("merlan"));
        listIngredients.add(new Ingredient("morue"));
        listIngredients.add(new Ingredient("soles"));
        listIngredients.add(new Ingredient("truite"));
        listIngredients.add(new Ingredient("anguille"));
        listIngredients.add(new Ingredient("raie"));
        listIngredients.add(new Ingredient("espadon"));
        listIngredients.add(new Ingredient("flétan"));
        listIngredients.add(new Ingredient("perche"));
        listIngredients.add(new Ingredient("sardine"));
        listIngredients.add(new Ingredient("haddock"));
        listIngredients.add(new Ingredient("lingue"));
        listIngredients.add(new Ingredient("maquereau"));
        listIngredients.add(new Ingredient("grille de lotte"));
        listIngredients.add(new Ingredient("poulpe"));
        listIngredients.add(new Ingredient("coquille Saint-Jacques"));
        listIngredients.add(new Ingredient("palourde"));
        listIngredients.add(new Ingredient("crabe"));
        listIngredients.add(new Ingredient("huître"));
        listIngredients.add(new Ingredient("hareng fumé"));
        listIngredients.add(new Ingredient("hareng doux"));
        listIngredients.add(new Ingredient("crevette"));
        listIngredients.add(new Ingredient("langoustines"));


        //ingredient de base
        listIngredients.add(new Ingredient("œuf"));
        listIngredients.add(new Ingredient("farine de blé"));
        listIngredients.add(new Ingredient("lait"));
        listIngredients.add(new Ingredient("lait d'amande"));
        listIngredients.add(new Ingredient("lait de soja"));
        listIngredients.add(new Ingredient("lait de coco"));
        listIngredients.add(new Ingredient("beurre"));
        listIngredients.add(new Ingredient("beurre salé"));
        listIngredients.add(new Ingredient("crème fraîche épaisse"));
        listIngredients.add(new Ingredient("crème fraiche liquide"));
        listIngredients.add(new Ingredient("levure boulangère"));
        listIngredients.add(new Ingredient("sucre blanc"));
        listIngredients.add(new Ingredient("sucre brun"));
        listIngredients.add(new Ingredient("sucre glace"));
        listIngredients.add(new Ingredient("sucre vanillé"));
        listIngredients.add(new Ingredient("levure chimique"));
        listIngredients.add(new Ingredient("fécule de maïs"));

        //produit pattisier
        listIngredients.add(new Ingredient("mascarpone"));
        listIngredients.add(new Ingredient("chocolat noir"));
        listIngredients.add(new Ingredient("chocolat lait"));
        listIngredients.add(new Ingredient("chocolat blanc"));
        listIngredients.add(new Ingredient("miel"));
        listIngredients.add(new Ingredient("sirop d'érable"));
        listIngredients.add(new Ingredient("sirop d'agave"));
        listIngredients.add(new Ingredient("vanille"));
        listIngredients.add(new Ingredient("extrait d'amande"));
        listIngredients.add(new Ingredient("extrait de vanille"));
        listIngredients.add(new Ingredient("arôme de citron"));
        listIngredients.add(new Ingredient("arôme de framboise"));
        listIngredients.add(new Ingredient("arôme de poire"));
        listIngredients.add(new Ingredient("arôme de vanille"));
        listIngredients.add(new Ingredient("zeste de citron"));
        listIngredients.add(new Ingredient("zeste d'orange"));
        listIngredients.add(new Ingredient("noisettes en poudre"));
        listIngredients.add(new Ingredient("pistaches en poudre"));
        listIngredients.add(new Ingredient("noix de coco râpée"));
        listIngredients.add(new Ingredient("poudre d'amande"));
        listIngredients.add(new Ingredient("gélatine"));
        listIngredients.add(new Ingredient("agar-agar"));
        listIngredients.add(new Ingredient("compote de pomme"));
        listIngredients.add(new Ingredient("café soluble"));
        listIngredients.add(new Ingredient("café en grains"));
        listIngredients.add(new Ingredient("sirop d'agave"));
        listIngredients.add(new Ingredient("cacao en poudre"));
        listIngredients.add(new Ingredient("crème pâtissière"));
        listIngredients.add(new Ingredient("crème chantilly"));
        listIngredients.add(new Ingredient("crème de marrons"));
        listIngredients.add(new Ingredient("caramel"));
        listIngredients.add(new Ingredient("caramel beurre salé"));
        listIngredients.add(new Ingredient("crème anglaise"));
        listIngredients.add(new Ingredient("pâte à tartiner"));
        listIngredients.add(new Ingredient("chocolat praliné"));
        listIngredients.add(new Ingredient("crème de coco"));
        listIngredients.add(new Ingredient("coulis de fruits rouge"));
        listIngredients.add(new Ingredient("fleur d'oranger"));
        listIngredients.add(new Ingredient("lait concentrée sucrée"));
        listIngredients.add(new Ingredient("riz spécial dessert"));


        //pates
        listIngredients.add(new Ingredient("pâte feuilletée"));
        listIngredients.add(new Ingredient("pâte brisée"));
        listIngredients.add(new Ingredient("pâte à pizza"));
        listIngredients.add(new Ingredient("pâte sablée"));
        listIngredients.add(new Ingredient("pâte à choux"));


        //accompagnement
        listIngredients.add(new Ingredient("riz"));
        listIngredients.add(new Ingredient("quinoa"));
        listIngredients.add(new Ingredient("boulgour"));
        listIngredients.add(new Ingredient("spaghetti"));
        listIngredients.add(new Ingredient("lentilles"));
        listIngredients.add(new Ingredient("pois chiche"));
        listIngredients.add(new Ingredient("haricots rouges"));
        listIngredients.add(new Ingredient("haricots blancs"));
        listIngredients.add(new Ingredient("maïs"));
        listIngredients.add(new Ingredient("haricots en boîte"));
        listIngredients.add(new Ingredient("macaroni"));
        listIngredients.add(new Ingredient("penne"));
        listIngredients.add(new Ingredient("tagliatelles"));
        listIngredients.add(new Ingredient("lasagnes"));
        listIngredients.add(new Ingredient("polenta"));
        listIngredients.add(new Ingredient("semoule"));
        listIngredients.add(new Ingredient("semoule pour taboulé"));
        listIngredients.add(new Ingredient("blé"));
        listIngredients.add(new Ingredient("flocons d'avoine"));
        listIngredients.add(new Ingredient("gros sel"));
        listIngredients.add(new Ingredient("semoule de blé"));


        //fruits secs
        listIngredients.add(new Ingredient("pruneau"));
        listIngredients.add(new Ingredient("châtaigne"));
        listIngredients.add(new Ingredient("amande")); // Fruit sec
        listIngredients.add(new Ingredient("noix")); // Fruit sec
        listIngredients.add(new Ingredient("noisette")); // Fruit sec
        listIngredients.add(new Ingredient("pistache")); // Fruit sec
        listIngredients.add(new Ingredient("cacahuète")); // Fruit sec
        listIngredients.add(new Ingredient("raisin sec")); // Fruit sec
        listIngredients.add(new Ingredient("abricot sec")); // Fruit sec
        listIngredients.add(new Ingredient("figue sèche")); // Fruit sec


        //fromages
        listIngredients.add(new Ingredient("yaourt nature"));
        listIngredients.add(new Ingredient("fromage blanc"));
        listIngredients.add(new Ingredient("gruyère"));
        listIngredients.add(new Ingredient("mozzarella"));
        listIngredients.add(new Ingredient("parmesan"));
        listIngredients.add(new Ingredient("feta"));
        listIngredients.add(new Ingredient("ricotta"));
        listIngredients.add(new Ingredient("cheddar"));
        listIngredients.add(new Ingredient("camembert"));
        listIngredients.add(new Ingredient("brie"));
        listIngredients.add(new Ingredient("vieux gouda"));
        listIngredients.add(new Ingredient("roquefort"));
        listIngredients.add(new Ingredient("comté"));
        listIngredients.add(new Ingredient("gorgonzola"));
        listIngredients.add(new Ingredient("emmental"));
        listIngredients.add(new Ingredient("reblochon"));
        listIngredients.add(new Ingredient("boursin"));
        listIngredients.add(new Ingredient("saint-nectaire"));
        listIngredients.add(new Ingredient("chèvre frais"));
        listIngredients.add(new Ingredient("fromage de chèvre affiné"));
        listIngredients.add(new Ingredient("munster"));
        listIngredients.add(new Ingredient("grana padano"));
        listIngredients.add(new Ingredient("bleu d'Auvergne"));
        listIngredients.add(new Ingredient("tomme de Savoie"));
        listIngredients.add(new Ingredient("lait entier"));
        listIngredients.add(new Ingredient("lait demi-écrémé"));
        listIngredients.add(new Ingredient("lait écrémé"));


        //produit autres salades
        listIngredients.add(new Ingredient("tomates séchées"));
        listIngredients.add(new Ingredient("tomates concasées"));
        listIngredients.add(new Ingredient("chapelure"));
        listIngredients.add(new Ingredient("pain"));
        listIngredients.add(new Ingredient("feuille de brick"));

        return ingredientRepo.saveAll(listIngredients);
    }

    public ResponseEntity<Ingredient> recordIngredient(IngredientRecordDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getNomIngredient());
        ingredient = ingredientRepo.save(ingredient);
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.CREATED);
    }

    public List<Ingredient> findAllIngredient(int page_number, int size) {
        Pageable page = PageRequest.of(page_number, size);
        Page<Ingredient> ingredientPage = ingredientRepo.findAll(page);
        List<Ingredient> ingredientList = ingredientPage.getContent();
        return ingredientList;
    }

    public void deleteIngredient(String id) {
        ingredientRepo.deleteById(UUID.fromString(id));
    }

    public ResponseEntity<Ingredient> findIngredient(String idIngredient) {
        UUID uuid = UUID.fromString(idIngredient);
        Ingredient ingredient = ingredientRepo.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient " + idIngredient + " not found in the DataBase"));
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);

    }

    public ResponseEntity<Ingredient> updateIngredient(IngredientUpdateDTO ingredientDTO2) {
        Ingredient ingredient = this.findIngredient(ingredientDTO2.getIdIngredient()).getBody();
        assert ingredient != null;
        ingredient.setName(ingredientDTO2.getIngName());
        ingredientRepo.save(ingredient);
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }


}
