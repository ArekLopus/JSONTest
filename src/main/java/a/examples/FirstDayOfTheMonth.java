package a.examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstDayOfTheMonth {

	public FirstDayOfTheMonth() {
		
		System.out.println(Arrays.asList(Month.values()));
		
		String firstMondayOfTheMonth = Stream.of(Month.values()).
                map(month -> LocalDate.of(2019, month, 1)).
                map(month -> month.with(firstInMonth(DayOfWeek.MONDAY))).
                map(firstMonday -> firstMonday.getMonth() + ", " + firstMonday.getDayOfMonth()).
                collect(Collectors.joining("\n"));
        System.out.println(firstMondayOfTheMonth);
		
	}
	
	public static void main(String[] args) {
		new FirstDayOfTheMonth();
	}
}
