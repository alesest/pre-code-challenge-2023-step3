import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {
        System.out.println("START");

        List<String> in = Utils.readFile("input/first_adventure.in");
        assert in != null;
        List<List<String>> inn = Utils.tokens(in);

        Input input = new Input();
        input.n_provider = Integer.valueOf(inn.get(0).get(0));
        input.n_services = Integer.valueOf(inn.get(0).get(1));
        input.n_country = Integer.valueOf(inn.get(0).get(2));
        input.n_progetti = Integer.valueOf(inn.get(0).get(3));
        input.services = inn.get(1);
        input.countries = inn.get(2);
        List<Provider> providers = new ArrayList<>();
        for (int i = 3; i < inn.size() - input.n_progetti; i += 1) {
            Provider provider = new Provider();
            provider.name = inn.get(i).get(0);
            List<Region> regions = new ArrayList<>();
            int n_rg = Integer.parseInt(inn.get(i).get(1));
            for (int z = 0; z < n_rg; z++) {
                Region region = new Region();
                i++;
                String reg = inn.get(i).get(0);
                i++;
                List<String> serv_specs = inn.get(i);
                i++;
                List<String> lat = inn.get(i);
                //i += 3;
                region.name = reg;
                region.n_packages = Integer.valueOf(serv_specs.get(0));
                region.costo_package = Double.valueOf(serv_specs.get(1));
                region.list_serives = serv_specs.subList(2, serv_specs.size()).stream().map(Integer::valueOf).collect(Collectors.toList());
                region.list_latancies = lat.stream().map(Integer::valueOf).collect(Collectors.toList());
                regions.add(region);
            }
            provider.regions = regions;
            providers.add(provider);
        }
        input.provides = providers;
        List<Progetto> progettos = new ArrayList<>();
        for (int i = inn.size() - input.n_progetti; i < inn.size(); i++) {
            Progetto progetto = new Progetto();
            progetto.penalty = Integer.valueOf(inn.get(i).get(0));
            progetto.country = inn.get(i).get(1);
            progetto.required_services = inn.get(i).subList(2, inn.get(i).size()).stream().map(Integer::valueOf).collect(Collectors.toList());
            progettos.add(progetto);
        }
        input.progetti = progettos;
        System.out.println(input);
    }

}
