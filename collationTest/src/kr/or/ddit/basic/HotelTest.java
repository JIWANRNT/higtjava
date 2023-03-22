package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {

	private static HashMap<Integer, Room> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);

	public HotelTest() {

		for (int a = 201; a <= 209; a++) {
			String b = "싱글룸";
			map.put(a, new Room(a, b, "-"));
		}

		for (int a = 301; a <= 309; a++) {
			String b = "더블룸";
			map.put(a, new Room(a, b, "-"));
		}

		for (int a = 401; a <= 409; a++) {
			String b = "스위트룸";
			map.put(a, new Room(a, b, "-"));
		}

	}

	public static void main(String[] args) {
		new HotelTest();
		Properties prop = new Properties();
		int a;
		int roomnum = 0;
		String room = null;
		String name;
		out: while (true) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
			System.out.println("-----------------------------------------------------------");
			System.out.println("선택>>");
			a = sc.nextInt();
			sc.nextLine();
			switch (a) {
			case 1:
				System.out.println("----------------------------------------------");
				System.out.println("   체크인 작업");
				System.out.println("----------------------------------------------");
				System.out.println(" * 201~209 : 싱글룸");
				System.out.println(" * 301~309 : 더블룸");
				System.out.println(" * 401~409 : 스위트룸");
				System.out.println("---------------------------------------------");
				System.out.println("방 번호 입력 >>");
				roomnum = sc.nextInt();
				if (!map.containsKey(roomnum)) {
					System.out.println("객실이 존재하지 않습니다.");
					continue out;
				}
				if (map.get(roomnum).getName().equals("-")) {
					if (roomnum > 200 && roomnum < 210) {
						System.out.println("누구이름으로 등록하시겠습니까?");
						name = sc.next();
						room = "싱글룸";
						System.out.println("체크인이 완료되었습니다");
						map.put(roomnum, new Room(roomnum, room, name));
					} else if (roomnum > 300 && roomnum < 310) {
						System.out.println("누구이름으로 등록하시겠습니까?");
						name = sc.next();
						room = "더블룸";
						System.out.println("체크인이 완료되었습니다");
						map.put(roomnum, new Room(roomnum, room, name));
					} else if (roomnum > 400 && roomnum < 410) {
						System.out.println("누구이름으로 등록하시겠습니까?");
						name = sc.next();
						room = "스위트룸";
						map.put(roomnum, new Room(roomnum, room, name));
						System.out.println("체크인이 완료되었습니다");
					}
				} else {
					System.out.println(roomnum + "호 객실은 이미 손님이 있다");
				}
				break;
			case 2:
				System.out.println("----------------------------------------------");
				System.out.println("   체크아웃 작업");
				System.out.println("----------------------------------------------");
				System.out.println("체크아웃 할 방 번호를 입력하세요.");
				System.out.println("방번호 입력 >>");

				roomnum = sc.nextInt();
				if (!map.containsKey(roomnum)) {
					System.out.println(roomnum + "호 객실은 존재하지 않습니다. ");
					break;
				}
				if (map.get(roomnum).getName().equals("-")) {
					System.out.println(roomnum + "호 객실은 체크인한 사람이 없습니다.");
				   break;
				}
				System.out.println(roomnum + "호 객실의" + map.get(roomnum).getName() + "님을 체크아웃을 완료하였습니다.");
				map.get(roomnum).setName("-");

				break;

			case 3:
				System.out.println("----------------------------------------------");
				System.out.println("		현재 객실 상태");
				System.out.println("----------------------------------------------");
				System.out.println("방   번호	   방 종류	    투숙객     이름       ");
				System.out.println("----------------------------------------------");
				Set<Integer> keySet = map.keySet();
				List<Integer> list = new ArrayList<>(keySet);
				

				Collections.sort(list);
				for(int i : list) {
					System.out.println(map.get(i).getRoomnum() + "\t" + map.get(i).getRoom() + "\t" + map.get(i).getName());					
				}
		
				System.out.println("----------------------------------------------");

				break;
			case 4:
				System.out.println("프로그램 종료");
				break out;

			}
		}

	}
}

class Room {
	private int roomnum;
	private String room;
	private String name;

	public Room() {
		super();

	}

	public Room(int roomnum, String room, String name) {
		super();
		this.roomnum = roomnum;
		this.room = room;
		this.name = name;
	}

	public synchronized int getRoomnum() {
		return roomnum;

	}

	public synchronized void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public synchronized String getRoom() {

		return room;
	}

	public synchronized void setRoom(String room) {
		this.room = room;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

}
