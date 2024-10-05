package com.example.Task.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Task.Entity.City;
import com.example.Task.Service.CityService;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    // Endpoint to add a city
    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.saveCity(city);
        
    }

    // Endpoint to retrieve the toponym name by city name
    @GetMapping("/toponym/{name}")
    public String getToponymName(@PathVariable String name) {
        Optional<City> city = cityService.getCityByName(name);
        if (city.isPresent()) {
            return city.get().getToponymName();
        } else {
            return "City not found!";
        }
    }

    // Endpoint to retrieve the population by city name
    @GetMapping("/population/{name}")
    public String getPopulation(@PathVariable String name) {
        Optional<City> city = cityService.getCityByName(name);
        if (city.isPresent()) {
            return "Population of " + name + " is: " + city.get().getPopulation();
        } else {
            return "City not found!";
        }
    }
}
