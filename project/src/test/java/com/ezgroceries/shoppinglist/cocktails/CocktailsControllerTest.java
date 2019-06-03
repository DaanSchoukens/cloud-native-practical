package com.ezgroceries.shoppinglist.cocktails;

import com.ezgroceries.shoppinglist.cocktails.controller.CocktailController;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(CocktailController.class)
public class CocktailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchCocktails() throws Exception {
        this.mockMvc.perform(
                get("/cocktails")
                        .param("search", "Russian")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].id").value("23b3d85a-3928-41c0-a533-6538a71e17c4"))
        .andExpect(jsonPath("$[0].name").value("Margerita"))
        .andExpect(jsonPath("$[0].glass").value("Cocktail glass"))
        .andExpect(jsonPath("$[0].image").value("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg"))
        .andExpect(jsonPath("$[0].ingredients.length()").value(4))
        .andExpect(jsonPath("$[0].ingredients[0]").value("Tequila"))
        .andExpect(jsonPath("$[0].ingredients[1]").value("Triple sec"))
        .andExpect(jsonPath("$[0].ingredients[2]").value("Lime juice"))
        .andExpect(jsonPath("$[0].ingredients[3]").value("Salt"))
        .andExpect(jsonPath("$[1].id").value("d615ec78-fe93-467b-8d26-5d26d8eab073"))
        .andExpect(jsonPath("$[1].name").value("Blue Margerita"))
        .andExpect(jsonPath("$[1].glass").value("Cocktail glass"))
        .andExpect(jsonPath("$[1].image").value("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg"))
        .andExpect(jsonPath("$[1].ingredients.length()").value(4))
        .andExpect(jsonPath("$[1].ingredients[0]").value("Tequila"))
        .andExpect(jsonPath("$[1].ingredients[1]").value("Blue Curacao"))
        .andExpect(jsonPath("$[1].ingredients[2]").value("Lime juice"))
        .andExpect(jsonPath("$[1].ingredients[3]").value("Salt"));;
    }





}
