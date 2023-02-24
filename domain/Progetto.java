package domain;

import java.util.ArrayList;
import java.util.List;

public class Progetto {

    public Integer penalty;

    public String country;

    public List<Integer> required_services;

    public List<Integer> acquired = new ArrayList<>();

    @Override
    public String toString() {
        return "Progetto{" +
                "penalty=" + penalty +
                ", country='" + country + '\'' +
                ", required_services=" + required_services +
                '}';
    }
}
