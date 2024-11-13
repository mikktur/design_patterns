package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface newDate = new CalendarToNewAdapter();
        newDate.setDay(13);
        newDate.setMonth(11);
        newDate.setYear(2024);
        System.out.println(newDate);
        newDate.advanceDays(10);
        System.out.println(newDate);
        newDate.advanceDays(25);
        System.out.println(newDate);
    }
}
