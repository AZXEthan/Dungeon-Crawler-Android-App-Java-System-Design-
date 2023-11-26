package com.example.a2340a_team10;

import static org.junit.Assert.assertEquals;

import com.example.a2340a_team10.model.Imp;
import com.example.a2340a_team10.model.Muddy;

import org.junit.Test;

public class TestWeapon {
    Imp imp = new Imp();
    int i = imp.getHealth();

    @Test
    public void TestBeforeDamage() {
        assertEquals(3, imp.getHealth());
    }
    @Test
    public void TestDamage() {
        imp.takeDamage();
        assertEquals(0, imp.getHealth());
    }

    Muddy muddy = new Muddy();
    int i2 = muddy.getHealth();
    @Test
    public void TestDoubleDamage() {
        muddy.takeDamage();
        assertEquals(0, muddy.getHealth());
    }
}
