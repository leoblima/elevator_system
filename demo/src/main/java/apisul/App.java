package apisul;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import apisul.elevadorService.ElevadorService;


public class App {
  public static void main(String[] args) {
    List<Character> allElevators = new ArrayList<Character>();
    allElevators.addAll(Arrays.asList('A', 'B', 'C', 'D', 'E'));
    List<Character> allShifts = new ArrayList<Character>();
    allShifts.addAll(Arrays.asList('M', 'V', 'N'));

    System.out.println("Iniciando programa! Com dados default: 'src/main/java/apisul/data/input.json'");
    ElevadorService test = new ElevadorService("demo/src/main/java/apisul/data/input.json", 16, allElevators, allShifts);
    System.out.println("Andares menos utilizados: " + test.andarMenosUtilizado());
    System.out.println("Elevador mais frequentado: " + test.elevadorMaisFrequentado());
    System.out.println("Elevador menos frequentado: " + test.elevadorMenosFrequentado());
    System.out.println("Periodo maior fluxo elevador mais frequentado" + test.periodoMaiorFluxoElevadorMaisFrequentado());
    System.out.println("Período menor fluxo do elevador menos frequentado: " + test.periodoMenorFluxoElevadorMenosFrequentado());
    System.out.println("Periodo(s) de maior utilização do conjunto de elevadores: " + test.periodoMaiorUtilizacaoConjuntoElevadores());
    System.out.println("Percentual de uso do elevador A: " + test.percentualDeUsoElevadorA());
    System.out.println("Percentual de uso do elevador B: " + test.percentualDeUsoElevadorB());
    System.out.println("Percentual de uso do elevador C: " + test.percentualDeUsoElevadorC());
    System.out.println("Percentual de uso do elevador D: " + test.percentualDeUsoElevadorD());
    System.out.println("Percentual de uso do elevador A: " + test.percentualDeUsoElevadorE());
  }
}
