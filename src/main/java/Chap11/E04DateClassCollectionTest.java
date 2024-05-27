package Chap11;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class E04DateClassCollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		int myMoney = -5000;
		System.out.println(myMoney);
		
		DecimalFormat df = new DecimalFormat("#,###.##");
		System.out.println(df.format(myMoney));
		
//		DecimalFormat df2 = new DecimalFormat("0.0#E0");
		DecimalFormat df2 = new DecimalFormat("(수익)#,##0;(손실)#,##0");
		System.out.println(df2.format(5000000));
		System.out.println(df2.format(-50000));
		System.out.println(df2.format(0));
		
		DecimalFormat df3 = new DecimalFormat("##0%");
		System.out.println(df3.format(0.11));
		
		int users = 14638;
		int views = 1500;
		NumberFormat nf = CompactNumberFormat.getCompactNumberInstance();
		System.out.printf("구독자 %s\n",nf.format(users));
		System.out.printf("조회수 %s\n",nf.format(views));
		SimpleDateFormat f1 = new SimpleDateFormat("YYYY년 MM월 dd일 E요일 HH시 MM분 ss초");
		
		Date today = new Date();
		System.out.println("today:" +today);
		System.out.println(f1.format(today));
		
		LocalDate ldate = LocalDate.now();
		System.out.println(ldate);
		
		LocalDate ldate2 = LocalDate.parse("2027-05-26");
		System.out.println(ldate2);
		
		System.out.printf("%d년은 %s입니다.\n",ldate.getYear(), (ldate.isLeapYear()));
		System.out.printf("%d년은 %s입니다.\n",ldate2.getYear(), (ldate2.isLeapYear()));
		
		System.out.println(ldate.minusYears(1));
		
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		System.out.println(time1.getHour());
		
		LocalTime time2 = LocalTime.of(11, 20,11);
		System.out.println(time2.plusHours(1));
		
		LocalTime time3 = LocalTime.now(ZoneId.of("Asia/Colombo"));
		System.out.println(time3);
		
//		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		
		LocalDateTime time4 = LocalDateTime.now();
		System.out.println(time4);
		
		
		
		
		

	}

}
