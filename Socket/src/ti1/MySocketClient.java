package ti1;

import java.net.Socket;

public class MySocketClient {
	public static void main(String[] args) {
		try {
			// 서버에 연결되는 IP와 포트를 넣은 Socket 생성
			Socket socket = new Socket("172.30.1.10", 1234);
			System.out.println("socket 서버에 접속 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
