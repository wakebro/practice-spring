package ti3;

import java.net.Socket;

public class MySocketClient {

	public static void main(String[] args) {
		try {
			// 서버에 연결되는 IP와 포트를 넣은 Socket 생성
			Socket socket = new Socket("172.30.1.10", 1234);
			System.out.println("socket 서버에 접속 성공!");
			
			
			// 서버에서 보낸 메세지 읽는 Thread
			ListeningThread t1 = new ListeningThread(socket);
			// 서버로 보내는 메세지 Thread
			WritingThread t2 = new WritingThread(socket);
			
			t1.start();
			t2.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
