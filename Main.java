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
            progetto.acquired = new ArrayList<>();
            for (int ii = 0; ii < progetto.required_services.size(); ii++) {
                progetto.acquired.add(0);
            }
            progettos.add(progetto);
        }
        input.progetti = progettos;
        System.out.println(input);

        double P_SUM = 1.00;
        double P_LAT = 0.00000001;
        //1282049413
        List<Progetto> progSort = input.progetti.stream().sorted((o1, o2) -> {
            int s1 = o1.required_services.stream().reduce(Integer::sum).orElse(0);
            int s2 = o2.required_services.stream().reduce(Integer::sum).orElse(0);
            return ((int) (P_LAT * o2.penalty) + (int) (s2 * P_SUM)) - ((int) (P_LAT * o1.penalty) + (int) (s1 * P_SUM));
        }).collect(Collectors.toList());
        progSort.stream().forEach(progetto -> System.out.println(progetto.penalty));

        //input.provides

        for (Progetto progetto : input.progetti) {
            for (int i = 0; i < progetto.required_services.size(); i++) {
                List<Tuple<Provider, Region>> ord = find(input, input.provides, progetto, i);
                int nPackDaComprae = progetto.required_services.get(i);
                int j = 0;
                while (progetto.required_services.get(i) > progetto.acquired.get(i)) {
                    Tuple<Provider, Region> regionToBuy = ord.get(j);
                    Provider provider = regionToBuy.t1;
                    Region region = regionToBuy.t2;

                    region.n_packages--;
                    for (int iii = 0; iii < region.list_serives.size(); iii++) {
                        progetto.acquired.set(iii, progetto.acquired.get(iii) + region.list_serives.get(iii));
                    }
                }
            }
        }

        System.out.println("FIN");
    }

    public static List<Tuple<Provider, Region>> find(Input input, List<Provider> provides, Progetto progetto, int serv_i) {
        //numero totale packetti*(servizi[indice servizio]/n serv)
        //costo + latenza

        List<Tuple<Provider, Region>> allReg = new ArrayList<>();
        for (Provider provider : provides) {
            for (Region region : provider.regions) {
                allReg.add(new Tuple<>(provider, region));
            }
        }

        allReg = allReg.stream().sorted((o1, o2) -> {
            double s1 = scoreRegion(input, o1.t2, progetto, serv_i);
            double s2 = scoreRegion(input, o2.t2, progetto, serv_i);
            return (int) (s2 * 1000) - (int) (s1 * 1000);
        }).collect(Collectors.toList());

        return allReg;
    }

    public static double scoreRegion(Input input, Region region, Progetto progetto, int serv_i) {
        int cIX = input.countries.indexOf(progetto.country);
        return ((region.n_packages * ((double) (region.list_serives.get(serv_i)) / (double) (region.list_serives.stream().reduce(Integer::sum).orElse(0)))) / (region.costo_package + (double) region.list_latancies.get(cIX)));
    }


    static class Tuple<T1, T2> {
        T1 t1;
        T2 t2;

        public Tuple(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "t1=" + t1 +
                    ", t2=" + t2 +
                    '}';
        }
    }

}

