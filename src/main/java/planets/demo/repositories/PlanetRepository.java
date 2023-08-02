package planets.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planets.demo.models.Planet;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, UUID> {
    boolean existsByName(String name);
    Planet findByName(String nome);
}
