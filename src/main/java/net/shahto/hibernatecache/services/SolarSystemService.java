package net.shahto.hibernatecache.services;

import net.shahto.hibernatecache.model.Planet;
import net.shahto.hibernatecache.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarSystemService {

    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public Optional<Planet> getPlanetById(long id) {
        return planetRepository.findById(id);
    }
}