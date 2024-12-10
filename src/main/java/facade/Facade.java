package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Facade {
    JSONParser parser = new JSONParser();

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        try {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

                String inputLine;

                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            } finally {
                con.disconnect();
            }
        } catch (IOException e) {
            throw new IOException("failed to fetch data: " + e.getMessage(), e);
        }
    }

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException{
        try {
            String jsonResult = getJsonFromApi(urlString);
            return extractJokeFromJson(jsonResult, attributeName);
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    public String getRandomJoke() throws Exception {
        String jsonResult = getJsonFromApi("https://api.chucknorris.io/jokes/random");
        return extractJokeFromJson(jsonResult,"value");
    }
    private String extractJokeFromJson(String json,String attribute) throws IllegalArgumentException, ParseException {
        parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            if (jsonObject.get(attribute) == null) {
                throw new IllegalArgumentException("attribute not found");
            }
            return (String) jsonObject.get(attribute);
        } catch (ParseException e) {
            throw new IllegalArgumentException("failed to parse json: " + e.getMessage(), e);
        }


    }
}
