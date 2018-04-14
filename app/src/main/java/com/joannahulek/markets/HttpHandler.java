package com.joannahulek.markets;

/*
 * GB Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/en_GB/igi
 * DE Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/de_DE/dem
 * FR Market: https://api.ig.com/deal/samples/markets/ANDROID_PHONE/fr_FR/frm
 * */

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import static java.lang.String.format;

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
        try (InputStream is = new URL(getSpecByCountry(country)).openStream();
             JsonReader reader = Json.createReader(is)) {
            JsonObject object = reader.readObject();
            JsonArray results = object.getJsonArray("markets");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                String instrumentName = result.getString("instrumentName");
                String displayOffer = result.getString("displayOffer");

            }

            //TODO:return objects list

        } catch (IOException e) {
            System.out.println("Upss, something is wrong");

        }
    }

    private String getSpecByCountry(String country) {
        return format(SPEC, COUNTRY_TO_LOCALE_MAPPER.get(country), COUNTRY_TO_COUNTRY_CODE_MAPPER.get(country));
    }
}

