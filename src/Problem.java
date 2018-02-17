public class Problem {
    private Integer startId;
    private Integer goalId;
    private Integer currentStateId;

    Problem(Integer start, Integer goal){
        this.startId = start;
        this.goalId = goal;
        this.currentStateId = start;
    }

    public boolean testGoal(){
        return currentStateId.equals(goalId);
    }

    public Integer getStartId() {
        return startId;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public Integer getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(Integer currentStateId) {
        this.currentStateId = currentStateId;
    }
}
