package ti3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

// 서버에서 보낸 메세지 읽는 Thread
public class ListeningThread extends Thread {
	Socket socket = null;
	
	public ListeningThread(Socket socket) {
		// 받아온 Socket 파라미터를 해당 클래스의 Socket에 저장
		this.socket = socket;
	}
	
	public void run() {
		try {
			// InputStream - Server에서 보낸 메세지를 클라이언트로 가져옴
			// Socket 객체인 socket의 InputStream 정보를
			// InputStream 객체에 저장
			InputStream input = socket.getInputStream();
			// InputStream에 저장된 내용을 BufferedReader에 담아 사용
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			while(true) {
				System.out.println(reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
