package ti3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


// 소켓통신용 서버
public class MySocketServer extends Thread {
	// 유저 확인용
	static ArrayList<Socket> list = new ArrayList<Socket>();
	static Socket socket = null;
	
	public MySocketServer(Socket socket) {
		// 유저 Socket객체의 socket을 할당
		this.socket = socket;
		// 유저를 list에 추가
		list.add(this.socket);
	}
	// Thread에서 start() 메소드 사용 시 자동으로 해당 메소드 시작(Thread별로 개별 수행)
	public void run() {
		try {
			// 연결 확인 디버깅
			System.out.println("서버 : " + socket.getLocalAddress() + " IP의 클라이언트와 연결되었습니다.");
			
			// InputStream - 클라이언트에서 서보로 보낸 메시지 읽기
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			
			// OutputStream - 서버에서 클라이언트로 메시지 보내기
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			// 클라이언트에게 연결되었다는 메세지 보내기
			writer.println("서버에 연결되었습니다. ID를 입력해 주세요");
			
			
			// 클라이언트에서 보낸 값 저장
			String readValue;
			// 클라이언트 이름 설정용
			String name = null;
			boolean identify = false;
			
			
			// 클라이언트가 메시지 입력시마다 수행
			while ((readValue = reader.readLine()) != null) {
				// 연결 후 한번만 노출
				if(!identify) {
					// 이름 설정
					name = readValue;
					identify = true;
					writer.println(name + "님이 접속하셨습니다.");
					continue;
				}
				
				// list 안에 클라이언트 정보가 저장
				for (int i = 0; i < list.size(); i++) {
					output = list.get(i).getOutputStream();
					writer = new PrintWriter(output, true);
					// 클라이언트에게 메시지 발송
					writer.println(name + " : " + readValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			// 서버에 사용되는 포트 설정
			int socketPort = 1234;
			// 서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(socketPort);
			
			
			// 서버 오픈 확인 디버깅
			System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다.");
			
			// 소켓 서버가 종료될 때까지 무한루프
			while(true) {
				// 사용자 접근시 사용가능한 socketUser를 사용자에 맞추어 접속자 정보 할당
				Socket socketUser = serverSocket.accept();
				
				// Thread 안에 클라이언트 정보를 담아줌
				Thread rThread = new MySocketServer(socketUser);
				rThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
