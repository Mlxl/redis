package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String args[]){
		Connect con=new Connect();
		Iterator<NodeInfomation> it=con.getInfomation().iterator();
		while(it.hasNext()){
			NodeInfomation no=it.next();
			System.out.print(no.getID());
			System.out.print(no.getlocation());
			System.out.print(no.getRoles());
			System.out.print(no.getMasterID());
			System.out.println(no.getSlotf());	
		}
	}
}
