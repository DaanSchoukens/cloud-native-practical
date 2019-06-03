package com.ezgroceries.shoppinglist.shoppinglists;

import com.ezgroceries.shoppinglist.shoppinglists.controller.ShoppingListController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(ShoppingListController.class)
public class ShoppingListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllShoppingLists() throws Exception {
        this.mockMvc.perform(
                get("/shopping-lists").contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].id").value("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"))
        .andExpect(jsonPath("$[0].name").value("Stephanie's birthday"))
        .andExpect(jsonPath("$[0].ingredients.length()").value(5))
        .andExpect(jsonPath("$[0].ingredients[0]").value("Tequila"))
        .andExpect(jsonPath("$[0].ingredients[1]").value("Triple Sec"))
        .andExpect(jsonPath("$[0].ingredients[2]").value("Lime juice"))
        .andExpect(jsonPath("$[0].ingredients[3]").value("Salt"))
        .andExpect(jsonPath("$[0].ingredients[4]").value("Blue Curacao"))
        .andExpect(jsonPath("$[1].id").value("6c7d09c2-8a25-4d54-a979-25ae779d2465"))
        .andExpect(jsonPath("$[1].name").value("My birthday"))
        .andExpect(jsonPath("$[1].ingredients.length()").value(5))
        .andExpect(jsonPath("$[1].ingredients[0]").value("Tequila"))
        .andExpect(jsonPath("$[1].ingredients[1]").value("Triple Sec"))
        .andExpect(jsonPath("$[1].ingredients[2]").value("Lime juice"))
        .andExpect(jsonPath("$[1].ingredients[3]").value("Salt"))
        .andExpect(jsonPath("$[1].ingredients[4]").value("Blue Curacao"));
    }

    @Test
    public void testGetShoppingListById() throws Exception {
        this.mockMvc.perform(
                    get("/shopping-lists/4ba92a46-1d1b-4e52-8e38-13cd56c7224c")
                    .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"))
        .andExpect(jsonPath("$.name").value("Stephanie's birthday"))
        .andExpect(jsonPath("$.ingredients.length()").value(5))
        .andExpect(jsonPath("$.ingredients[0]").value("Tequila"))
        .andExpect(jsonPath("$.ingredients[1]").value("Triple Sec"))
        .andExpect(jsonPath("$.ingredients[2]").value("Lime juice"))
        .andExpect(jsonPath("$.ingredients[3]").value("Salt"))
        .andExpect(jsonPath("$.ingredients[4]").value("Blue Curacao"));
    }

    @Test
    public void testCreateNewShoppingList() throws Exception {
        this.mockMvc.perform(
                    post("/shopping-lists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Stephanie's birthday\"}")
        )
        .andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"))
        .andExpect(jsonPath("$.name").value("Stephanie's birthday"));
    }

    @Test
    public void testAddCocktailsToShoppingList() throws Exception {
        this.mockMvc.perform(
                post("/shopping-lists/4ba92a46-1d1b-4e52-8e38-13cd56c7224c/cocktails")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("[{\"cocktailId\":\"23b3d85a-3928-41c0-a533-6538a71e17c4\"},{\"cocktailId\":\"d615ec78-fe93-467b-8d26-5d26d8eab073\"}]")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("[0].cocktailId").value("23b3d85a-3928-41c0-a533-6538a71e17c4"));
    }
}
