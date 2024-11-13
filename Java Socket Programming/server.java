import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(7777);
        Socket s = ss.accept();
        DataInputStream ds = new DataInputStream(s.getInputStream());

        String msg = (String) ds.readUTF();
        System.out.println("Message: " + msg);

        ss.close();
    }
}
