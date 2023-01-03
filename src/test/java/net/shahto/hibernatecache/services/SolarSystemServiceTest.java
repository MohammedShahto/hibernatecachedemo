package net.shahto.hibernatecache.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.shahto.hibernatecache.model.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
class SolarSystemServiceTest {

    @Autowired
    SolarSystemService planetService;

    private Planet readPlanet(long id) {
        log.info(String.format("query planet #%d", id));
        Optional<Planet> planet = planetService.getPlanetById(id);
        assertTrue(planet.isPresent());
        log.info("planet found");
        return planet.get();
    }

    @Test
    @Transactional
    void testReadPlanet() {
        Planet planet = readPlanet(4);
        //assert that the 4th planet is 'Mars'
        assertEquals("Mars", planet.getName());
    }

    @Test
    @Transactional
    void testReadPlanetThreeTimes() {
        testReadPlanet();
        testReadPlanet();
        testReadPlanet();
    }

    @Test
    @Transactional
    void testReadPlanetWithMoonReference() {
        Planet planet = readPlanet(4);
        //assert that the 4th planet is 'Mars'
        assertEquals("Mars", planet.getName());
        //assert Mars has 2 moons (triggers the lazy-loading of moons)
        assertEquals(2, planet.getMoons().size());
    }

}