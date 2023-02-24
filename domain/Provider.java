package domain;

import java.util.List;

public class Provider {

    public String name;

    public List<Region> regions;

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", regions=" + regions +
                '}';
    }
}
