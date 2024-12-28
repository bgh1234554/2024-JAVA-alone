package StudyJavaAlone;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss a zzz");
        System.out.println(sdf.format(date));
        System.out.println(date.getTime());
        System.currentTimeMillis(); //system의 현재시간을 long값으로 출력함.
        //Calendar는 추상메서드임.
        Date bb = new Date();
        System.out.println(bb.toString());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        System.out.println(sdf2.format(bb));

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; //0~11로 반환함.
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int hour1 = cal.get(Calendar.HOUR);
        int hour = cal.get(Calendar.HOUR_OF_DAY); //24h
        int minute = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        ArrayList<String> amPm = new ArrayList<String>();
        amPm.add("오전"); amPm.add("오후");
        int ap = cal.get(Calendar.AM_PM);
        cal.add(Calendar.HOUR,5);

        LocalDateTime timepoint = LocalDateTime.now();
        LocalDate localDate = LocalDate.of(2025, 12, 25);
        System.out.println(localDate);
        LocalTime lt1 = LocalTime.of(17, 18);
        LocalTime lt2 = LocalTime.parse("10:15:31");
        LocalDate theDate = timepoint.toLocalDate();
        System.out.println(timepoint.getMonth().toString());
    }
}
