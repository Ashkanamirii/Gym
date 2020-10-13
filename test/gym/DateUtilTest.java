package gym;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-12
 * Time:  18:57
 * Project: gym
 * Copyright: MIT
 */
class DateUtilTest {
    @Test
    void durationDatesTest() {
        Long result = DateUtil.durationDates(LocalDate.now().minusMonths(1).toString());
        assertEquals(result,30);
        assertNotEquals(result,0);
    }
}