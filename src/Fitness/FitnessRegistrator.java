package Fitness;

import java.util.ArrayList;

public class FitnessRegistrator {
    ArrayList<Human> inGym = new ArrayList<>();
    ArrayList<Human> inPool = new ArrayList<>();
    ArrayList<Human> inGroup = new ArrayList<>();


    public void add(Human human, FitnessServiceEnumeration type ){
        if (FitnessServiceEnumeration.GYM.equals(type)){
            inGym.add(human);
        }


    }
}
