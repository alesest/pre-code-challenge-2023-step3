package domain;

import java.util.List;

public class Progetto {

    private Integer penalty;

    private String country;

    private List<Integer> required_services;

    public Progetto(Integer penalty, String country, List<Integer> required_services) {
        this.penalty = penalty;
        this.country = country;
        this.required_services = required_services;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public String getCountry() {
        return country;
    }

    public List<Integer> getRequired_services() {
        return required_services;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRequired_services(List<Integer> required_services) {
        this.required_services = required_services;
    }
}
