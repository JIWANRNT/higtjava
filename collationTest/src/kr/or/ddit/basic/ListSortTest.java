package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  - 정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
  
  - Comparable은 Collection에 추가되는 데이터 자체에 정렬 가주을 넣고 싶을 때 구현하는
    인터페이스이다.( 내부 정렬 기준을 작성할 때 사용)
  - Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스이다.
    (외부 정렬 기준이라 한다.)
   
  - Comparable에서는 compareTo()메서드를 재정의 하고,
    Comparator에서는 compare()메서드를 재정의 해야 한다.
    
  - String클래스, Wrapper클래스들, Date클래스, File클래스에는 내부 정렬 기준이 구현되어 있다.
    (내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있다.)
   
   comparator 는 내림차순일때 많이쓴다(외부)  
   comparable 은 오름차순일때 쓴다(내부)
 */

public class ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성충향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬전 : " + list);

		// list의 정렬은 collections.sort()매서드를 이용해서 정렬한다.
		// collerction.sort()매서드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);

		System.out.println("정렬후 : " + list);

		Collections.shuffle(list); // 자료 섞기
		System.out.println("자료 섞기 후:" + list);

		// 외부 정렬 기준을 적용해서 정렬하기
		Collections.sort(list, new Desc());

		System.out.println("내림차순 정렬후 : " + list);

	}
}


interface a {
	public void a();
}

// 정렬 방식을 정해주는 class를 작성한다. (이것을 외부 정렬 기준 클래스라고 한다.)
// comparator인터페이스를 구현해서 작성한다.
class Desc implements Comparable<String>, Comparator<String>{

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 1;
	}
	// compare()메서드를 이용해서 정렬하고자 하는 기준을 정해준다.

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	// compare()메서드의 반환값과 그 의미
	// -0은 두 값이 같다.
	// -양수는 앞, 뒤의 순서를 바꾼다.
	// -음수는 앞, 뒤의 순서를 바꾸지 않는다.

	// 예) 오름차순일 경우 ==> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 적으면 음수를 반환하도록
	// 구현하면 된다.






}
