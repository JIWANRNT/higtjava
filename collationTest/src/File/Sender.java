package File;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
     private Socket socket;
     private DataOutputStream dout;
     private String name;
     private Scanner scan;
     
     public Sender(Socket socket) {
    	 this.socket = socket;
    	 scan = new Scanner(System.in);
    	 
    	 System.out.println("이름 입력 >>");
    	 name = scan.nextLine();
    	 
    	 try {
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
     }
     public void run() {
    	 while(dout!=null) {
    		 try {
				dout.writeUTF("name"+":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
    	 }
     }
	
	
}
