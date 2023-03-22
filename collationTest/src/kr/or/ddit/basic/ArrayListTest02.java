package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
  문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
       이 ArrayList에 저장된 이름들 중에 '김'씨 성의 이름을 찾아
       모두 출력하시오.
       (단, 입력은 scanner객체를 이용한다.)
 * 
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> names = new ArrayList<>();
		
		System.out.println("이름을 입력하세요.");
		for(int i = 0; i < 5; i++){
		System.out.println(i+"번째 사람 이름 입력 >>");
			String name = sc.nextLine();
			names.add(name);
		}
		System.out.println();
		
		System.out.println("김씨 성을 가진 사람들...");
		
	
		for(int i = 0; i < names.size(); i++){
			if(names.get(i).charAt(0) == '김'){
			 System.out.println(names.get(i));
			}
		}
		
	  //if(names.get(i).substring(0.1).equals("김")) {
		//  System.out.println(names.get(i));
	}
		//if(names.get(i).indexOf("김")==0) {
		  //System.out.println(names.get(i));

	
	
        //if(names.get(i).starsWith("김")) {
        	 //System.out.println(names.get(i));
        }
        //  if(names.get(i).contains("김")) {
        	//System.out.println(names.get(i)); //ex) 이박김 => 이것도 포함시킴
        
          
         
      
