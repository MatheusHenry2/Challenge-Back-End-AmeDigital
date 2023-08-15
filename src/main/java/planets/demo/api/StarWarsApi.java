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
        try{
            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return 0;
    }
}


