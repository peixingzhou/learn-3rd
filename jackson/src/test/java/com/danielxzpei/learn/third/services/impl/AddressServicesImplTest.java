package com.danielxzpei.learn.third.services.impl;

import com.danielxzpei.learn.third.beans.City;
import com.danielxzpei.learn.third.beans.Street;
import com.danielxzpei.learn.third.services.IAddressService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AddressServicesImplTest {
    IAddressService service;

    @Before
    public void before() {
        service = new AddressServicesImpl();
    }

    @Test
    public void testReadAddress() throws IOException {
        String cityStr = "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"xian\",\n" +
                "\"streets\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"kejierlu\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":2,\n" +
                "\"name\":\"yunshuiyilu\"\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "}\n";
        City city = service.readCityByFile(cityStr);
        assertEquals("xian", city.getName());
        List<Street> streets = city.getStreets();
        assertEquals(2, streets.size());
        assertEquals("kejierlu", streets.get(0).getName());
    }

    @Test
    public void testReadAddressThroughAFile() throws IOException {
        File file = new File("target/test-classes/city01.json");
        System.out.println(file.getAbsolutePath());
        assert (file.exists());
        City city = service.readCityByFile(file);
        assertEquals("xian", city.getName());
        List<Street> streets = city.getStreets();
        assertEquals(2, streets.size());
        assertEquals("kejierlu", streets.get(0).getName());
    }

    @Test
    public void testReadAddressThroughAFile02() throws IOException {
        File file = new File("target/test-classes/city02.json");
        System.out.println(file.getAbsolutePath());
        assert (file.exists());
        City city = service.readCityByFile(file);
        assertEquals("xian", city.getName());
        List<Street> streets = city.getStreets();
        assertEquals(2, streets.size());
        assertEquals("kejierlu", streets.get(0).getName());
        assertEquals("othersValue", streets.get(1).getOthers());
    }

    @Test
    public void testReadAddressThroughAFile03() throws IOException {
        File file = new File("target/test-classes/city03.json");
        System.out.println(file.getAbsolutePath());
        assert (file.exists());
        City city = service.readCityByFile(file);
        assertEquals("xian", city.getName());
        List<Street> streets = city.getStreets();
        assertEquals(2, streets.size());
        assertEquals("kejierlu", streets.get(0).getName());
        Map<String, String> map = streets.get(1).getMap();
        assertEquals("v1", map.get("k1"));
        assertEquals("v2", map.get("k2"));
    }

}