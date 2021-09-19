package ex2;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;

public class SerClient {
	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("127.0.0.1", 5433);
			InputStream is = s1.getInputStream();
			ObjectInputStream dis = new ObjectInputStream(is);
			
			Employee p = (Employee)dis.readObject();
			System.out.println("이름 : " + p.getName());
			System.out.println("주소 : " + p.getAddr());
			System.out.println("주민번호 : " + p.getJumin());
			System.out.println("전화번호 : " + p.getPhone());
			
			dis.close();
			s1.close();
		}catch (ConnectException connExc) {
			System.out.println("연결 실패!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
