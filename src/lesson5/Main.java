package lesson5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight knight=new Knight(12,34);
        Archer archer=new Archer(36,19);

        knight.attack(archer);
        Scanner in=new Scanner(System.in);
        System.out.println(" Введите персонажа");

        String heroType= in.nextLine();

        BattleUnit unit; //работа через родителя

        if (knight.equals(heroType)){
            unit=new Knight(23,78);
        } else{
            unit=new Archer(32,12);

        }
        unit.attack(archer);
    }
}
