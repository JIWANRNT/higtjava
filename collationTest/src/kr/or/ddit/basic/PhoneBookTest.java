package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
  문제)이름,주소,전화번호를 맴버로 갖는 phone클래스를 만들고
      Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
      -Map의 구조: key값은 입력한 '이름'으로 사용하고
                 value값은 phone클래스의 인스턴스로 한다.
      HaspMap<String, Phone> 변수명;
      
      
       -아래의 메뉴를 구현한다.
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
   ------------------------------------------------------   
     
     -삭제, 검색 기능은 '이름'을 입력 받아 처리한다.
     
     실행예시)
     --------------------------------
       다음 메뉴를 선택하세요.
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
     ----------------------------------
     번호입력 >> 1
     
     새롭게 등록할 전화번호 정보를 입력하세요.
     이 름 >> 홍길동
     전화번호 >> 010-1111-1111
     주 소 >> 대전시 유성구 원내동
     
     '홍길동'씨의 전화번호 정보가 등록되었습니다.
     
     --------------------------------
       다음 메뉴를 선택하세요.
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
     ----------------------------------
     번호입력 >> 1
      이름>> 홍길동
      
     '홍길동'은 이미 등록된 사람입니다.
      
      
      --------------------------------
       다음 메뉴를 선택하세요.
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
     ----------------------------------
     번호입력 >>  5
     
     -------------------------------------------------------
     번호         이름          전화번호                주소
      1        '홍길동'      010-1111-1111     대전시 유성구 원내동
      ~         
      ~
      -------------------------------------------------------
  
      --------------------------------
       다음 메뉴를 선택하세요.
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
     ----------------------------------
     번호입력 >>  0
    
     프로그램을 종료합니다..

 
 */
public class PhoneBookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Phone> map = new HashMap<>();
		int a;
		String name;
		String num;
		String addr;
		out: while (true) {
			System.out.println("--------------------------------");
			System.out.println(" 다음 메뉴를 선택하세요");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("--------------------------------");
			System.out.println("번호입력>>");
			a = sc.nextInt();
			sc.nextLine();
			switch (a) {
			case 1:
				System.out.print("등록할 정보를 입력해주세요");
				System.out.print("이름>>");
				name = sc.nextLine();
				if (map.containsKey(name)) {
					System.out.println("이미 존재하는 이름입니다.");
					break;
				}
				System.out.print("전화번호>>");
				num = sc.nextLine();
				System.out.print("주소>>");
				addr = sc.nextLine();
				map.put(name, new Phone(name, addr, num));
				System.out.println("등록이 완료 되었습니다.");
				break;
			case 2:
				System.out.println("정보를 수정합니다");
				System.out.println("수정할 이름을 선택하세요");
				name = sc.nextLine();
				if (map.containsKey(name)) {

				System.out.println("수정할 주소를 입력해주세요");
				addr = sc.nextLine();
				System.out.println("수정할 번호를 입력하세요");
				num = sc.nextLine();
				map.put(name,new Phone(name, addr, num));
				}else { 	
					System.out.println(name + "은 없는 사람입니다.");
				}
				System.out.println("수정이 완료되었습니다.");
				break;
			case 3:
				System.out.println("삭제 할 정보를 입력하세요>>");
				name = sc.nextLine();
				map.remove(name);
				System.out.println(name + "정보가 삭제되었습니다.");
				break;
			case 4:
				System.out.println("이름으로 검색합니다");
				name = sc.nextLine();
				if (map.containsKey(name)) {
					Phone p = map.get(name);
					System.out.println(p.getName());
					System.out.println(p.getNum());
					System.out.println(p.getAddr());
					
				} else {
					System.out.println("정보가 존재하지 않습니다.");
				}
				break;

			case 5:
				System.out.println("전화번호를 전체 출력합니다");
				for (String key : map.keySet()) {
					Phone value = map.get(key);
					System.out.println(
							"이름 : " + value.getName() + " 주소 : " + value.getAddr() + "전화번호 : " + value.getNum());
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
				break out;
			}

		}
	}
}

class Phone {
	private String name;
	private String addr;
	private String num;
	
	

	public Phone(String name, String addr, String num) {
		this.name=name;
		this.num=num; 
		this.addr=addr;
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
