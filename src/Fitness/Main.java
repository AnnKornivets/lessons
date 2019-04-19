package Fitness;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FitnessRegistrator fitnessRegistrator = new FitnessRegistrator();
        FitnessServiceEnumeration group = FitnessServiceEnumeration.GROUP;
        FitnessServiceEnumeration gym = FitnessServiceEnumeration.GYM;
        FitnessServiceEnumeration pool = FitnessServiceEnumeration.POOL;

        fitnessRegistrator.add(new Client("Ada", "Wong", 1968), gym);
        fitnessRegistrator.add(new Client("Jedai", "Kein", 2008), gym);
        fitnessRegistrator.add(new Client("Ada", "Wong", 1968), group);

        fitnessRegistrator.add(new Client("Slain", "Katar", 1968), pool);
        fitnessRegistrator.add(new Client("Rendal", "Selk", 2008), pool);
        fitnessRegistrator.add(new Client("Wert", "Wong", 1968), gym);
        fitnessRegistrator.add(new Client("Salazer", "Slizeren", 2008), gym);

        fitnessRegistrator.out();
    }

}
