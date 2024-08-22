package homework.model;

//Дочерний класс Gear (шестеренка) с полями: radius: double tooth: int
 public class Gear extends Detail {

     private double radius;
     private int tooth;

    public Gear(long barCode, double size, String material, String vendor, double weight, double radius, int tooth) {
        super(barCode, size, material, vendor, weight);
        this.radius = radius;
        this.tooth = tooth;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getTooth() {
        return tooth;
    }

    public void setTooth(int tooth) {
        this.tooth = tooth;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gear{");
        sb.append("radius=").append(radius);
        sb.append(", tooth=").append(tooth);
        sb.append('}');
        return sb.toString();
    }
}
