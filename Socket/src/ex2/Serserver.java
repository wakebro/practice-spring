package ex2;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serserver {

	public static void main(String[] args) {
		ServerSocket s = null;
		
		try {
			s = new ServerSocket(5433);
			
			while(true) {
				System.out.println("서버 실행 중...");
				Socket s1 = s.accept();
				
				OutputStream out = s1.getOutputStream();
				ObjectOutputStream dos = new ObjectOutputStream(out);
				Employee p = new Employee("유저1", "서울시 마포구", "1111-1111", "010-123-1234");
				dos.writeObject(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
