package ex5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SimpleClient {
	public static void main(String[] args) {
		OutputStream os;
		BufferedReader br_int;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		String outMessage = null;
		
		try {
			Socket s1 = new Socket("127.0.0.1", 5434);
			os = s1.getOutputStream();
			ReciveThread rThread = new ReciveThread(s1);
			rThread.start();
			
			br_int = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw, true);
			
			while(true) {
				outMessage = br_int.readLine();
				if(outMessage.equals("exit"))
					break;
				
				pw.println("client : " + outMessage);
			}
			
			pw.close();
			s1.close();
			
			if(rThread.isAlive()) {
				rThread.interrupt();
				rThread = null;
			}
		} catch (SocketException e) {
			System.out.println("서버로부터 연결이 끊어졌습니다. 종료합니다...");
			System.exit(0);
		} catch (Exception e) {
			System.exit(0);
		}
	}
}
