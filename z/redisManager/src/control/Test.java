package control;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test{
	public static void main(String args[]){
		StringBuffer s=new StringBuffer();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		for(int i=0;i<100;i++){
			s.append("sddddddddsfds");
		}
		s.toString();
		System.out.println(df.format(new Date()));
	}
}