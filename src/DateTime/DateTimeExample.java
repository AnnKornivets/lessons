package DateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeExample {
    public static void main(String[] args) {
        //класс Date()
        Date date=new Date();
        Date other = new Date();
        date.after(other); //boolean
        date.before(other);//boolean
        date.compareTo(other);//int
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy hh:mm");
        System.out.println(format.format(date));

        Calendar calendar = new GregorianCalendar();
        Calendar calendar1=new GregorianCalendar(2019,Calendar.MONTH,Calendar.DAY_OF_MONTH);
        calendar1.add(Calendar.DAY_OF_MONTH,2); // позволяет увеличивать или уменьшить дату относительно той, которая есть
        calendar1.add(Calendar.MONTH,-3);
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar1.getTime());

        //Java 8 Date Time Api

        //LocalDate работа только с датой,
        // LocalTime работа только с временем
       // LocalDateTime и с тем и с тем
        //Period //с временем период с датами, c числами
        //Duration период с времени


        LocalDate dateNow= LocalDate.now();
        System.out.println(dateNow);


        //DateTimeException
        LocalDate someDate = LocalDate.of(2019, Month.JUNE,15);
        System.out.println(someDate);

        //форматирование
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String strDate="14/04/2018";

        LocalDate parseDate=LocalDate.parse(strDate,dateTimeFormatter);
        System.out.println(parseDate);


        System.out.println(dateNow.plusDays(1));
        System.out.println(dateNow.plusMonths(12));
        System.out.println(dateNow.plusYears(3));

        System.out.println(dateNow.minusDays(1));
        System.out.println(dateNow.minusMonths(12));
        System.out.println(dateNow.minusYears(3));

        System.out.println(LocalDate.now().minus(2, ChronoUnit.DAYS));
        DayOfWeek dayOfWeek=LocalDate.parse("2018-07-12").getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfMounth = LocalDate.parse("2018-07-12").getDayOfMonth();
        System.out.println(dayOfMounth);


        boolean isAfter=LocalDate.parse("2018-07-12").isAfter(LocalDate.parse("2019-07-12"));
        boolean isBefore=LocalDate.now().isBefore(LocalDate.parse("2019-07-12"));
        boolean isEqual =LocalDate.now().isEqual(LocalDate.parse("2019-07-12"));

//        List<LocalDate> dates = LocalDate.now().datesUntil(LocalDate.parse("2019-07-12")).collect(Collectors.toList());
//        System.out.println(dates);

        //LocalTime

        LocalTime timeNow= LocalTime.now();
        System.out.println(timeNow);

        LocalTime setTime=LocalTime.of(6,39);
        System.out.println(setTime);

        LocalTime setTime2= LocalTime.parse("12:10");
        System.out.println(setTime2);

        System.out.println(timeNow.plusSeconds(78));
        System.out.println(timeNow.plusMinutes(78));
        System.out.println(timeNow.plusHours(78));

        System.out.println(timeNow.plus(23,ChronoUnit.SECONDS));

        int hours = LocalTime.parse("04:45").getHour();
        int minute = LocalTime.parse("04:45").getMinute();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


        System.out.println(localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE));

        System.out.println(localDateTime.getMonth());

//Period
        LocalDate startDate = LocalDate.parse("2016-04-12");
        LocalDate finalDate = startDate.plus(Period.ofDays(12));
        System.out.println(finalDate);




        List between = Period.between(finalDate,startDate).getUnits();
        System.out.println(between);
        long between2 = ChronoUnit.DAYS.between(finalDate,startDate);
        System.out.println(between2);

       //Duration
        LocalTime localTime = LocalTime.of(7,23);
        LocalTime localTime1=localTime.plus(Duration.ofMinutes(23));

        long timeB = Duration.between(localTime,localTime1).toMinutes();
        long timeB2= ChronoUnit.SECONDS.between(localTime,localTime1);

       //

        Set<String> allZone=ZoneId.getAvailableZoneIds();
        System.out.println(allZone);

        ZoneId zoneId =ZoneId.of("America/Cuiaba");

    }
}
