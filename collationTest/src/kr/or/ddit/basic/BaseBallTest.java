package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
   문제) set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
       (컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9사이의 값 3개)
       (스트라이크는 S, 볼은 B로 나타낸다.)
   예시)
       컴퓨터 난수 ==> 9 5 7
       
       실행예시)
         숫자입력 >> 3 5 6
         3 5 6 ==> 1s 0b
         숫자입력 >> 7 8 9
         7 8 9 ==> 0s 2b
         숫자입력 >> 9 7 5
         9 7 5==> 1s 2b
         숫자입력 >> 9 5 7
         9 5 7 ==> 3s!!
        
         축하합니다...
         당신은 4번째 만에 맞췄습니다...
 */

public class BaseBallTest {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random rnd = new Random();
  
	HashSet<Integer> game = new HashSet<>();
	while(game.size()<3) {
		game.add(rnd.nextInt(9)+1);
	
		System.out.println("컴퓨터 난수:" + game);
	}ArrayList<Integer>List = new ArrayList<>(game);
	  boolean good = true;
      int count =0;
          while(good) {
        	  int str =0;
              int ball =0;
	         System.out.println("숫자입력>>");
	         int a =sc.nextInt();
	         System.out.println("숫자입력>>");
	        int b = sc.nextInt();
	        System.out.println("숫자입력>>");
	         int c= sc.nextInt();
    
          
	         if(a==List.get(0)) {
	        	 str++;
	         }if(b==List.get(1)) {
	        	 str++;
	         }if(c==List.get(2)) {
	        	 str++;
	         }if(a==List.get(1)||a==List.get(2)){
	        	 ball++;
	         }if(b==List.get(0)||b==List.get(2)) {
	        	 ball++;
	         }if(c==List.get(0)||b==List.get(1)) {
	        	 ball++;
	        	 System.out.printf("%dS %dB\n",str,ball);
	        	 count++;
	        	 if(str==3) {
	        		 System.out.println("축하합니다. 당신은"+ count+"번째로 맞췄습니다");
	        		 good = false;
	         }
	
		
          }
	}
	
}


	
}



	
	
	
	


