import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewsAPI {

    void startAPI() {

        //Method 2 java.net..http.HttpClient  in Java 11
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=7f2d8c048bb042b2af7bd4c45b04f491")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(NewsAPI::parse)
                .join();
    }

    //parser
    public static String parse(String responseBody) {
        JSONObject articles = new JSONObject(responseBody);
        for (int i = 0; i < articles.length(); i++) {
            JSONObject article = articles.getJSONObject("string key...");


            String source = article.getString("source");
            String id2 = article.getString("id");
            String name = article.getString("name");
            String author = article.getString("author");


            // Numeracja każdego pobranego wpisu - ID
            int id = i + 1;
            if (id == i) {
                i++;
            }


            System.out.println("Source: " + source + id2 + " name: " + name + " author: " + author);
        }
        return null;
    }



}
