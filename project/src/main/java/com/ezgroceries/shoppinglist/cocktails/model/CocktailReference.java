package com.ezgroceries.shoppinglist.cocktails.model;

import java.util.UUID;

public class CocktailReference {
    private UUID cocktailId;

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }
}
