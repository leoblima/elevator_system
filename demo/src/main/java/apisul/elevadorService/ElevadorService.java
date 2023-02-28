package apisul.elevadorService;
import java.util.*;
import apisul.elevadorService.interfaces.*;
import apisul.services.SearchInData;
import apisul.services.GetData;

public class ElevadorService implements IElevadorService {
  private String _pathToFile;
  private Integer _totalFloors;
  private List<Character> _allElevators;
  private List<Character> _allShifts;

  public ElevadorService(String pathToFile, Integer totalFloors, List<Character> allElevators, List<Character> allShifts) {
    this._pathToFile = pathToFile;
    this._totalFloors = totalFloors;
    this._allElevators = allElevators;
    this._allShifts = allShifts;
  }
  /** Deve retornar uma List contendo o(s) andar(es) menos utilizado(s). */
	public List<Integer> andarMenosUtilizado() {
    List<Integer> floors = GetData.getFloors(this._pathToFile);
    List<Integer> nonUtilizedFloors = GetData.nonUtilizedFloors(this._pathToFile, this._totalFloors);

    if (nonUtilizedFloors.size() > 0) {
      return nonUtilizedFloors;
    }

    List<Integer> leastUtilizedFloors = SearchInData.leastFrequent(floors);
    return leastUtilizedFloors;
  }
	
	 /** Deve retornar uma List contendo o(s) elevador(es) mais frequentado(s). */
	public List<Character> elevadorMaisFrequentado(){
    List<Character> elevators = GetData.getInfosOf("elevators", this._pathToFile);
    List<Character> mostUtilizedElevators = SearchInData.mostFrequent(elevators);

    return mostUtilizedElevators;
  };
	
	 /** Deve retornar uma List contendo o período de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um). */
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
    List<Character> mostUtilizedPeriod = new ArrayList<Character>();
    List<Character> mostUtilizedElevators = this.elevadorMaisFrequentado();

    for (Character elevator: mostUtilizedElevators) {
      List<Character> usedPeriods = GetData.getShiftsByElevator(elevator, this._pathToFile);
      List<Character> mostUsedPeriods = SearchInData.mostFrequent(usedPeriods);
      mostUtilizedPeriod.add(mostUsedPeriods.get(0));
    }

    return mostUtilizedPeriod;
  };
	
	 /** Deve retornar uma List contendo o(s) elevador(es) menos frequentado(s). */
	public List<Character> elevadorMenosFrequentado() {
    List<Character> elevators = GetData.getInfosOf("elevators", this._pathToFile);
    List<Character> nonUtilizedElevators = GetData.nonUtilized("elevators", this._pathToFile, this._allElevators);

    if (nonUtilizedElevators.size() > 0) {
      return nonUtilizedElevators;
    }

    List<Character> leastUtilizedElevators = SearchInData.leastFrequent(elevators);

    return leastUtilizedElevators;
  };
	
	 /** Deve retornar uma List contendo o período de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um). */
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
    List<Character> leastUtilizedPeriod = new ArrayList<Character>();
    List<Character> leastUtilizedElevators = this.elevadorMenosFrequentado();

    for (Character elevator: leastUtilizedElevators) {
      List<Character> nonUsedPeriods = GetData.nonUtilized("shift", this._pathToFile, this._allShifts, elevator);
      if (nonUsedPeriods.size() > 0) {
        leastUtilizedPeriod.add(nonUsedPeriods.get(0));
        continue;
      }
      List<Character> usedPeriods = GetData.getShiftsByElevator(elevator, this._pathToFile);
      List<Character> leastUsedPeriods = SearchInData.leastFrequent(usedPeriods);
      leastUtilizedPeriod.add(leastUsedPeriods.get(0));
    }

    return leastUtilizedPeriod;
  };
	
	 /** Deve retornar uma List contendo o(s) periodo(s) de maior utilização do conjunto de elevadores. */
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
    List<Character> shifts = GetData.getInfosOf("shifts", this._pathToFile);
    List<Character> moreUtilizedPeriods = SearchInData.mostFrequent(shifts);

    return moreUtilizedPeriods;
  }

  	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador A em relação a todos os serviços prestados. */
	public float percentualDeUsoElevadorA() {
    return SearchInData.usePercentageOfElevator('A', this._pathToFile);
  };
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador B em relação a todos os serviços prestados. */
	public float percentualDeUsoElevadorB() {
    return SearchInData.usePercentageOfElevator('B', this._pathToFile);

  };
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador C em relação a todos os serviços prestados. */
	public float percentualDeUsoElevadorC() {
    return SearchInData.usePercentageOfElevator('C', this._pathToFile);

  };
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador D em relação a todos os serviços prestados. */
	public float percentualDeUsoElevadorD() {
    return SearchInData.usePercentageOfElevator('D', this._pathToFile);

  };
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador E em relação a todos os serviços prestados. */
	public float percentualDeUsoElevadorE() {
    return SearchInData.usePercentageOfElevator('E', this._pathToFile);

  }
}
