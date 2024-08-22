package homework.model;
//Дочерний класс Lever (рычаг) с полями: power: double

public class Lever extends Detail {
    private double power;

    public Lever(long barCode, double size, String material, String vendor, double weight, double power) {
        super(barCode, size, material, vendor, weight);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
