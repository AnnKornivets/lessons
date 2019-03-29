package lesson9.Exercise;



import java.util.ArrayList;
import java.util.Scanner;

enum SolarSystem{
    MERCURY,VENUS,EARTH,MARS,JUPITER,SATURN,URANUS,NEPTUNE; //Идентификаторы в фигурных скобках называются константами перечисления


//        public void onClick (SolarSystem planet) {
//            SolarSystem planets;
//            planet = SolarSystem.MERCURY;
//            int m;
//            int radius ;
//            int radiusorbit;
//
//            switch (planet) {
//                case MERCURY:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    break;
//                case VENUS:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//                case EARTH:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//                case MARS:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//
//                case JUPITER:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//                case SATURN:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//                case URANUS:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//                case NEPTUNE:
//                    m =3376 ;
//                    radius=2440;
//                    radiusorbit=23456789;
//
//                    System.out.println(" " +m+ " "+radius+ " "+radiusorbit);
//                    break;
//            }
//
//            System.out.println("Нет такой планеты");
//
//        }


}


public class Solar {
    SolarSystem planets;
    int m;
    int radius;
    int radiusorbit;


    public Solar(SolarSystem planet, int m, int radius, int radiusorbit ) {
        this.planets = planets;
        this.m = m;
        this.radius = radius;
        this.radiusorbit = radiusorbit;

    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadiusorbit() {
        return radiusorbit;
    }

    public void setRadiusorbit(int radiusorbit) {
        this.radiusorbit = radiusorbit;
    }

    public SolarSystem getPlanets() {
        return planets;
    }

    public void setPlanets(SolarSystem planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "Solar{" +
                "planets=" + planets +
                ", m=" + m +
                ", radius=" + radius +
                ", radiusorbit=" + radiusorbit +
                '}';
    }

    public static void main(String[] args) {

        ArrayList<Solar> solarArrayList=new ArrayList<>();
        solarArrayList.add(new Solar(SolarSystem.MERCURY,328,2440,23456789));
        solarArrayList.add(new Solar(SolarSystem.VENUS,4867,6052,23456789));
        solarArrayList.add(new Solar(SolarSystem.EARTH,5972,6371,23456789));
        solarArrayList.add(new Solar(SolarSystem.MARS,639,3389,23456789));
        solarArrayList.add(new Solar(SolarSystem.JUPITER,1898,69911,23456789));
        solarArrayList.add(new Solar(SolarSystem.SATURN,5683,58232,23456789));
        solarArrayList.add(new Solar(SolarSystem.URANUS,8681,25362,23456789));
        solarArrayList.add(new Solar(SolarSystem.NEPTUNE,1024,24622,23456789));



        for (Solar solar: solarArrayList){


            System.out.println(solar.toString());
        }
    }
}
