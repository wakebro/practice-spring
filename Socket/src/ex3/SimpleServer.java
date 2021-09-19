package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

	public static void main(String[] args) {
		InputStream is;
		BufferedReader br_in;
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw = null;
		OutputStream os;
		ServerSocket serverSocket;
		Socket s1 = null;
		String inMessage = null;
		String outMessage = null;
		
		try {
			serverSocket = new ServerSocket(5434);
			System.out.println("서버 실행 증가");
			s1 = serverSocket.accept();
			is = s1.getInputStream();
			os = s1.getOutputStream();
			
			br_out = new BufferedReader(new InputStreamReader(System.in));
			br_in = new BufferedReader(new InputStreamReader(is));
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw, true);
			pw.println("Server: 접속을 환영합니다.");
			
			while(true) {
				inMessage = br_in.readLine();
				System.out.println(inMessage);
				
				outMessage = br_out.readLine();
				if(outMessage.equals("exit"))
					break;
				
				pw.println("Server : " + outMessage);
			}
			pw.close();
			s1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
