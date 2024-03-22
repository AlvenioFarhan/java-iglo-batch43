import java.util.LinkedList;

public class Territory {

    //Many to Many --> Employee <-> Territory
    private LinkedList<Employee> employees;

    private Integer territoryId;
    private String description;
    private LinkedList<Region> regions;

    //----------------------------------------------------------------------

    public Territory(LinkedList<Employee> employeeTerritories, Integer territoryId,
                     String description, LinkedList<Region> regionId) {
        this.employees = employeeTerritories;
        this.territoryId = territoryId;
        this.description = description;
        this.regions = regionId;
    }


    //----------------------------------------------------------------------


    public LinkedList<Employee> getEmployeeTerritories() {
        return employees;
    }

    public void setEmployeeTerritories(LinkedList<Employee> employeeTerritories) {
        this.employees = employeeTerritories;
    }

    public Integer getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(Integer territoryId) {
        this.territoryId = territoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Region> getRegionId() {
        return regions;
    }

    public void setRegionId(LinkedList<Region> regionId) {
        this.regions = regionId;
    }
}
