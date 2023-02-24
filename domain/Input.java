package domain;

import java.util.List;

public class Input {

    private Integer n_provider;
    private Integer n_services;
    private Integer n_country;
    private Integer n_progetti;

    private List<String> services;

    private List<String> countries;

    private List<Provider> provides;

    private List<Progetto> progetti;

    public Integer getN_provider() {
        return n_provider;
    }

    public void setN_provider(Integer n_provider) {
        this.n_provider = n_provider;
    }

    public Integer getN_services() {
        return n_services;
    }

    public void setN_services(Integer n_services) {
        this.n_services = n_services;
    }

    public Integer getN_country() {
        return n_country;
    }

    public void setN_country(Integer n_country) {
        this.n_country = n_country;
    }

    public Integer getN_progetti() {
        return n_progetti;
    }

    public void setN_progetti(Integer n_progetti) {
        this.n_progetti = n_progetti;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<Provider> getProvides() {
        return provides;
    }

    public void setProvides(List<Provider> provides) {
        this.provides = provides;
    }

    public List<Progetto> getProgetti() {
        return progetti;
    }

    public void setProgetti(List<Progetto> progetti) {
        this.progetti = progetti;
    }
}
