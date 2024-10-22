package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list;

    /**
     * Create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     * plus one
     */

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    /* has city test */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.hasCity(city), Boolean.TRUE);
        City city2 = new City("Edmonton", "AB");
        assertEquals(list.hasCity(city2), Boolean.FALSE);
    }

    /* delete city test */
    @Test
    public void deleteTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);

        int listSize = list.getCount();
        list.delete(city);
        assertEquals(list.getCount(), listSize - 1);
    }

    /* count cities test */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        int listSize = list.getCount();
        assertEquals(list.countCities(), listSize);

        list.add(new City("Edmonton", "Alberta"));
        assertEquals(list.countCities(), listSize);

    }
}
