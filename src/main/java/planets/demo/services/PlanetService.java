package planets.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import planets.demo.models.Planet;
import planets.demo.repositories.PlanetRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanetService {

    final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Transactional
    public Planet save(Planet planetModel) throws Exception {

        if (planetExistsByName(planetModel.getName())) {
            throw new Exception("Planet with the same name already exists!");
        }
        planetRepository.save(planetModel);
        return planetModel;
    }
    public boolean planetExistsByName(String name) {
        return planetRepository.existsByName(name);
    }

    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

    @Transactional
    public void delete(Planet peopleModel) {
        planetRepository.delete(peopleModel);
    }
    public List<Planet> findAll() {
        return planetRepository.findAll();
    }
    public Optional<Planet> findByid(UUID id) {
        return planetRepository.findById(id);
    }

}
