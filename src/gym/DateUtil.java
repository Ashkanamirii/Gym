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

    public static Long durationDates(String registerDate) {
        LocalDate regDate;
        LocalDate currentDate;
        regDate = LocalDate.parse(registerDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        currentDate = LocalDate.parse(formatter.format(now));
        return ChronoUnit.DAYS.between(regDate, currentDate);
    }

    public static String getDateNowFormat() {
        //Get current date time
        LocalDateTime DateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return DateNow.format(formatter);
    }
}
