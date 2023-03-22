package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoNumber {
public static void main(String[] args) {
	
	ArrayList<Integer>num;
	ArrayList<Integer>user;
	
	while(true) {
	   Scanner sc = new Scanner(System.in);
     	while(true) {
		System.out.println("=====================");
		System.out.println("     LOTTO 대박 프로그램 ");
		System.out.println("---------------------");
		System.out.println("      1. 번호 받기      ");
		System.out.println("      2. 프로그램 종료    ");
		System.out.println("======================");
		System.out.println("메뉴선택하기");
		int a = sc.nextInt();
		if(a==1){
			System.out.println("LOTTO 번호!");
			System.out.println("1000원에 번호 하나입니다.");
			System.out.println("지불 금액:");
			int Money = sc.nextInt();
			if(Money<1000) {
				System.out.println("금액이 적습니다 구매 실패!");
				  continue;
			}else if(Money>100000) {
				System.out.println("금액이 너무 많습니다 구매 실패!");
                   continue;
			}
			int count = Money/1000;
			System.out.println("대박 번호입니다!");
			Random rnd = new Random();
			for(int i=0; i<count; i++) {
				HashSet<Integer> testSet = new HashSet<>();
				while(testSet.size()<6) {
			
					testSet.add(rnd.nextInt(45)+1);
				
				}
				System.out.println("대박번호" + (i+1)+ ":"+testSet);
			}
			System.out.println("받은 금액은"+ Money+"원 이고 거스름던은"+(Money -count*1000));
		}else {
			System.out.println("감사합니다");
		}
			
		
		
	}
}
}
}