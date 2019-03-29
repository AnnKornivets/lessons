package lesson5;
//наследует BattleUnit
public class Knight extends BattleUnit{

    public Knight(int health, int attackScore) {
        //вызов конструктора родительского класса
        super(health, attackScore);
    }

    //анотация мы собираемся переопределять метод родителя,проверяет совпадает ли
    @Override
    //переопределение метода родителя
    public void attack(BattleUnit enemy) {
     /*   //вызов родительского метода
      super.attack(enemy);
      //расширение функционала
        enemy.health-=1;*/
     enemy.health -=10;
    }
}
