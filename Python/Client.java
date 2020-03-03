import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
     public static void main(String[] args) throws Exception {

          String ip = "localhost";
          int port = 14444;
          Socket s = new Socket(ip, port);

          String str = "Abhishek gupta";

          OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
          PrintWriter out = new PrintWriter(os); // responsible to send data
          os.write(str);
          os.flush(); // to forcefully send the data
          os.close();

     }
}
