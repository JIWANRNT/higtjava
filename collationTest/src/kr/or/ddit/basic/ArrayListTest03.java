package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	/*
	 *  문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의
	 *       길이가 제일 긴 별명을 출력하시오.
	 *       (단, 각 별명의 길이는 모두 다르게 입력한디.)
	 *       
	 *  문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의
	 *       길이가 제일 긴 별명을 출력하시오.
	 *       (단, 각 별명의 길이가 같을수있다.)
	 */
	public static void main(String[] args) {
	
     Scanner sc = new Scanner(System.in);
	ArrayList<String> names = new ArrayList<>();

	System.out.println("별명을 입력하세요.");
	for(int i = 0; i <= 5; i++){
	System.out.println(i+"번째 사람 별명 입력 >>");
		String name = sc.nextLine();
		names.add(name);
		
	}
	System.out.println();
	//제일 긴 별명이 저장될 변수를 선언하고 이 변수에
	// list의 첫번째 데이터로 초기화 한다.
	String maxAlais = names.get(0);
	
	for(int i=1;i<names.size();i++) {
		if(maxAlais.length() < names.get(i).length()) {
			maxAlais = names.get(i);
		}
	}
	System.out.println("제일 긴 별명: " + maxAlais);
	
	
	}}

	
