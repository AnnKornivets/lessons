package Fitness;


import java.io.IOException;
import java.util.*;

public class FitnessRegistrator {
    private TreeSet<Human> inGym;
    private TreeSet<Human> inPool;
    private TreeSet<Human> inGroup;
    FitnessLogger fitnessLogger;

    FitnessRegistrator(){
        Comparator<Human> humanComparator = new HumanSurnameComparator().thenComparing(new HumanNameComparator());
        inGym = new TreeSet<>(humanComparator);
        inPool = new TreeSet<>(humanComparator);
        inGroup = new TreeSet<>(humanComparator);

    }

    public void add(Client client, FitnessServiceEnumeration type) throws IOException {
        fitnessLogger.add(client, type);
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() <19){
                inGym.add(client);
            }else {throw new QueueException("All places are occupied!");}
        }
        else if(FitnessServiceEnumeration.POOL.equals(type)){
            if (inPool.size() < 19){
                inPool.add(client);
            }else {throw new QueueException("All places are occupied!");}
        }
        else {throw new NoAccessException("You cannot register this section");}
        client.setVisited(true);
    }

    public void add(DayClient dayClient, FitnessServiceEnumeration type) throws IOException {
        fitnessLogger.add(dayClient, type);
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() < 19){
                inGym.add(dayClient);
            }else {throw new QueueException("All places are occupied!");}
        }
        if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (inGroup.size() < 19){
                inGroup.add(dayClient);
            }else {throw new QueueException("All places are occupied!");}
        }
        else {throw new NoAccessException("You cannot register this section");}
    }

    public void add(FullDayClient fullDayClient, FitnessServiceEnumeration type) throws IOException {
        fitnessLogger.add(fullDayClient, type);
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() < 19){
                inGym.add(fullDayClient);
            }else {throw new QueueException("All places are occupied!");}
        }
        if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (inGroup.size() < 19){
                inGroup.add(fullDayClient);
            }else {throw new QueueException("All places are occupied!");}
        }else if(FitnessServiceEnumeration.POOL.equals(type)){
            if (inPool.size() < 19){
                inPool.add(fullDayClient);
            }else {throw new QueueException("All places are occupied!");}
        }
    }

    public void deleteFromAllLists(Human human){
        inGroup.remove(human);
        inPool.remove(human);
        inGym.remove(human);
    }

    public void out(){
        System.out.println(inGym);
        System.out.println(inPool);
        System.out.println(inGroup);
    }


    @Override
    public String toString() {
        return "FitnessRegistrator{" +
                "inGym=" + inGym +
                ", inPool=" + inPool +
                ", inGroup=" + inGroup +
                ", fitnessLogger=" + fitnessLogger +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(inGym, inPool, inGroup);
    }
}
class HumanNameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class HumanSurnameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

