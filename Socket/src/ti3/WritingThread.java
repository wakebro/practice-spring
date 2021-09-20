package ti3;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WritingThread extends Thread {
	Socket socket = null;
	// 채팅용 Scanner
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	public WritingThread(Socket socket) {
		// 클라이언트에서 받아온 Socket 파라미터를 해당 클래서 Socket에 넣기
		this.socket = socket;
	}
	
	public void run() {
		try {
			// OutputStream - 클라이언트에서 Server로 메세지 발송
			// Socket 객체인 socket의 OutputStream 정보를
			// OutputStream 객체에 저장
			OutputStream output = socket.getOutputStream();
			// OutputStream에 저장된 내용을 PrintWriter에 담아 사용
			PrintWriter writer = new PrintWriter(output, true);
			
			while(true) {
				// 입력한 메세지 발송
				writer.println(sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
