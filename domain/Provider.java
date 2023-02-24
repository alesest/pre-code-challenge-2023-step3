package domain;

import java.util.List;

public class Provider {

    private String name;

    private List<Region> regions;

    public String getName() {
        return name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
