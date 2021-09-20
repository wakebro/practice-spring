package ti2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MySocketClient {

	public static void main(String[] args) {
		try {
			// 서버에 연결되는 IP와 포트를 넣은 Socket 생성
			Socket socket = new Socket("172.30.1.10", 1234);
			System.out.println("socket 서버에 접속 성공!");
			
			
			// InputStream - 서버에서 클라이언트로 보낸 내용
			// Socket객체인 socket의 InputStream 정보를
			// InputStream 객체인 input에 선언
			InputStream input = socket.getInputStream();
			// BufferedReader에 InputStream input 내용을 담아 사용
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			// 서버에서 온 메세지 내용 확인
			System.out.println(reader.readLine());
			
			
			// OutputStream - 클라이언트에서 서버로 보낸 내용
			// Socket객체인 socket의 OutputStream 정보를 
			// OutputStream 객체인 output에 선언
			OutputStream output = socket.getOutputStream();
			// PrintWriter에 OutputStream 객체인 output 내용을 담아 사용
			PrintWriter writer = new PrintWriter(output, true);
			// 클라이언트에서 서버로 메시지 보내기
			writer.println("CLIENT TO SERVER");
			
			
			System.out.println("CLIENT SOCKET CLOSE");
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
