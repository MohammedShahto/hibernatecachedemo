package net.shahto.hibernatecache.repositories;

import net.shahto.hibernatecache.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
