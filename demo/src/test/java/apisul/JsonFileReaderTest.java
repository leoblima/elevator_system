package apisul;

import org.json.JSONObject;
import org.junit.Test;
import apisul.services.JsonFileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JsonFileReaderTest {
  @Test
  public void testReadJsonFile() {
    String filePath = "/home/leonardo/Desktop/apisul_prova/demo/src/test/java/apisul/mock/inputMock.json";
    List<JSONObject> expected = new ArrayList<>(List.of(
      new JSONObject(Map.of("andar", 11, "elevador", "A", "turno", "M")),
      new JSONObject(Map.of("andar", 12, "elevador", "A", "turno", "M")),
      new JSONObject(Map.of("andar", 14, "elevador", "A", "turno", "M"))
  ));
    List<JSONObject> result = JsonFileReader.readJsonFile(filePath);

    assertEquals(expected.size(), result.size());
    assertEquals(expected.get(0).getInt("andar"), result.get(0).getInt("andar"));
    assertEquals(expected.get(1).getString("elevador"), result.get(1).getString("elevador"));
    assertEquals(expected.get(2).getString("turno"), result.get(2).getString("turno"));
  }
}
