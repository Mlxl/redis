package view;


import java.util.*;
public class Test {
 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
   Set  set=new HashSet();
   Set  set1=new HashSet();
   set.add("abc");
   set.add("cde");
   set1.add("efg");
   set1.add("fgh");    
   set1.add("abc"); //重复的abc,set会自动将其去掉  
   set1.add(set);
   System.out.println("size="+ set1.size() );
    List list = new ArrayList();
    list.add("abc");
    list.add("aaa");
    list.add("fff");
    set.addAll(list); //将list中的值加入set,并去掉重复的abc
         System.out.println("size="+ set.size() );
        for( Iterator   it = set.iterator();  it.hasNext(); )
        {             
            System.out.println("value="+it.next().toString());            
        } 
 }   
}