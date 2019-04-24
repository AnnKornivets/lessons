package Fitness;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


//Пример работы с временем в DateTimeExample

public class FitnessLogger {
    public FitnessLogger(File file) {
    }

    public static void add(Human human, FitnessServiceEnumeration type) throws IOException {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        File file = new File("src/Fitness/clients.txt");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {

            sb.append(human.getSurname() + " " + human.getName() + " " + type + " " + LocalDate.now() +
                    " " + formatter.format(LocalTime.now()) + "\n");
            byte[] bytes = sb.toString().getBytes();
            bos.write(bytes, 0 , bytes.length);
        }

    }


}

