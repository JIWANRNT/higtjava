package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

//제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의
//      길이가 제일 긴 별명을 출력하시오.
//      (단, 각 별명의 길이가 같을수있다.)
public class ArrayListTest04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();

		System.out.println("별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "번째 사람 별명 입력 >>");
			String name = sc.nextLine();
			names.add(name);
		}
		System.out.println();
		// 제일 긴 별명의 길이가 저장될 변수를 선언하고
		// list의 첫번째 데이터의 길이로 초기화 한다.
		int maxLength = names.get(0).length();

		for (int i = 0; i < names.size(); i++) {
			if (maxLength < names.get(i).length()) {
				maxLength = names.get(i).length();
			}
		}

		System.out.println("제일 긴 별명");

		for (String name : names) {
			if (name.length() == maxLength) {
				System.out.println(name);
			}

		}
	}

}
