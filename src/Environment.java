import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Environment {
    private Map<Integer, String> citiesByIds;
    private Map<String, Integer> citiesByNames;
    private Integer[][] citiesEdgesAndCosts;
    private Integer citiesCount;

    static final String ORADEA = "Oradea";
    static final String ZERIND = "Zerind";
    static final String ARAD = "Arad";
    static final String TIMISOARA = "Timisoara";
    static final String LUGOJ = "Lugoj";
    static final String MEHADIA = "Mehadia";
    static final String DOBRETA = "Dobreta";
    static final String SIBIU = "Sibiu";
    static final String RIMNICU_VILCEA = "RimnicuVilcea";
    static final String CRAIOVA = "Craiova";
    static final String FAGARAS = "Fagaras";
    static final String PITESTI = "Pitesti";
    static final String GIURGIU = "Giurgiu";
    static final String BUCHAREST = "Bucharest";
    static final String NEAMT = "Neamt";
    static final String URZICENI = "Urziceni";
    static final String IASI = "Iasi";
    static final String VASLUI = "Vaslui";
    static final String HIRSOVA = "Hirsova";
    static final String EFORIE = "Eforie";

    Environment(){

    }

    public void initMap() {
        String[] cities = {ORADEA,ZERIND,ARAD,TIMISOARA,LUGOJ,MEHADIA,DOBRETA,SIBIU,RIMNICU_VILCEA,CRAIOVA,FAGARAS,PITESTI,GIURGIU,BUCHAREST,NEAMT,URZICENI,IASI,VASLUI,HIRSOVA,EFORIE};

        citiesCount = cities.length;
        citiesByIds = new HashMap<>();
        citiesByNames = new HashMap<>();

        for(int i = 0; i < citiesCount; i++){
            citiesByIds.put(i, cities[i]);
            citiesByNames.put(cities[i], i);
        }

        citiesEdgesAndCosts = new Integer[citiesCount][citiesCount];

        for(int i=0; i<citiesCount; i++){
            for(int j=0; j<citiesCount; j++){
                citiesEdgesAndCosts[i][j] = -1;
            }
        }

        addBidirectionalLink(ORADEA, ZERIND, 71);
        addBidirectionalLink(ORADEA, SIBIU, 151);
        addBidirectionalLink(ZERIND, ARAD, 75);
        addBidirectionalLink(ARAD, TIMISOARA, 118);
        addBidirectionalLink(ARAD, SIBIU, 140);
        addBidirectionalLink(TIMISOARA, LUGOJ, 111);
        addBidirectionalLink(LUGOJ, MEHADIA, 70);
        addBidirectionalLink(MEHADIA, DOBRETA, 75);
        addBidirectionalLink(DOBRETA, CRAIOVA, 120);
        addBidirectionalLink(SIBIU, FAGARAS, 99);
        addBidirectionalLink(SIBIU, RIMNICU_VILCEA, 80);
        addBidirectionalLink(RIMNICU_VILCEA, PITESTI, 97);
        addBidirectionalLink(RIMNICU_VILCEA, CRAIOVA, 146);
        addBidirectionalLink(CRAIOVA, PITESTI, 138);
        addBidirectionalLink(FAGARAS, BUCHAREST, 211);
        addBidirectionalLink(PITESTI, BUCHAREST, 101);
        addBidirectionalLink(GIURGIU, BUCHAREST, 90);
        addBidirectionalLink(BUCHAREST, URZICENI, 85);
        addBidirectionalLink(NEAMT, IASI, 87);
        addBidirectionalLink(URZICENI, VASLUI, 142);
        addBidirectionalLink(URZICENI, HIRSOVA, 98);
        addBidirectionalLink(IASI, VASLUI, 92);
        addBidirectionalLink(HIRSOVA, EFORIE, 86);
    }

    private void addBidirectionalLink(String cityA, String cityB, Integer cost){
        citiesEdgesAndCosts[citiesByNames.get(cityA)][citiesByNames.get(cityB)] = cost;
        citiesEdgesAndCosts[citiesByNames.get(cityB)][citiesByNames.get(cityA)] = cost;
    }

    public Map<Integer, String> getCitiesByIds() {
        return citiesByIds;
    }

    public Map<String, Integer> getCitiesByNames() {
        return citiesByNames;
    }

    public Integer[][] getCitiesEdgesAndCosts() {
        return citiesEdgesAndCosts;
    }

    public Integer getCitiesCount() {
        return citiesCount;
    }

    public void printCity(Integer cityId){
        System.out.println("Current city: " + getCitiesByIds().get(cityId));
        System.out.println("\tLinked cities:");
        for(int j=0; j<getCitiesCount(); j++){
            if(getCitiesEdgesAndCosts()[cityId][j] != -1){
                System.out.println("\t\t"+getCitiesByIds().get(j)+" with a cost of "+getCitiesEdgesAndCosts()[cityId][j]);
            }
        }
        System.out.println("");
    }
}
