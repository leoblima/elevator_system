package apisul.services;

import org.json.JSONObject;

import java.util.ArrayList;

import java.util.List;

public class GetData {
/**
 * Método para obter um lista com todos os andares citados nas pesquisas
 * @param pathToFile um caminho para o arquivo que contém os dados JSON
 * @return uma lista com todos os andares citados nas pesquisas
 */
  public static List<Integer> getFloors(String pathToFile) {
    List<Integer> floors = new ArrayList<Integer>();
    List<JSONObject> usersReports = JsonFileReader.readJsonFile(pathToFile);

    for (JSONObject reports : usersReports) {
      floors.add(reports.getInt("andar"));
    }

    return floors;
  }

/**
 * Método para pegar as informações sobre os elevadores escolhidos ou sobre os turnos
 * @param info ums string que pode conter dois valores: 'elevators' e 'shifts' tendo relação com o tipo de retorno
 * @param pathToFile um caminho para o arquivo que contém os dados em JSON
 * @return uma lista de caracteres contendo os turnos ou os elevadores citados na pesquisa
 */
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

/**
 * Método para pegar os turnos segundo um certo elevador
 * @param elevator um caractere que representa um elevador 
 * @param pathToFile um caminho para o arquivo que contém os dados em JSON
 * @return uma lista de caracteres com os turnos citados na pesquisa segundo o elevador
 */
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

/**
 * Método que pega os andares não citados na pesquisa
 * @param pathToFile um caminho para o arquivo que contém os dados em JSON
 * @param totalFloors quantidade total de andares no pŕedio
 * @return uma lista com os andares não utilizados
 */
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
/**
 * Método para pegar os elevadores não utilizados
 * @param info uma string para identificar o tipo de retorno, se vai retornar os elevadores não utilizados ou os turnos não mencionados
 * @param pathToFile um caminho para o arquivo que contém os dados em JSON
 * @param allData uma lista de caracteres contendo as possibilidades do prédio. No caso dos elevadores, todos os elevadores disponíveis no prédio.
 * @return uma lista contendo ou os elevadores não utilizados ou os turnos não utilizados
 */
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
/**
 * Método para pegar os elevadores não utilizados
 * @param info uma string para identificar o tipo de retorno, se vai retornar os elevadores não utilizados ou os turnos não mencionados
 * @param pathToFile um caminho para o arquivo que contém os dados em JSON
 * @param allData uma lista de caracteres contendo as possibilidades do prédio. No caso dos elevadores, todos os elevadores disponíveis no prédio.
 * @param elevator um caractere que identifica o elevador para ver qual turno não foi mencionado
 * @return uma lista contendo ou os elevadores não utilizados ou os turnos não utilizados
 */
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
