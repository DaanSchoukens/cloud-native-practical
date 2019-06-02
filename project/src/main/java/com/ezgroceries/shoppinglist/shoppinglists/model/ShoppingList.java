package com.ezgroceries.shoppinglist.shoppinglists.model;

import java.util.List;
import java.util.UUID;

public class ShoppingList {

    private UUID id;
    private String name;
    private List<String> ingredients;

    public ShoppingList() {}

    public ShoppingList(UUID id, String name, List<String> ingredients) {
        this.setId(id);
        this.setName(name);
        this.setIngredients(ingredients);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
