public class Main {

    public static void main(String[] args) {
        Environment environment = new Environment();
        environment.initMap();
        Node.env = environment;

        /*for(int i=0; i<env.getCitiesCount(); i++){
            env.printCity(i);
        }*/

        Integer aradId = environment.getCitiesByNames().get(Environment.ARAD);
        Integer bucharestId = environment.getCitiesByNames().get(Environment.BUCHAREST);
        Problem problem = new Problem(aradId, bucharestId);

        Strategy strategy = new Strategy();

        TreeSearch treeSearch = new TreeSearch(problem, strategy);

    }
}
