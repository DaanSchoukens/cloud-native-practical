package com.ezgroceries.shoppinglist.shoppinglists.controller;

import com.ezgroceries.shoppinglist.cocktails.model.CocktailReference;
import com.ezgroceries.shoppinglist.shoppinglists.model.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    @PostMapping
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody() ShoppingList shoppingList) {
        shoppingList.setId(UUID.randomUUID());
        return entityWithLocation(shoppingList.getId()).body(shoppingList);
    }

    @PostMapping("/{id}/cocktails")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<CocktailReference>> addCocktails(@RequestBody List<CocktailReference> cocktailReferences, @PathVariable String id) {
        return ResponseEntity.ok(cocktailReferences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> getShoppingList(@PathVariable String id) {
        ShoppingList shoppingList = new ShoppingList(
                UUID.fromString(id),
                "Stephanie's birthday",
                new ArrayList<>(Arrays.asList(
                    "Tequila", "Triple Sec", "Lime juice", "Salt", "Blue Curacao")));
        return ResponseEntity.ok(shoppingList);
    }

    @GetMapping()
    public ResponseEntity<List<ShoppingList>> getAllShoppingLists() {
        List<ShoppingList> shoppingLists = new ArrayList<>();

        ShoppingList stephaniesList = new ShoppingList(
                UUID.randomUUID(),
                "Stephanie's birthday",
                new ArrayList<>(Arrays.asList(
                    "Tequila", "Triple Sec", "Lime juice", "Salt", "Blue Curacao")));
        shoppingLists.add(stephaniesList);

        ShoppingList myList = new ShoppingList(
                UUID.randomUUID(),
                "My birthday",
                new ArrayList<>(Arrays.asList(
                    "Tequila", "Triple Sec", "Lime juice", "Salt", "Blue Curacao")));
        shoppingLists.add(myList);

        return ResponseEntity.ok(shoppingLists);
    }

    private ResponseEntity.BodyBuilder entityWithLocation(Object resourceId) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{childId}").buildAndExpand(resourceId)
                .toUri();
        return ResponseEntity.created(location);
    }
}
