import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public static Environment env;

    private Queue<Integer> state;
    private Node parent; //sera null pour le noeud racine
    //private Action action; inutile car dans notre cas la seule action possible est de se déplacer dans une nouvelle ville
    private Integer pathCost; //cout de l'état initial jusqu'ici. Il est souvent noté g(n)
    private Integer pathDepth; //nombre d'étapes que compte ce chemin

    Node(Node parent, Integer newStateId){
        state = new LinkedList<>();

        if(parent != null){
            this.parent = parent;

            Integer oldStateId = this.parent.state.peek();

            if(env.getCitiesEdgesAndCosts()[oldStateId][newStateId] != -1){
                this.pathCost = this.parent.pathCost + env.getCitiesEdgesAndCosts()[oldStateId][newStateId];
                this.pathDepth = this.parent.pathDepth + 1;
                this.state = this.parent.state;
                this.state.add(newStateId);
            }
            else {
                this.pathCost = null;
                this.pathDepth = null;
                this.state = null;
            }

        }
        else {
            this.parent = null;
            this.pathCost = null;
            this.pathDepth = null;
            this.state.add(newStateId);
        }

    }


}
