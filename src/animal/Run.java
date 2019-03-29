package animal;
//нельзя создать объект
public interface Run extends Cloneable,Runnable{
    default public void stop(){
        System.out.println("Stop");
    }
    public void run();
}
