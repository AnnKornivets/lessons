package lesson5;

public class BattleUnit extends Unit { //наследование
    private int attackScore;

    public BattleUnit(int health, int attackScore) {
        super(health); //доступ к конструктуру родителя
        this.attackScore = attackScore;
    }

    public void attack(BattleUnit enemy) {

        if (!this.isAlive()){
            System.out.println("Персонаж мертв");
        return;
    }

    enemy.health-=this.attackScore;

}
}
