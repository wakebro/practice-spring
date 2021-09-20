package ti1;

import java.net.ServerSocket;
import java.net.Socket;

// 자바 소켓 통신 서버 & 클라이언트 작성 및 연결
public class MySocketServer {

	public static void main(String[] args) {
		try {
			// 서버에 사용되는 포트 설정
			int socketPort = 1234;
			
			// 서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(socketPort);
			System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다.");
			
			// 서버소켓이 종료될 때까지 반복
			while(true) {
				// 서버 소켓으로 접속 시, socketUser에 접속자 정보 할당
				Socket socketUser = serverSocket.accept();
				// getLocalAddress로 접속자 정보 가져오기
				System.out.println("Client가 접속함 : " + socketUser.getLocalAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
