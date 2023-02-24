package domain;

import java.util.List;

public class Region {

    private String name;

    private Integer n_packages;

    private Double costo_package;

    private List<Integer> list_serives;

    private List<Integer>  list_latancies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getN_packages() {
        return n_packages;
    }

    public void setN_packages(Integer n_packages) {
        this.n_packages = n_packages;
    }

    public Double getCosto_package() {
        return costo_package;
    }

    public void setCosto_package(Double costo_package) {
        this.costo_package = costo_package;
    }

    public List<Integer> getList_serives() {
        return list_serives;
    }

    public void setList_serives(List<Integer> list_serives) {
        this.list_serives = list_serives;
    }

    public List<Integer> getList_latancies() {
        return list_latancies;
    }

    public void setList_latancies(List<Integer> list_latancies) {
        this.list_latancies = list_latancies;
    }
}
