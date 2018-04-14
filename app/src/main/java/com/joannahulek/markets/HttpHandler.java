package com.joannahulek.markets;

/*
 * GB Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/en_GB/igi
 * DE Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/de_DE/dem
 * FR Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/fr_FR/frm
 * */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpHandler {

    private static final String SPEC = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/%s/%s";
    private static final Map<String, String> COUNTRY_TO_LOCALE_MAPPER = new HashMap<>();
    private static final Map<String, String> COUNTRY_TO_COUNTRY_CODE_MAPPER = new HashMap<>();

    static {
        COUNTRY_TO_LOCALE_MAPPER.put("UK", "en_GB");
        COUNTRY_TO_COUNTRY_CODE_MAPPER.put("UK", "igi");
        COUNTRY_TO_LOCALE_MAPPER.put("Germany", "de_DE");
        COUNTRY_TO_COUNTRY_CODE_MAPPER.put("Germany", "dem");
        COUNTRY_TO_LOCALE_MAPPER.put("France", "fr_FR");
        COUNTRY_TO_COUNTRY_CODE_MAPPER.put("France", "frm");
    }

    public void getMarket(String country) {
        try (InputStream inputStream = new URL(getSpecByCountry(country)).openStream()) {
            String jsonStr = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray results = jsonObj.getJSONArray("markets");

            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                String instrumentName = result.getString("instrumentName");
                String displayOffer = result.getString("displayOffer");
            }

            //TODO:return objects list

        } catch (IOException | JSONException e) {
            System.out.println("Upss, something is wrong");
        }

    }

    private String getSpecByCountry(String country) {
        return String.format(SPEC, COUNTRY_TO_LOCALE_MAPPER.get(country), COUNTRY_TO_COUNTRY_CODE_MAPPER.get(country));
    }
}

