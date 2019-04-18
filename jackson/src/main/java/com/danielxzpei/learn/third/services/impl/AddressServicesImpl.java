package com.danielxzpei.learn.third.services.impl;

import com.danielxzpei.learn.third.beans.City;
import com.danielxzpei.learn.third.services.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddressServicesImpl implements IAddressService {

    @Override
    public City readCityByFile(String cityStr) throws IOException {
        return new ObjectMapper().readValue(cityStr,City.class);
    }
    @Override
    public City readCityByFile(File fileName) throws IOException {
        return new ObjectMapper().readValue(fileName,City.class);
    }
}

