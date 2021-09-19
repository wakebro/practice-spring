package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		InputStream is;
		OutputStream os;
		BufferedReader br_in;
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw;
		String inMessage = null;
		String outMessage = null;
		
		try {
			Socket s1 = new Socket("127.0.0.1", 5434);
			is = s1.getInputStream();
			os = s1.getOutputStream();
			
			br_out = new BufferedReader(new InputStreamReader(System.in));
			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw, true);
			
			while(true) {
				inMessage = br_in.readLine();
				System.out.println(inMessage);
				
				outMessage = br_out.readLine();
				if(outMessage.equals("exit"))
					break;
				
				pw.println("client : " + outMessage);
			}
			
			pw.close();
			s1.close();
		} catch (Exception e) {
		}
		
	}
}
