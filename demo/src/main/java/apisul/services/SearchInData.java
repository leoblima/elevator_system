package apisul.services;
import java.text.DecimalFormat;
import java.util.*;

public class SearchInData {
  public static <T> List<T> leastFrequent(List<T> dataToSearch) {
    Map<T, Integer> count = new HashMap<>();
    for (int i = 0; i < dataToSearch.size(); i++) {
        T item = dataToSearch.get(i);
        count.put(item, count.getOrDefault(item, 0) + 1);
    }
    int minCount = Integer.MAX_VALUE;
    List<T> minItems = new ArrayList<>();
    for (Map.Entry<T, Integer> entry : count.entrySet()) {
        T item = entry.getKey();
        int cnt = entry.getValue();
        if (cnt < minCount) {
            minCount = cnt;
            minItems.clear();
            minItems.add(item);
        } else if (cnt == minCount) {
            minItems.add(item);
        }
    }
    return minItems;
  }

  public static <T> List<T> mostFrequent(List<T> dataToSearch) {
    Map<T, Integer> count = new HashMap<>();
    for (int i = 0; i < dataToSearch.size(); i++) {
        T item = dataToSearch.get(i);
        count.put(item, count.getOrDefault(item, 0) + 1);
    }
    int maxCount = 0;
    List<T> maxItems = new ArrayList<>();
    for (Map.Entry<T, Integer> entry : count.entrySet()) {
        T item = entry.getKey();
        int cnt = entry.getValue();
        if (cnt > maxCount) {
            maxCount = cnt;
            maxItems = new ArrayList<>();
            maxItems.add(item);
        } else if (cnt == maxCount) {
            maxItems.add(item);
        }
    }
    return maxItems;
  }

  public static float usePercentageOfElevator(Character elevator, String pathToFile) {
    float useOfChosenElevator = (float) GetData.getShiftsByElevator(elevator, pathToFile).size();
    float totalElevatorUse = (float) GetData.getInfosOf("shifts", pathToFile).size();
    float percentage = (useOfChosenElevator/ totalElevatorUse) * 100;
    DecimalFormat twoDecimals = new DecimalFormat("0.00");
    return Float.parseFloat(twoDecimals.format(percentage).replace(',', '.'));
  }
}
