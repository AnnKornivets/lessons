package lesson13.annotation.container;
@Config

public class SomeClassConfig {
    String name;
    int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static void main(String[] args) {
        SomeClassConfig config=new SomeClassConfig();
        config.setName("someClass");
        config.setVersion(2);
    }
}
