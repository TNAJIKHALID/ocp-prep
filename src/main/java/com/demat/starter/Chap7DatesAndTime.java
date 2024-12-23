package com.demat.starter;

import java.time.*;
import java.time.temporal.ChronoUnit;

/** Chap 5 */
public class Chap7DatesAndTime {
    public static void main(String[] args) {
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime now3 = LocalDateTime.now();
        ZonedDateTime now4 = ZonedDateTime.now();
        /*
        2023-04-16
        12:12:51.372755660
        2023-04-16T12:12:51.372980941
        2023-04-16T12:12:51.373473327Z[GMT]
         */
        LocalTime t3 = LocalTime.of(21, 50, 14, 145);
        // 21:50:14.000000145

        LocalDate d1 = LocalDate.of(2022, Month.NOVEMBER, 2);
        LocalDateTime dt2 = LocalDateTime.of(d1, t3);
        System.out.println(dt2);
        //2022-11-02T21:50:14.000000145

        ZoneId zone = ZoneId.of("Europe/Zagreb");
        ZonedDateTime z1 = ZonedDateTime.of(2022, 11, 2,
                21, 50, 14, 145, zone);
        System.out.println(z1);
        //2022-11-02T21:50:14.000000145+01:00[Europe/Zagreb]

        /*
        // for the exam, you need to know how to convert between time-zones:
        2022-11-02T13:50+05:30[<zone>]
        => GMT 2022-11-02 7:20
        2022-11-02T06:10-05:00[<zone>]
        => GMT 2022-11-02 11:20
        // just remember to substract the offset time
        // (substracting negative numbers is addition)
         */

        /*
          LocalDate, LocalDateTime [IMMUTABLE]
        • plusYears(), plusMonths(), plusWeeks(), plusDays()
        • minusYears(), minusMonths(), minusWeeks(), minusDays()
        • LocalTime, LocalDateTime IMMUTABLE
        • plusDays(), plusMinutes(), plusSeconds(), plusNanos()
        • minusDays(), minusMinutes(), minusSeconds(), minusNanos()
        • LocalDate, LocalTime, LocalDateTime
        • isBefore(), isAfter()
         */

        // Period can be used only with LocalDate and LocalDateTime
        // periods are used with plus/minus on date
        Period period = Period.of(1, 2, 5);
        LocalDate date = LocalDate.of(2022, 11, 20);
        date = date.plus(period);

        LocalTime t1 = LocalTime.of(17, 30);
        LocalTime t2 = LocalTime.of(20, 45);
        System.out.println(ChronoUnit.HOURS.between(t1, t2));

        LocalTime time = LocalTime.of(17, 30);
        Duration d3 = Duration.ofMinutes(45);
        time = time.plus(d3);


        // instants are used to record time-stamps in the application
        Instant now = Instant.now();

        Instant before = Instant.now();
        Instant after = Instant.now();
        Duration dur = Duration.between(before, after);


        ZonedDateTime z = ZonedDateTime.of(2022, 11, 2, 21, 50, 14, 145, zone);
        Instant inst = z.toInstant();
        System.out.println(inst);
        //2022-11-02T20:50:14.000000145Z
    }
}
