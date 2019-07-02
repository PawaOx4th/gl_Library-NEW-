package Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
public class delayTime {


        public static void main(String[] args) {

            LocalDate today = LocalDate.now();
//
//            //Get the Year, check if it's leap year
//            System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());
//
//            //Compare two LocalDate for before and after
//            System.out.println("Today is before 01/01/2015? "+today.isBefore(LocalDate.of(2015,1,1)));

            //Create LocalDateTime from LocalDate
            System.out.println("Current Time="+today.atTime(LocalTime.now()));


            System.out.println("7 days after today will be "+today.plusDays(7));//plus and minus operations
//            System.out.println("3 weeks after today will be "+today.plusWeeks(3));
//            System.out.println("20 months after today will be "+today.plusMonths(20));
//
//            System.out.println("10 days before today will be "+today.minusDays(10));
//            System.out.println("3 weeks before today will be "+today.minusWeeks(3));
//            System.out.println("20 months before today will be "+today.minusMonths(20));
//
//            //Temporal adjusters for adjusting the dates
//            System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
//            LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
//            System.out.println("Last date of this year= "+lastDayOfYear);
//
//            Period period = today.until(lastDayOfYear);
//            System.out.println("Period Format= "+period);
//            System.out.println("Months remaining in the year= "+period.getMonths());

//
                var LocalDate = java.time.LocalDate.now();
    //        DateTimeFormatter dateFormatter4 = DateTimeFormatter.ofPattern("dd-LL-yyyy");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-LL-yyyy");
                System.out.println(LocalDate.format(dateTimeFormatter));


        }
    }

