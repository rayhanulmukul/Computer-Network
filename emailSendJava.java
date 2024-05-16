import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class emailSendJava {
    private static DataOutputStream data;
    public static BufferedReader buff;
    public static void main(String[] args) throws Exception{
        String user = "s2010976154@ru.ac.bd";
        String pass = "R1m2008@Ram%M";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocket s = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
        data = new DataOutputStream(s.getOutputStream());
        buff = new BufferedReader(new InputStreamReader(s.getInputStream()));

        send("EHLO smtp.gmail.com\r\n");
        System.out.println("SERVER " + buff.readLine());
        System.out.println("SERVER " + buff.readLine());
        System.out.println("SERVER " + buff.readLine());
        System.out.println("SERVER " + buff.readLine());
        System.out.println("SERVER " + buff.readLine());

        send("AUTH LOGIN\r\n");
        System.out.println("SERVER " + buff.readLine());

        send(username + "\r\n");
        System.out.println("SERVER " + buff.readLine());

        send(password + "\r\n");
        System.out.println("SERVER " + buff.readLine());
        
        send("MAIL FROM:<s2010976154@ru.ac.bd>\r\n");
        System.out.println("SERVER " + buff.readLine());
        
        send("RCPT TO:<rayhanulislam.mukul@gmail.com>\r\n");
        System.out.println("SERVER " + buff.readLine());

        send("DATA\r\n");
        System.out.println("SERVER: " + buff.readLine());
        
        send("FROM: s2010976154@ru.ac.bd\r\n");
        send("TO: rayhanulislam.mukul@gmail.com\r\n"); // asif@ru.ac.bd
        send("Subject: 2010976154\r\n");
        send("Succesfull Send Email, Thank You sir.\r\n");
        send(".\r\n");

        send("QUIT\r\n");
        System.out.println("SERVER " + buff.readLine());
    }   
    public static void send(String s) throws Exception{
        data.writeBytes(s);
        Thread.sleep(1000);
        System.out.println("CLIENT " + s);
    }
}
