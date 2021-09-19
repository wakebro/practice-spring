package ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SimpleServer {
	public static void main(String[] args) {
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw = null;
		OutputStream os;
		ServerSocket serverSocket;
		Socket s1 = null;
		String outMessage = null;
		
		try {
			serverSocket = new ServerSocket(5434);
			System.out.println("서버 실행 중...");
			s1 = serverSocket.accept();
			os = s1.getOutputStream();
			
			ReciveThread rThread = new ReciveThread(s1);
			
			br_out = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw, true);
			
			pw.println("server: 접속을 환영합니다.");
			
			while(true) {
				outMessage = br_out.readLine();
				if(outMessage.equals("exit"))
					break;
				
				pw.println("server : " + outMessage);
			}
			pw.close();
			s1.close();
			
			if(rThread.isAlive()) {
				rThread.interrupt();
				rThread = null;
			}
		} catch (SocketException e) {
			System.out.println("클라이언트로부터 연결이 끊어졌습니다. 종료합니다...");
			System.exit(0);
		} catch (Exception e) {
			System.exit(0);
		}
	}

}
