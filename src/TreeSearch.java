public class TreeSearch {
    private Problem problem;
    private Strategy strategy;
    private String solution;


    TreeSearch(Problem p, Strategy s){
        solution = "";
        problem = p;
        strategy = s;
    }

    private boolean run() {
        //failure: return false
        //success: return true, and store solution in String solution



        return true;
    }

    public String getSolution() {
        return solution;
    }
}
