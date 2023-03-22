package JDBCExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class HorseGame {
public static void main(String[] args) {
	Horse[] horseArr = new Horse[] {
		new Horse("01번말"),	
		new Horse("02번말"),	
		new Horse("03번말"),	
		new Horse("04번말"),	
		new Horse("05번말"),	
		new Horse("06번말"),	
		new Horse("07번말"),	
		new Horse("08번말"),	
		new Horse("09번말"),	
		new Horse("★10번말"),	
	};
	GameState gs = new GameState(horseArr);
	
	for(Horse h : horseArr) {
		h.start();
	}
	gs.start();      // 말들의 현재 위치를 출력하는 쓰레드 시작
	
	for(Horse h : horseArr) {
	
	try {
		h.join();
	} catch (InterruptedException e) {
		// TODO: handle exception
	}
	}
	try {
		gs.join();
	} catch (InterruptedException e) {
		// TODO: handle exception
	}
           System.out.println();
           System.out.println("경기 끝!");
	       System.out.println();
	       
	    // 등수의 오름차순으로 정렬하기
	     Arrays.sort(horseArr);        // 배열 정렬하기
	       
	
	       for(Horse h : horseArr) {
	   		System.out.println(h);
	   	}
  }


}


class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;   //말의 등수를 구할 떄 사용할 변수
	
	private String horsename;      //말이름
	private int rank;         //등수
	private int location;     //현재 위치
	
	
	// 생성자
	public Horse(String horsename) {
		super();
		this.horsename = horsename;
	}


	public String getHorseName() {
		return horsename;
	}


	public void setHorseName(String horsename) {
		this.horsename = horsename;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "경주마" + horsename + "는(은)=" + rank + "등 입니다";
	}
	
	// 등수의 오름차순 정렬 내부 기준 
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}
	
	@Override
	public void run() {
		Random rnd = new Random();
        for(int i=1;i<=50;i++) {
        	this.location = i;    //말의 현재위치 저장
        	try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
		
			}
        
        }
	     // 한 마리의 말의 경주가 끝나면 현재의 등수를 구해서 저장한다.
	   currentRank++;
	   this.rank = currentRank;
	   
	}
	
}

/*
 경기 중간 중간에 각 말들의 위치를 아래와 같이 출력하는 쓰레드
   예시)
   말이름01: --->-----------------------------------
   말이름02: ----->---------------------------------
   말이름03: -->------------------------------------
   ...
   말이름10: ------------>--------------------------
  
 */
class GameState extends Thread{
	private Horse[] horseArr;   // 경주에 참가한 말들의 정보 저장될 배열 변수 선언

	//생성자
	public GameState(Horse[] horseArr) {
		super();
		this.horseArr = horseArr;
	}
	@Override
	public void run() {
	while(true) {
		// 모든 말의 경주가 끝났는지 여부 검사
		if(Horse.currentRank==horseArr.length) {
			break;
		}
		for(int i=1; i<=6; i++) {
			System.out.println();
		}
		
		for(int i=0;i<horseArr.length; i++) {
			System.out.print(horseArr[i].getHorseName()+":");
	       
			for(int j=1; j<=50; j++) {
				if(horseArr[i].getLocation()==j) { //말의 현재위치 찾기
					System.out.print(">");
				}else {
				System.out.print("-");
			}
			System.out.println();
		}
	   try {
		       Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO: handle exception
	}
				
   }
	}
	
	}
	}







