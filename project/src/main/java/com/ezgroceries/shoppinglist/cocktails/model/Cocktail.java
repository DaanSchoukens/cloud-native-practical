package com.ezgroceries.shoppinglist.cocktails.model;

import java.util.List;
import java.util.UUID;

public class Cocktail {

    private UUID id;
    private String name;
    private String glass;
    private String instructions;
    private String imageUrl;
    private List<String> ingredients;

    public Cocktail(UUID id, String name, String glass, String instructions, String imageUrl, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
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

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
