import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;

public class Server {
    public static void main(String[] args) throws Exception {

        System.out.println("Server is started");
        ServerSocket ss = new ServerSocket(14444);
        System.out.println("Server is waiting for client request ");

        Socket s = ss.accept();
        System.out.println("Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        System.out.println("Client data : " + str);

    }
}
