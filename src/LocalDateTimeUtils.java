import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author tianpanke
 * @title: LocalDateTimeUtils
 * @projectName Test
 * @description: jdk1.8 LocalDateTime使用帮助类
 * @date 2019/7/11 15:42
 */
public class LocalDateTimeUtils {
    public static void main(String[] args) {
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime.toString());
    }
    private LocalDateTimeUtils(){}

    //获取当前月最后一天23:59:59 时间对象
    public static LocalDateTime getLastDayOfCurrentMonth(){
        LocalDate localDate=LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return LocalDateTime.of(localDate, LocalTime.of(23,59,59));
    }
    //DateTime转为LocalDateTime
    public static LocalDateTime convert(Date date){

        Instant.now();
        return null;
    }

}
