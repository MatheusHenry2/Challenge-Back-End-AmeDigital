package planets.demo.models;

public class PlanetResponse {

    private String message;

    public PlanetResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
