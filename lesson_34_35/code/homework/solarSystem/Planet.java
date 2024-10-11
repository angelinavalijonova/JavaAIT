package homework.solarSystem;

import java.util.Objects;

public class Planet implements Comparable<Planet>{
    private String planet;
    private double distance;
    private double mass;
    private int satellite;

    public Planet(String planet, double distance, double mass, int satellite) {
        this.planet = planet;
        this.distance = distance;
        this.mass = mass;
        this.satellite = satellite;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public int getSatellite() {
        return satellite;
    }

    public void setSatellite(int satellite) {
        this.satellite = satellite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planets = (Planet) o;
        return Double.compare(distance, planets.distance) == 0 && Double.compare(mass, planets.mass) == 0 && satellite == planets.satellite && Objects.equals(planet, planets.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planet, distance, mass, satellite);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planets{");
        sb.append("planet='").append(planet).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(", mass=").append(mass);
        sb.append(", satellite=").append(satellite);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Planet o) {
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
