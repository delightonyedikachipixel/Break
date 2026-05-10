public class Problems {

    private String name;
    private String description;
    private ProblemType type;
    private boolean isSolved;


    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.description = "";
        this.isSolved = false;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProblemType getType() {
        return type;
    }

    public boolean isSolved() {
        return isSolved;
    }


    public void setSolved(boolean solved) {
        this.isSolved = solved;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
