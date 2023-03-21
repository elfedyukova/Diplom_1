package org.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BunTest {

    private static final String NAME = "первый";
    private static final float PRICE = new Random().nextFloat();

    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(PRICE, bun.getPrice(), 0);
    }
}
