package ti2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
	public static void main(String[] args) {
		try {
			// 서버에 사용되는 포트 설정
			int socketPort = 1234;
			
			// 서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(socketPort);
			
			// 서버 소켓으로 접속하는 Socket을 선언
			// 다양한 사용자가 접근할 수 있도록 socketUser는 null값으로 초기화
			Socket socketUser = null;
			System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다.");
			
			// 서버소켓이 종료될 때까지 반복
			while(true) {
				
				// 사용자 접근시 사용가능한 socketUser를 사용자에 맞추어 접속자 정보 할당
				socketUser = serverSocket.accept();
				// getLocalAddress로 접속자 정보 가져오기
				System.out.println("Client가 접속 : " + socketUser.getLocalAddress());
				
				
				// InputStream - 클라이언트에서 서버로 들어오는 내용
				// Socket객체인 socketUser의 InputStream 정보를 
				// InputStream 객체인 input에 선언
				InputStream input = socketUser.getInputStream();
				// BufferedReader에 InputStream input 내용을 담아 사용
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				// 클라이언트에서 온 메시지 내용 확인
				System.out.println(reader.readLine());
				
				
				// OutputStream - 서버에서 클라이언트로 보내는 내용
				// Socket객체인 socketUser의 OutputStream 정보를 
				// OutputStream 객체인 output에 선언
				OutputStream output = socketUser.getOutputStream();
				// PrintWriter에 OutputStream 객체인 output 내용을 담아 사용
				PrintWriter writer = new PrintWriter(output, true);
				writer.println("SERVER TO CLIENT");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
