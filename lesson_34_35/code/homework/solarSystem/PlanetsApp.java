package homework.solarSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlanetsApp {
    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();

        planets.add(new Planet("Mercury", 58, 0.33, 0));
        planets.add(new Planet("Venice", 108, 4.81, 0));
        planets.add(new Planet("Earth", 150, 5.98, 1));
        planets.add(new Planet("Mars", 228, 0.63, 2));
        planets.add(new Planet("Jupiter", 775.5, 1876.64, 95));
        planets.add(new Planet("Saturn", 1427, 561.80, 82));
        planets.add(new Planet("Uran", 2860, 86.05, 27));
        planets.add(new Planet("Neptun", 4500, 101.59, 14));

        System.out.println("---SORT By DISTANCE---");
        for (Planet p : planets) {
            System.out.println(p);
        }
        Comparator<Planet> planetNameComparator = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.getPlanet().compareTo(o2.getPlanet());
            }
        };
        System.out.println();
        System.out.println("---SORT BY ALPHABET---");
        planets.sort(planetNameComparator);
        //System.out.println(planets);
        for (Planet p : planets) {
            System.out.println(p);
        }

        Comparator<Planet> planetMassComparator = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Double.compare(o1.getMass(),o2.getMass());
            }
        };

        System.out.println();
        System.out.println("---SORT BY MASS---");
        planets.sort(planetMassComparator);
        for (Planet p : planets) {
            System.out.println(p);
        }

        Comparator <Planet> satelliteComparator = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.getSatellite(), o2.getSatellite());
            }
        };
        System.out.println();
        System.out.println("---SORT BY SATELLITE---");
        planets.sort(satelliteComparator);
        for(Planet p : planets)
            System.out.println(p);
    }
}
