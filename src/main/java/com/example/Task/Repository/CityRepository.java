package com.example.Task.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Task.Entity.City;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
}
