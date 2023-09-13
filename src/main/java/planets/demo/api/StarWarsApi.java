package planets.demo.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
                int count = jsonObject.get("count").getAsInt();
                System.out.println("Count: " + count);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return 0;
    }
}