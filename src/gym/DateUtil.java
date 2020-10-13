package gym;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-12
 * Time:  13:15
 * Project: gym
 * Copyright: MIT
 */
public class DateUtil {

    public  static Long  durationDates(String date) {
        LocalDate fileDate;
        LocalDate currentDate;
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fileDate = LocalDate.from(LocalDate.parse(date, formatter1));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = new Date();
            currentDate = LocalDate.parse(formatter.format(date1), formatter1);
        long different = ChronoUnit.DAYS.between(fileDate, currentDate);
        return different;
    }

    public static String getDateNowFormat() {
        //Get current date time
        LocalDateTime DateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateNowString = DateNow.format(formatter);
        return dateNowString;

    }
}
