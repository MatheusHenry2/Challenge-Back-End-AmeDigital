package planets.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PlanetDto {

    @NotBlank
    private String name;

    @NotBlank
    private String climate;

    @NotBlank
    private String ground;
}
