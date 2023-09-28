package com.cinema.projectcinema.converter;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    public CurrencyConverter() {
    }

    public double convert(double SEKprice) throws IOException {

        String apiKey = "74017e2a914ff9f3243c1302";
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/SEK/EUR/" + SEKprice;

        //test https://v6.exchangerate-api.com/v6/74017e2a914ff9f3243c1302/pair/SEK/EUR/500

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        double result = 0;

        if (responseCode == connection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            JSONObject obj = new JSONObject(response.toString());
            result = Double.valueOf(obj.getDouble("Conversion_result"));
        }
        return result;
    }
}
