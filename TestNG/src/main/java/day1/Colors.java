package day1;

public class Colors {
    private String color;
    private String value;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "colors{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
