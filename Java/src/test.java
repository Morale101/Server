// A Java program for a ClientSide
import java.net.*;
import java.io.*;
public class test
{
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    // constructor to put ip address and port
    public  test(String address, int port)
    {
// establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
// takes input from terminal
            input = new DataInputStream(System.in);
// sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }// string to read message from input
        String line = "";
// keep reading until "Over" is input

// close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[]) {
        test client = new test("127.0.0.1", 14444);
    }
}