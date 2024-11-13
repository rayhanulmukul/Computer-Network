import java.io.DataOutputStream;
import java.net.*;

public class client {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 7777);
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        ds.writeUTF("Hello Bangladesh");

        
        s.close();
    }
}