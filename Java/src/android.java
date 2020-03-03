import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class android {
    public static  ServerSocket server;
    public static void main(String[] args){
//        try{
//             server = new ServerSocket(14444);
//        } catch (IOException e) {
//            System.out.println("Could not listen on port 14444");
//            System.exit(-1);
//        }
        while(true){
            ClientWorker w;
            try{
//server.accept returns a client connection
                w = new ClientWorker(server.accept());
                Thread t = new Thread(w);
                t.start();
            } catch (IOException e) {
                System.out.println("Accept failed: 14444");
                System.exit(-1);
            }
        }
    }
}


class ClientWorker implements Runnable {
    private Socket client;


    //Constructor
    ClientWorker(Socket client) {
        this.client = client;

    }

    public void run(){
        String line;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new
                    InputStreamReader(client.getInputStream()));
            out = new
                    PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

        while(true){
            try{
                line = in.readLine();
//Send data back to client
                out.println(line);
//Append data to text area

            }catch (IOException e) {
                System.out.println("Read failed");
                System.exit(-1);
            }
        }
    }
}

