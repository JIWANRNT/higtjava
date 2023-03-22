package File;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;

public class servie {

public static void main(String[] args) throws IOException {
	
		
		File file = new File("d:/d_other/연습용"); //파일이 저장될 폴더 정보를 갖는
		if(!file.exists()) {                    // file객체를 생성한다.
			file.mkdirs();                // 해당 폴더가 없으면 새로 생성한다.
		}
           
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비 중입니다");
		
		Socket so = server.accept();
		
		InputStream is = so.getInputStream()
        DataInputStream dis = new DataInputStream(is);
		String fname = dis.readUTF();
		System.out.println("파일 명 :" + fname);
 
		File outFile = new File(file+"/"+fname);
		
		System.out.println(outFile);
		FileOutputStream fos = new FileOutputStream(outFile);
		
		int c;
		
		while((c=is.read())!= -1) {
			fos.write(c);
			
		}
        fos.close();
        is.close();
        so.close();
        server.close();
        
        
        







}


}