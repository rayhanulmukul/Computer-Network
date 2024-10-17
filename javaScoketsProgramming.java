import java.io.*;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
public class javaScoketsProgramming {
	private static DataOutputStream dos;
	public static BufferedReader br;
	public static void main(String[] args) throws Exception {
		String user = "s2010976154@ru.ac.bd";
    	String pass = "R1m2008@Ram%M";

		String username = new String(Base64.getEncoder().encode(user.getBytes()));
		String password = new String(Base64.getEncoder().encode(pass.getBytes()));
		SSLSocket s = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
		dos = new DataOutputStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		send("EHLO smtp.gmail.com\r\n");
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());
		System.out.println("SERVER: " + br.readLine());

		send("AUTH LOGIN\r\n");
		System.out.println("SERVER: " + br.readLine());

		send(username + "\r\n");
		System.out.println("SERVER: " + br.readLine());

		send(password + "\r\n");
		System.out.println("SERVER: " + br.readLine());

		send("MAIL FROM:<s2010976154@ru.ac.bd>\r\n");
		System.out.println("SERVER: " + br.readLine());

		send("RCPT TO:<rayhanulislam.mukul@gmail.com>\r\n");
		System.out.println("SERVER: " + br.readLine());

		send("DATA\r\n");
		System.out.println("SERVER: " + br.readLine());

		send("FROM: s2010976154@ru.ac.bd\r\n");
		send("TO: rayhanulislam.mukul@gmail.com\r\n"); // asif@ru.ac.bd
		send("Subject: 2010976154\r\n");
		send("Successful Send Email. Thank You Sir.\r\n");

		send("QUIT\r\n");
		System.out.println("SERVER: " + br.readLine());
	}
	private static void send(String s) throws Exception{
		dos.writeBytes(s);
		Thread.sleep(100);
		System.out.println("CLIENT: " + s);
	}	
}