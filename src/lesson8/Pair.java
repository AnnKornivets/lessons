package lesson8;

public class Pair <K,V> { //два неизвестных типов данных
  private   K key;
   private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<Integer,String> pair=new Pair<>(56,"SString"); //вместо K теперь Integer, V -String
        pair .setKey(5);
        pair.setValue("String");
    }
}
