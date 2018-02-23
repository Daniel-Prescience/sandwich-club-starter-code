package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject sandwichNamesJson = sandwichJson.getJSONObject("name");

            String mainName = sandwichNamesJson.getString("mainName");
            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String imageUrl = sandwichJson.getString("image");

            List<String> alsoKnownAs = new ArrayList<>();
            List<String> ingredients = new ArrayList<>();

            JSONArray alsoKnownAsJson = sandwichNamesJson.getJSONArray("alsoKnownAs");
            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");

            for (int i = 0; i < alsoKnownAsJson.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJson.getString(i));
            }

            for (int i = 0; i < ingredientsJson.length(); i++) {
                ingredients.add(ingredientsJson.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, imageUrl, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
