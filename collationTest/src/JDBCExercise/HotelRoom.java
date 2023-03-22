package JDBCExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelRoom {
public static void main(String[] args) {
	
	Room r = new Room();
	r.run();
	
	
	
}
}

  class Room{
	      private int num;
	      private String Room;
	      private String name;
		public Room(int num, String room, String name) {
			super();
			this.num = num;
			Room = room;
			this.name = name;
		}
		public Room() {
			
		}
	  public void run() {
		  Map<Integer,Room>map = new HashMap<>();
		  initialRoom(map);
		  Scanner sc = new Scanner(System.in);
		  out:while(true) {
			  System.out.println("==========================");
			System.out.println("   호텔문이 열렸습니다.");
			System.out.println("==========================");
			System.out.println("1. 체크인 2. 체크아웃 3. 객실상태 4. 업무종료");
			System.out.println("==========================");
	       int sel = Integer.parseInt(sc.nextLine());
	       switch (sel) {
		case 1 :
			   checkIn(map,sc);
			   break;
		case 2 :	
               checkOut(map,sc);
               break;
		case 3 :
			   state(map);
			   break;
		case 4 :
			System.out.println("프로그램 종료");
			  break out;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
			
	       }
		  }
  }
	private void checkOut(Map<Integer, Room> map, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("==========================");
		System.out.println("   체크아웃 작업");
		System.out.println("==========================");
		System.out.print("체크아웃할 방 번호을 입력하세요.");
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>200&&210>sel||sel>300&310>sel||sel>400&&410>sel)) {
			System.out.println(sel+"호 객실은 존재하지 않습니다.");
			return;
		}
		if(map.get(sel).getName().equals("-")) {
			System.out.println(sel+"호 객실은 체크인 한 사람이 없습니다");
			return;
		}
		Room room=map.get(sel);
		String name=room.getName();
		room.setName("-");
		
		map.put(sel, room);
		System.out.println(sel+"호 객실으;" + name+ "님 체크아웃을 완료했습니다");
		
	}
		
	private void state(Map<Integer,Room>map) {
		System.out.println("==========================");
		System.out.println("   현재 객실 상태");
		System.out.println("==========================");
		
		for(int i=1; i<10; i++) {
		System.err.println(map.get(Integer.parseInt("20"+i))); 
		}
		for(int i=1; i<10; i++) {
			System.err.println(map.get(Integer.parseInt("30"+i))); 
		}
			for(int i=1; i<10; i++) {
				System.err.println(map.get(Integer.parseInt("40"+i))); 
			}		
			
		
		
	}
	public void checkIn(Map<Integer,Room>map,Scanner sc) {
		System.out.println("==========================");
		System.out.println("체크인 작업");
		System.out.println("*201~209: 싱글룸 ");
		System.out.println("*301~309: 더블룸 ");
		System.out.println("*401~409: 스위트룸 ");
		System.out.println("==========================");
		System.out.print("방번호 입력:");
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>200&&210>sel||sel>300&&310>sel||sel>400&&410>sel)){
			System.out.println(sel+"호 객실은 존재하지 않습니다");
			return;
		}
		if(!map.get(sel).getName().equals("-")) {
			System.out.println(sel+"호 객실은 이미 손님이 있습니다");
			return;
		}
		System.out.println("누구를 체크인 하시겟습니까?");
		System.out.println("이름 입력:");
		String name =sc.nextLine();
		String room=map.get(sel).getRoom();
		map.put(sel, new Room(sel,room,name));
		System.out.println("체크인이 완료되었습니다");
				
	}
	
	public void initialRoom(Map<Integer,Room>Map) {
		for(int i=1; i<10;i++) {
			Map.put(Integer.parseInt("20"+i),new Room(Integer.parseInt("20"+i),"싱글룸","-"));
		}
		for(int i=1;i<10;i++) {
			Map.put(Integer.parseInt("30"+i),new Room(Integer.parseInt("30"+i),"더블룸","-"));
		}
	    for(int i=1;i<10;i++) {
	    	Map.put(Integer.parseInt("40"+i),new Room(Integer.parseInt("40"+i),"스위트룸","-"));
	    }
	}
	public synchronized int getNum() {
		return num;
	}
	public synchronized void setNum(int num) {
		this.num = num;
	}
	public synchronized String getRoom() {
		return Room;
	}
	public synchronized void setRoom(String room) {
		Room = room;
	}
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Room [num=" + num + ", Room=" + Room + ", name=" + name + "]";
	}
     
  }
	
	
	