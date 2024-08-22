package homework.model;
import java.util.Objects;

//Класс Detail (деталь) с полями: barCode: long size: double material: String vendor: String weight: double
//Дочерний класс Lever (рычаг) с полями: power: double
//Имплементация + тест
//Прислать решение ссылкой на GitHub
public class Detail {
    private long barCode;
    private double size;
    private String material;
    private String vendor;
    private double weight;

    public Detail(long barCode, double size, String material, String vendor, double weight) {
        this.barCode = barCode;
        this.size = size;
        this.material = material;
        this.vendor = vendor;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return barCode == detail.barCode && Double.compare(size, detail.size) == 0 && Double.compare(weight, detail.weight) == 0 && Objects.equals(material, detail.material) && Objects.equals(vendor, detail.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode, size, material, vendor, weight);

    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Details{");
        sb.append("barCode=").append(barCode);
        sb.append(", size=").append(size);
        sb.append(", material='").append(material).append('\'');
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

}
