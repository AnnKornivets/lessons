package multithreading.synchronize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {
    public static void main(String[] args) throws IOException {


        //выполнить подсчет топ 100 слов параллельно
        //количество потоков должно
        //быть равно число доступных процессоров
        //основной поток ждет завершения
        Runtime.getRuntime().availableProcessors();//метод вернет количество процессоров

        System.out.println(Runtime.getRuntime().availableProcessors());

        ClassLoader loader = Top100.class.getClassLoader();
        File file = new File(loader.getResource("file").getFile());
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();
        List<String> list1 = words.subList(1, 50);
        List<String> list2 = words.subList(51, 99);
        List<String> list3 = words.subList(141, 200);




        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }


        HashMap<String, Integer> firstMap = new HashMap<>();
        for (String word : list1) {
            if (firstMap.containsKey(word)) {
                firstMap.put(word, firstMap.get(word) + 1);
            } else {
               firstMap.put(word, 1);
            }
        }
        System.out.println(firstMap);


        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);



        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
    }
}

    class CountTop implements Runnable {

       List<String> list1;

        @Override
        public void run() {
            System.out.println("Подсчитываем часть текста");

        }


    public CountTop(List sublist) {

    }
    }
