package login;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {
	
	public static void main(String ...args) {
		Date D = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		try {
			D = format1.parse("Mon Apr 23 12:19:59 MDT 2018");
			System.out.println(D);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
}
