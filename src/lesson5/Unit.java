package lesson5;

public class Unit {
    protected   int health; //доступны внутри дочерного класса

    public Unit(int health) {
        this.health = health;
    }

    public boolean isAlive(){ //возращает  true or false
        return health>0;
    }
}
