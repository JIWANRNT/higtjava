package File;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.Buffer;

public class Client {

	public static void main(String[] args, Socket socket) throws IOException {

	File file = new File("d:/d_other/2426.jpg");
	
	if(!file.exists()) {
		System.exit(0);
	
	}
	Socket ket = new Socket("localhost",7777);
	System.out.println("서버에 연결되어있습니다....");

    String fname = file.getName();
    OutputStream os = ket.getOutputStream();
    DataOutputStream dos = new DataOutputStream(os);
    dos.writeUTF(fname);
    
    FileInputStream fis = new FileInputStream(file);
    BufferedOutputStream bos = new BufferedOutputStream(os);
    
    int c;
    while((c=fis.read())!= -1) {
    	bos.write(c);
    }
    dos.close();
    ket.close();

)
)