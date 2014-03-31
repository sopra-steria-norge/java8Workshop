package no.steria.javatime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;

import static java.time.Month.APRIL;
import static org.fest.assertions.Assertions.assertThat;

public class SimpleJavaTimeTest {

    @Test
    public void should_return_first_date() {
        LocalDateTime oneDate = LocalDateTime.of(2014, Month.JULY, 1, 0, 0);
        LocalDateTime anotherDate = LocalDateTime.of(2014, Month.AUGUST, 1, 0, 0);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.findEarliestDate(oneDate, anotherDate)).isEqualTo(oneDate);

    }

    @Test
    public void should_be_leap_year_in_2016() {
        LocalDateTime date = LocalDateTime.of(2016, Month.JULY, 1, 0, 0);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.isLeapYear(date)).isTrue();

    }

    @Test
    public void should_find_first_day_of_next_month() {
        LocalDate today = LocalDate.now();

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.getFirstDayOfNextMonth(today)).isEqualTo(LocalDate.of(2014, APRIL, 1));

    }

    @Test
    public void should_find_last_thursday_in_july_2014() {
        LocalDateTime date = LocalDateTime.of(2014, Month.JULY, 1, 0, 0);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();
        OffsetDateTime lastThursday = simpleJavaTime.lastThursdayOfMonth(date);

        assertThat(lastThursday.getDayOfMonth()).isEqualTo(31);
    }
}
