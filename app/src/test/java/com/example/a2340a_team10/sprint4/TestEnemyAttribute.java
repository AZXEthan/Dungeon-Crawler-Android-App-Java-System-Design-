package com.example.a2340a_team10.sprint4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.example.a2340a_team10.model.Muddy;
import com.example.a2340a_team10.model.Necromancer;
import com.example.a2340a_team10.model.Ogre;
import com.example.a2340a_team10.model.Orc;
import com.example.a2340a_team10.model.Zombie;
import com.example.a2340a_team10.viewmodel.EnemyMove;

import org.junit.Before;
import org.junit.Test;
public class TestEnemyAttribute {
    Orc orc = new Orc();
    Ogre orge = new Ogre();

    Zombie zombie = new Zombie();

    Necromancer necromancer = new Necromancer();

    Muddy muddy = new Muddy();

    @Test
    public void nameIsSetCorrectly(){
        Orc orc2 = new Orc();
        assertEquals("Orc", orc2.getEnemyName());
    }

    @Test
    public void nameIsSetCorrectly2(){
        Ogre ogre2 = new Ogre();
        assertEquals("Ogre", ogre2.getEnemyName());
    }

    @Test
    public void nameIsSetCorrectly3(){
        Zombie zombie = new Zombie();
        assertEquals("Zombie", zombie.getEnemyName());
    }

    @Test
    public void nameIsSetCorrectly4(){
        Necromancer necromancer = new Necromancer();
        assertEquals("Necromancer", necromancer.getEnemyName());
    }

    @Test
    public void nameIsSetCorrectly5(){
        Muddy muddy = new Muddy();
        assertEquals("Muddy", muddy.getEnemyName());
    }



}