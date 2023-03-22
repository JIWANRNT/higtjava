package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class test {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<>();
	int a;
	String name;
	String num;
	String addr;
	out: while (true) {
		System.out.println("-------------------------");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 출력");
		System.out.println("0. 끝");
	   System.out.println("번호를 입력해>>");
	   a = sc.nextInt();
	   sc.nextLine();
	   switch (a) {
	   case 1:
		   System.out.println("등록할 정보를 입력");
		   System.out.println("이름 >");
		   name = sc.nextLine();
		   if(map.containsKey(name)) {
			   System.out.println("이미 존재하는 이름");
			   break;
			   
		   }
		   System.out.println("전화번호>");
		   num = sc.nextLine();
		   System.out.println("주소>>");
		   addr = sc.nextLine();
		   map.put(name, new Phone(name, addr, num));
		   System.out.println("등록이 완료");
		   break;
	   case 2:
	       System.out.println("정보를 수정합니다");
	       System.out.println("수정할 이름을 선택하세요");
	       name = sc.nextLine();
	       if(map.containsKey(name)){
	    	   
	    	System.out.println("수정할 주소를 입력해주세여");
	    	addr = sc.nextLine();
	    	System.out.println("수정할 번호를 입력해주세요");
	    	num = sc.nextLine();
	       map.put(name, new Phone(name, addr, num));
	   }else {
		   System.out.println(name + "은 없는 사람입니다.");
	   }
	   System.out.println("수정이 완료되었습니다.");
	    break;
	    case 3 :
	    	System.out.println("삭제 할 정보를 입력하세요>>");
	         name = sc.nextLine();
	         map.remove(name);
	         System.out.println(name + "정보가 삭제되었습니다");
	         break;
	    case 4:
	    	System.out.println("이름으로 검색합니다");
	    	name = sc.nextLine();
	    	if(map.containsKey(name)) {
	    		Phone p = map.get(name);
	    		System.out.println(p.getName());
	    		System.out.println(p.getNum());
                System.out.println(p.getAddr());
	    	}else {
	    		System.out.println("정보가 존재하지 않습니다");
	    	}
	    	break;
	    case 5 :
	    	System.out.println("전화번호를 전체 출력합니다");
	    	for(String key :map.keySet()) {
	    		Phone value = map.get(key);
	    		System.out.println(
	    				"이름:"+value.getName()+"주소:"+value.getAddr()+"번호"+value.getNum());
	    	}
	    	break;
	    case 0 :
	    	System.out.println("프로그램 종료");
	    	break out;
	   }
	
}
}
}
class Phone{
	private String name;
	private String addr;
    private String num;
    
    public Phone(String name, String addr, String num) {
    	this.name=name;
    	this.addr=addr;
    	this.num=num;
    }

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getAddr() {
		return addr;
	}

	public synchronized void setAddr(String addr) {
		this.addr = addr;
	}

	public synchronized String getNum() {
		return num;
	}

	public synchronized void setNum(String num) {
		this.num = num;
	}
}