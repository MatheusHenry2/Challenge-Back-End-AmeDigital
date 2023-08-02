package planets.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import planets.demo.Constants.Constants;

import java.io.IOException;

public class StarWarsApi {

    private OkHttpClient httpClient = new OkHttpClient();

    public int getPlanetCountAppearances(String planetName) throws IOException {
        String url = Constants.SWAPI_BASE_URL + "planets/?search=" + planetName;
        Request request = new Request.Builder()
                .url(url)
                .build();
        return 0;
        /*try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // Parse the JSON response and get the count of planet appearances
                // Assuming the JSON response format is like: {"count": 1, "results": [...]}
                int count = parsePlanetCount(responseBody);
                return count;
            } else {
                // Handle error response, e.g., planet not found
                return 0;
            }
        }
    }*/
}
}