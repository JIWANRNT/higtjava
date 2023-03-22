package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member>memList= new ArrayList<>();

		memList.add(new Member(1,"홍길동","010-4111-1111"));
		memList.add(new Member(5,"이순신","010-2222-1111"));
		memList.add(new Member(9,"성춘향","010-3333-1111"));
		memList.add(new Member(3,"강감찬","010-4444-1111"));
		memList.add(new Member(6,"일지매","010-4555-1111"));
		memList.add(new Member(2,"변학도","010-4666-1111"));

		System.out.println("정렬진...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");


		System.out.println("정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");

		//회원 번호를 기준으로 내림차순 정렬하여 출력하시오.
		//==> 외부 정렬 기준 클래스를 작성하여 처리한다. (클래스 이름 : sortNumDesc)

		Collections.sort(memList,new sortNumDesc());
		for(Member num : memList) {
			System.out.println(num);
		}
         System.out.println("-----------------------------------------------");
	}
}

class sortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		if(o2.getNum()- o1.getNum()>0) {
			return -1;
		}else if(o2.getNum()-o1.getNum()<0) {
			return 1;
		}else {
			return 0;
		}
	}
}



// Member클래스이 '회원이름'을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
// ==> Comparable인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num;         //회원번호
	private String name;     //회원이름
	private String tel;      //전화번호

	//생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	public int compareTo(Member mem) {
		return this.getName().compareTo(mem.getName());
	}


}

// Comparable

//java.lang package
//객체의 정렬기준을 정해줄 때 사용한다.
//Comparable 인터페이스의 구현체는 compareTo메서드를 구현해야 한다.

//Comparator

//java.util package
//이미 정해진 정렬기준 외 다른 정렬기준을 사용하고 싶을때 사용한다.
//Comparator 인터페이스의 구현체는 compare메서드를 구현해야 한다.
//Comparator 인터페이스의 구현체는 그 자체가 정렬자로 사용된다. (정렬기준)


//Member의 회원번호(num)의 내림차순으로 정렬하는 외부 정렬 기준 클래스
  class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		/*if(mem1.getNum()>mem2.getNum()) {
		   return -1;
		}else if(mem1.getNum()<mem2.getNum()) {
			return 1;
		}else {
		
		return 0;
        	}
	}
	  
  */
  
   //return mem2.getNum()- mem1.getNum();
    
   //wrapper클래스를 이용하는 방법1
   //return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
	
	//wrapper클래스를 이용한 방법2	
    //return Integer.compare(mem1.getNum(),mem2.getNum()) * -1;
	
	 }
 }







