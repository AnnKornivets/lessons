package multithreading.concur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentExample {
    //потокобезопасные коллекции
    //блокирующие и неблокирующие очереди
    // пул потоков
    //альтернативы wait,notify и synchronised

    public static void main(String[] args) {
        LinkedBlockingQueue queue;
        LinkedBlockingDeque deque;
        LinkedTransferQueue transferQueue; //можно задать размер, а также время на которое она должна поток заблокировать
        PriorityBlockingQueue priorityBlockingQueue;

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4); //нельзя изменять заданный размер

        SynchronousQueue synchronousQueue; //очередь на один элемент







      //  CopyOnWriteArrayList;  //вместо ArrayList<>

       // List<String> list=new ArrayList<>();
       // CopyOnWriteArraySet тоже самое только Set
        CopyOnWriteArraySet set;
        ConcurrentNavigableMap<String,Integer> map;
        ConcurrentSkipListMap<String, Integer> map1;//вместо TreeMap
        //map1.putIfAbsent(); добавляет если в коллекции нет элемента  с таким ключом
        //map1.remove("Oh",4); удалит только если такая пара существует
        //map1.replace("oh",4,78);
        //map1.replace("Oh",56); вернет старое значение
        ConcurrentSkipListSet<String> set1;




        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
        list.add("qwe");
        list.add("Maria");
        list.add("the Saint");
        list.add("Ours");
        list.addIfAbsent("try"); //не надо чтобы добавляли одинаковые данные

        new WriteThread(list).start();
        new ReadThread(list).start();


    }
}

class WriteThread extends Thread{
    private List<String> list;
    private ArrayList<String> data = new ArrayList<>();
    public WriteThread(List<String>list){
        this.list=list;
        data.add("Oh");
        data.add("Saint");
        data.add("Maria");
        data.add("Salazar");
    }

    @Override
    public void run() {
        int count=0;

        while (true) {
            if (count==data.size()-1) count=0;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(data.get(count));
            System.out.println("WriteThread added" + data.get(count));
            count++;


        }
    }
}

class ReadThread extends Thread{



    private List<String> list;
    public ReadThread(List<String> list){
        this.list=list;
    }

    @Override
    public void run() {
        while(true){
        String res="ReadThread res: ";
        //Если Copy
for (String str:list){
    if (list.contains("Maria")){ //Maria
        list.remove(str);
    }

               res +=str +" ";
               try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
               }


}
 //если ArrayList
//            Iterator<String> iterator=list.iterator();
//            while(iterator.hasNext()){
//                String next=iterator.next();
//                res +=next+" ";
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
            System.out.println(res);


        }
    }
}


