package apisul.services;

import org.json.JSONObject;

import java.util.ArrayList;

import java.util.List;

public class GetData {

  public static List<Integer> getFloors(String pathToFile) {
    List<Integer> floors = new ArrayList<Integer>();
    List<JSONObject> usersReports = JsonFileReader.readJsonFile(pathToFile);

    for (JSONObject reports : usersReports) {
      floors.add(reports.getInt("andar"));
    }

    return floors;
  }

  public static List<Character> getInfosOf(String info, String pathToFile) {
    List<Character> infos = new ArrayList<Character>();
    List<JSONObject> usersReports = JsonFileReader.readJsonFile(pathToFile);

    for (JSONObject reports : usersReports) {
      if (info.equals("elevators")) {
        String elevador = reports.getString("elevador");
        if (elevador != null && !elevador.isEmpty()) {
          infos.add(elevador.charAt(0));
        }
      } else if (info.equals("shifts")) {
        String turno = reports.getString("turno");
        if (turno != null && !turno.isEmpty()) {
          infos.add(turno.charAt(0));
        }
      }
    }
    return infos;
  }

  public static List<Character> getShiftsByElevator(Character elevator, String pathToFile) {
    List<Character> shiftsByElevator = new ArrayList<Character>();
    List<JSONObject> usersReports = JsonFileReader.readJsonFile(pathToFile);

    for (JSONObject reports : usersReports) {
      String elevador = reports.getString("elevador");
      if (elevador.charAt(0) == elevator) {
        String turno = reports.getString("turno");
        if (turno != null && !turno.isEmpty()) {
          shiftsByElevator.add(turno.charAt(0));
        }
      }
    }
    return shiftsByElevator;
  }

  public static List<Integer> nonUtilizedFloors(String pathToFile, Integer totalFloors) {
    List<Integer> nonUtilizedFloors = new ArrayList<Integer>();
    List<Integer> utilizedFloors = GetData.getFloors(pathToFile);
    for (int i = 0; i < totalFloors; i++) {
      if (!utilizedFloors.contains(i)) {
        nonUtilizedFloors.add(i);
      }
    }
    return nonUtilizedFloors;
  }

  public static List<Character> nonUtilized(String info, String pathToFile, List<Character> allData) {
    List<Character> nonUtilized = new ArrayList<Character>();
    List<Character> utilized = info.equals("elevators") ? GetData.getInfosOf("elevators", pathToFile) : GetData.getInfosOf("shifts", pathToFile);
    for (int i = 0; i < allData.size(); i++) {
      if (!utilized.contains(allData.get(i))) {
        nonUtilized.add(allData.get(i));
      }
    }
    return nonUtilized;
  }

  public static List<Character> nonUtilized(String info, String pathToFile, List<Character> allData, Character elevator) {
    List<Character> nonUtilized = new ArrayList<Character>();
    List<Character> utilized = info.equals("elevators") ? GetData.getInfosOf("elevators", pathToFile) : GetData.getShiftsByElevator(elevator, pathToFile);
    for (int i = 0; i < allData.size(); i++) {
      if (!utilized.contains(allData.get(i))) {
        nonUtilized.add(allData.get(i));
      }
    }
    return nonUtilized;
  }
}
