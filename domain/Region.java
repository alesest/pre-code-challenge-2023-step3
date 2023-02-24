package domain;

import java.util.List;

public class Region {

    public String name;

    public Integer n_packages;

    public Double costo_package;

    public List<Integer> list_serives;

    public List<Integer> list_latancies;

    void buyOne(int i) {
        n_packages--;

    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", n_packages=" + n_packages +
                ", costo_package=" + costo_package +
                ", list_serives=" + list_serives +
                ", list_latancies=" + list_latancies +
                '}';
    }
}
