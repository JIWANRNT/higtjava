package kr.or.ddit.basic;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kr.or.ddit.basic.StudnetTest.setRanking.StudentTest.student;

/*
   문제) 학번, 이름, 국어점수, 영어점수, 총점, 등수를 멤버로 갖는
      student클래스를 만든다.
      이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 인수로 받아서
      초기화 처리를 한다.
      
      이 Stuedent객체는 List에 저장하여 관리한다.
      
      List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
      총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준도
      구현하여 정렬된 결과를 출력하시오.(클래스명 : sortByTotal
      
      (등수는 List에 전체 데이터가 추가된 후에 구해서 저장한다.)
 */
public class StudentTest{ 
   public void setRanking(List<student> studentlist) {
	   for(student std1 : studentlist) {
		   int rank =1;
		   
		   for(student std2 : studentlist) {  // 비교 대상 나타내는 반복문
              
			   //기준값보다 큰 값을 만나면 rank변수값을 증가 시킨다.
			   if(std1.getTotal()<std2.getTotal()) {
            	   rank++;
               }
		   }
		   //구해진 등수를 Student객체의 rank변수에 저장한다.
		   std1.setPri(rank);
   }
   }
public class setRanking(List<student> studentlist) {
	 
 }


public class StudentTest {
public static void main(String[] args) {
	ArrayList<student>stdlist= new ArrayList<>();
	stdlist.add(new student(1, "철수", 20,30,40));
	stdlist.add(new student(1, "철수", 20,30,40));
	stdlist.add(new student(1, "철수", 20,30,40));
	
	
	System.out.println("정렬전...");
	for(student std : stdlist) {
		System.out.println(std);
}
	System.out.println("--------------------------");
}

public class sortByTotal implements Comparator<student>{

		
		 
	
}

class student implements Comparable<student>{
	   private int num;
	    private String name;
	   private int korean;
	   private int english;
	   private int math;
	   private int total;
	   private int pri;
	@Override
	public int compareTo(student mem1 ) {
		
		return this.getNum()-mem1.getNum();
			
		
	}
	
	
	public student(int num, String name, int korean, int english, int math) {
		this.num = num;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.total= korean+english+math;
	}


	public synchronized int getNum() {
		return num;
	}

	public synchronized void setNum(int num) {
		this.num = num;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	



	public synchronized int getTotal() {
		return total;
	}


	public synchronized void setTotal(int total) {
		this.total = total;
	}


	public synchronized int getPri() {
		return pri;
	}


	public synchronized void setPri(int pri) {
		this.pri = pri;
	}


	@Override
	public String toString() {
		return "student [num=" + num + ", name=" + name + ", korean=" + korean + ", english=" + english + ", math="
				+ math + ", total=" + total + ", pri=" + pri + "]";
	}


	public int comparTo(student std) {
		return Integer.compare(this.getNum(), std.getNum);
	}
	}
class SortByTotal implements Comparator<student>{	  

public int compare(student std1,student std2) {
         if(std1.geTotal() == std2.getTot()) {
        	 return std1.getName().compareTo(std2.getName());
         }else {
        	 return Integer.compare(std1.getTOP(), std2.getTot())*1;
         }
	
	return 0;
}

}
}
   
}