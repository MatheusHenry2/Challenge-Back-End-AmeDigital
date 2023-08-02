package planets.demo.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planets.demo.Constants.Constants;
import planets.demo.dtos.PlanetDto;
import planets.demo.models.Planet;
import planets.demo.models.PlanetResponse;
import planets.demo.services.PlanetService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/planet")
public class PlanetController {

    final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getOnePlanet(@PathVariable(value = "id") UUID id) {
        Optional<Planet> peopleModelOptional = planetService.findByid(id);

        if (!peopleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PlanetResponse(Constants.PLANET_NOT_FOUND));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleModelOptional.get());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getOnePlanetByName(@PathVariable(value = "name") String name) {
        Planet planet = planetService.findByName(name);

        if (planet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PlanetResponse(Constants.PLANET_NOT_FOUND));
        }
        return ResponseEntity.status(HttpStatus.OK).body(planet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlanet(@PathVariable(value = "id") UUID id) {
        Optional<Planet> planetModelOptional = planetService.findByid(id);

        if (!planetModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PlanetResponse(Constants.PLANET_NOT_FOUND_FOR_DELETE));
        }

        planetService.delete(planetModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(new PlanetResponse(Constants.PLANET_DELETED));
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<PlanetResponse> savePlanet(@RequestBody @Valid PlanetDto planetDto) {
        var planetModel = new Planet();
        BeanUtils.copyProperties(planetDto, planetModel);

        planetService.save(planetModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PlanetResponse(Constants.PLANET_CREATED));
    }

    @GetMapping
    public ResponseEntity<List<Planet>> getAllPlanet() {

        List<Planet> planetModelList = planetService.findAll();

        if (planetModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
        return ResponseEntity.status(HttpStatus.OK).body(planetModelList);
    }

}
