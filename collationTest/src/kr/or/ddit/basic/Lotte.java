package kr.or.ddit.basic;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotte {
   private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	   new Lotte().LotteStart();
	
}
	
	public void LotteStart() {
	   while(true) {
		   int choice = displayMenu();
	       switch(choice) {
	       case 1 :
	    	   buyLotto();
	    	   break;
	       case 2 : 
	    	   System.out.println("감사합니다...");
	    	   return;
	       default :
	    	   System.out.println("번호를 잘못 입력했습니다");
	           System.out.println("1 또는 2를 입력해주세요...");
	       }
	   }
	}
	
	//메뉴 출력하고 사용자가 입력한 값을반환하는 메서드
	private int displayMenu() {
	System.out.println();
	System.out.println("=====================");
	System.out.println("     LOTTO 대박 프로그램 ");
	System.out.println("---------------------");
	System.out.println("      1. 번호 받기      ");
	System.out.println("      2. 프로그램 종료    ");
	System.out.println("======================");
	System.out.println("메뉴선택하기>>");
	
	return sc.nextInt();
}
	// 로또를 판매를 처리하는 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println(" 행운의 번호 시작");
		System.out.println();
		System.out.println("1000원에 번호는 하나입니다");
		System.out.println("금액 입력 :");
		int money = sc.nextInt();
	
	    System.out.println();
	    if(money<1000) {
	    	System.out.println("입력 금액이 너무 적습니다 실패!");
	    	return;
	    }else if(money>=101000) {
	    	System.out.println("입력 금액이 너무 많습니다 실패!");
	        return;    
	    }
	    
	    // 로또 번호 만들기
	    HashSet<Integer> lottoSet = new HashSet<>();
	    Random rnd = new Random();
	    // 구매한 매수 계산 
	    int count = money/1000;
	    
	    System.out.println("행운의 번호는 아래와 같습니다.");
	    for(int i=1; i<=count; i++) {
	    	
	    	while(lottoSet.size()<6) {
	           lottoSet.add(rnd.nextInt(45)+1);
	    	}
	    	
	    	ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
	    	Collections.sort(lottoList);
	    	
	    	
	       System.out.print("로또번호" + i + " : ");
	       for(int j=0; j<lottoList.size(); j++) {
	    	   if(j>0)System.out.print(",");
	    	   
	       System.out.print(lottoList.get(j));
	       }
	       System.out.println();//줄바꿈
           lottoSet.clear();         //Set을 비워준다
	    
	    }//for(i) 문 끝...
	    System.out.println("받은 금액은" + money+"원이고 거스름돈은" + (money%1000) + "원 입니다.");
	
	    
	}

}