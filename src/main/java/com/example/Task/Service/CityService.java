package com.example.Task.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.Entity.City;
import com.example.Task.Repository.CityRepository;

import java.util.Optional;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> getCityByName(String name) {
        return cityRepository.findByName(name);
    }
}
