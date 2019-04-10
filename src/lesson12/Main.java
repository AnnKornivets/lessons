package lesson12;

import java.io.*;

public class Main {
    public static void main(String[] args)  {
        /*File statFile=new File("stb.bin");
        LaunchStat launchStat=null;
        if(!statFile.exists()){
            //если первый запуск
            launchStat = new LaunchStat();

        }

        else {
            //если не первый запуск,читаем из файла
            try(ObjectInputStream objIn= new ObjectInputStream(new FileInputStream(statFile))) {
                launchStat=(LaunchStat) objIn.readObject(); //приводим  к нужному типу
            }
            catch (IOException| ClassNotFoundException e){
                e.printStackTrace();
            }

        }

        if (launchStat.isFirstLaunch()){
            System.out.println("Первый запуск");

        } else {System.out.println("не первый запуск"+ launchStat);}
        launchStat.update();
        //запись объекта
        try (ObjectOutputStream objOut=new ObjectOutputStream( new FileOutputStream(statFile))){
        objOut.writeObject(launchStat);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/

        File file=new File("stat2.bin");
        LaunchStatExternalizable stat = null;

        if(!file.exists()){
            //если первый запуск
            stat = new LaunchStatExternalizable();

        }

        else {
            //если не первый запуск,читаем из файла
            try(ObjectInputStream in= new ObjectInputStream(new FileInputStream(file))) {
                stat=(LaunchStatExternalizable) in.readObject(); //приводим  к нужному типу
            }
            catch (IOException| ClassNotFoundException e){
                e.printStackTrace();
            }

        }
        if (stat.isFirstLaunch()){
            System.out.println("Первый запуск");

        } else {System.out.println("не первый запуск"+ stat);}
        stat.update();
        //запись объекта
        try (ObjectOutputStream out=new ObjectOutputStream( new FileOutputStream(file))){
            out.writeObject(stat);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
