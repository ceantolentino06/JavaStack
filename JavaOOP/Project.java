public class Project {
    private String name;
    private String description;
    private Double initialCost;

    public void elevatorPitch(){
        System.out.println("Project Name: "+this.name);
        System.out.println("Project Description: "+this.description);
        System.out.println("Project Initial Cost: "+this.initialCost    );
    }

    public Project(){

    }

    public Project(String nameParam) {
        this.name = nameParam;
    }

    public Project(String nameParam, String descParam){
        this.name = nameParam;
        this.description = descParam;
    }

    public String getProjectName() {
        return name;
    }

    public void setProjectName(String setName) {
        name = setName;
    }

    public String getProjectDesc() {
        return description;
    }

    public void setProjectDesc(String setDesc) {
        description = setDesc;
    }

    public Double getProjectCost() {
        return initialCost;
    }

    public void setProjectCost(Double setCost) {
        initialCost = setCost;
    }
}