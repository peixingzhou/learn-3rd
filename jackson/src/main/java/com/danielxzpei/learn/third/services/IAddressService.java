package com.danielxzpei.learn.third.services;

import com.danielxzpei.learn.third.beans.City;

import java.io.File;
import java.io.IOException;

public interface IAddressService {


    City readCityByFile(String cityStr) throws IOException;

    City readCityByFile(File fileName) throws IOException;
}
