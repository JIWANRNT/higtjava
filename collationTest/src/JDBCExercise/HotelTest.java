package JDBCExercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelTest {
	private Map<Integer,Room>hotelMap;
	private Scanner scan;
	
	public HotelTest() {
		hotelMap=new HashMap<>();
		scan= new Scanner(System.in);
  //객실초기화
	   for(int i=2;i<=4;i++) {
		   String roomType = null;
		   
		   switch(i) {
		   case 2 : roomType ="싱글룸"; break;
		   case 3 : roomType = "더블룸"; break;
		   case 4 : roomType = "스위트룸"; break;
		   }
		   
		   for(int j=1; j<9;j++) {
			   int roomNum = i * 100 + j;
			   hotelMap.put(roomNum, new Room(roomNum,roomType));
		   }
	   }
	}  //    생성자 끝...
	
    public static void main(String[] args) {
    	new HotelTest().hotelStart();
	
	
	
}
	public void hotelStart() {
		System.out.println("-------------------------");
		System.out.println("호텔 시작");
		System.out.println("-------------------------");
	
	   while(true) {
		   int ch = displayMenu();
		   
		   switch(ch) {
		   case 1 : checkIn();                 //체크인    
			   break;
		   case 2 : checkOut();               //체크아웃    
			   break;
		   case 3 : printRoomState();               //객실 상태 출력   
			   break;
		   case 4 :    
			   System.out.println("호텔 문 닫음");
			   System.out.println("호텔 문 닫음");
			   System.out.println("호텔 문 닫음");
			   return;
		   default : System.out.println("작업 번호를 잘못 입력했습니다. 다시입력하세요...");
		   }
	   }
	}
	
	//객실 상태 출력하기
	private void printRoomState() {
		//방번호를 오름차순으로 출력하기 위해서 방번호(Map의 key값)만 list에 넣어서 정렬한다.
	   ArrayList<Integer>roomNumList = new ArrayList<>(hotelMap.keySet());
	   
	   Collections.sort(roomNumList);
	   
	   System.out.println("현재 객실 상태");
	   System.out.println("방 번호   방종류    투수객이름");
	   
	   //List에서 방번호를 하나씩 꺼내와 map에서 해당 방번호에 짝이되는 Room객체를 구해서 출력한다.
	   for(int roomNum : roomNumList) {
		   Room r = hotelMap.get(roomNum);
		   System.out.print(r.getNum()+ "\t");
		   System.out.print(r.getType()+ "\t");
		   
		   System.out.print(r.getName()==null ? "-": r.getName());
	   }
	System.out.println("----------------------------");
	}
	
	
       //체크아웃 메서드
	private void checkOut() {
		System.out.println("체크아웃");
		System.out.println("방번호입력");
		
		int num = scan.nextInt();
		
		// 입력한 방이 존재하는지 여부 검사
		//(Map의 key값이 방번호이므로 입력한 방번호가 key값에 존재하는지 여부 검사)
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"객실은 노존재");
			return;
	}
		// 입력한 방번호 객실에 손님이 없는지 여부 검사
		if(hotelMap.get(num).getName()==null) {
			System.out.println(num + "호 객실에 체크인 한 사람이 없음");
			return;
		}
		
		String name = hotelMap.get(num).getName();  //현재 투수객 이름 구하기
		
		// 체크 아웃 작업은 해당 객실의 투숙객 이름에 null값을 넣어주면 된다.
		hotelMap.get(num).setName(null);
		
		System.out.println(num + "호 객살의" + name + "님이 체크아웃을 완료했습니다...");
		
	}
	   //체크인 메서드
	private void checkIn() {
		System.out.println("체크인");
		System.out.println("201`209   싱글");
		System.out.println("301`309   더불");
		System.out.println("401`409   스위트");
		System.out.println("방 번호 입력");
		
		int num =scan.nextInt();
		
		// 입력한 방이 존재하는지 여부 검사
		//(Map의 key값이 방번호이므로 입력한 방번호가 key값에 존재하는지 여부 검사)
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"객실은 노존재");
			return;
		}
		// 입력한 방번호 객실에 손님이 있는지 여부 검사
		if(hotelMap.get(num).getName()!=null) {
			System.out.println(num + "호 객실에 이미 손님이 있습니다");
			return;
			
		}
		System.out.println();
		System.out.println("누구를 체크인 하사겠습니까");
		System.out.print("이름 >");
		String name = scan.next();
		
		//입력받은 투수객 이름을 해당 객실의 투숙객 명단에 넣는다.
		hotelMap.get(num).setName(name);
		
		System.out.println(num+"호객실에"+name+"씨 체크인 완료");
		
		
		
	}
	
	
	
	
      // 메뉴 출력하고 사용자가 입력한 작업 번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println("메뉴");
		System.out.println("1체크인 2체크아웃 3객실상태 4업무종료");
		System.out.println("선택");
        return scan.nextInt();
            
	}
	
	
	
	
	
	

}
 class Room{
	 private int num;   //방번호
	 private String type;  //방종류
	 private String name;  //투수객 이름
	 
    //생성자 
	public Room(int num, String type) {
		super();
		this.num = num;
		this.type = type;
	}
	
	public Room() {
		super();
	
	}
           
	public synchronized int getNum() {
		return num;
	}

	public synchronized void setNum(int num) {
		this.num = num;
	}

	public synchronized String getType() {
		return type;
	}

	public synchronized void setType(String type) {
		this.type = type;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [num=" + num + ", type=" + type + ", name=" + name + "]";
	}
 
	 
 
}
