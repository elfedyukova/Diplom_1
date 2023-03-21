package org.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.praktikum.IngredientType.FILLING;
import static org.praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger;

    @Mock
    Bun bun;
    Ingredient ingredient;
    Ingredient sauce;
    Ingredient dinosaur;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        sauce = new Ingredient(SAUCE, "meat", 100);
        dinosaur = new Ingredient(FILLING, "dinosaur", 200);
        bun = new Bun("hot sauce", 100);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(singletonList(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredientAnyIntTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(dinosaur);
        List<Ingredient> actualList = burger.ingredients;
        int actual = actualList.size();

        burger.removeIngredient(0);
        int expected = actualList.size();

        assertEquals(expected, actual - 1);
    }

    @Test
    public void moveIngredientAnyIntTest() {
        List<Ingredient> expectedList = new ArrayList<>(asList(sauce, dinosaur));
        Ingredient expected = expectedList.get(1);

        burger.addIngredient(sauce);
        burger.addIngredient(dinosaur);
        List<Ingredient> actualList = burger.ingredients;

        burger.moveIngredient(0, 1);
        Ingredient actual = actualList.get(0);

        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        float actual = burger.getPrice();
        assertEquals(200, actual, 0);

    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        System.out.println(burger.getReceipt());
        Assert.assertNotNull(burger.ingredients);

    }
}
