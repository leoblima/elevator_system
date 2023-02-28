package apisul.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonFileReader {

    public static List<JSONObject> readJsonFile(String filePath) {
        List<JSONObject> jsonObjects = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonObjects.add(jsonObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObjects;
    }
}
