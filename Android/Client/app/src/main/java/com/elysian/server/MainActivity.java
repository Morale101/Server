package com.elysian.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.elysian.server.MainActivity.client;
import static com.elysian.server.MainActivity.results;
import static com.elysian.server.MainActivity.textField;

public class MainActivity extends Activity {

    public static  Socket client;
    public static  String messsage;
    public static  PrintWriter printwriter;
    public static  EditText textField;
    public static Button button;

    public static  String results;

    EditText greetings;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (EditText) findViewById(R.id.greetings); //reference to the text field
        button = (Button) findViewById(R.id.send);   //reference to the send button

        //Button press event listener
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                messsage = textField.getText().toString(); //get the text message on the text field
                //textField.setText("");      //Reset the text field to blank

                new LongOperation().execute("");
              //  textField.setText(results);
            }
        });

    }
}

class LongOperation extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {
        try {

            client = new Socket("192.168.29.176", 14444);  //connect to server
            OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
            PrintWriter out = new PrintWriter(os); // responsible to send data
            os.write("str");
            os.flush(); // to forcefully send the data
            os.close();
            client.close();   //closing the connection

        } catch (Exception e) {
            textField.setText(e.toString());
            e.printStackTrace();
        }
        //results = "Executed";
      //  textField.setText("testing");
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {
        //results = result;
        textField.setText(result);
         //txt.setText("Executed"); // txt.setText(result);
        // might want to change "executed" for the returned string passed
        // into onPostExecute() but that is upto you
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}


































//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//public class MainActivity extends AppCompatActivity {
//    Button send;
//    TextView greetings;
//    private Socket socket = null;
//    private DataInputStream input = null;
//    private DataOutputStream out = null;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        greetings = (TextView) findViewById(R.id.greetings);
//        send = (Button) findViewById(R.id.send);
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//
//        });
//    }
//
//}
//
//public class networking extends AsyncTask<String,Void, String>
//{
//    // initialize socket and input output streams
//    private Socket socket = null;
//    private DataInputStream input = null;
//    private DataOutputStream out = null;
//    // constructor to put ip address and port
//@Override
//protected String doInBackground(String... params) {
//    try {
//        String address = "192.168.29.176";
//        int port = 14444;
//        socket = new Socket(address, port);
//        //System.out.println("Connected");
//// takes input from terminal
//        //input = new DataInputStream(System.in);
//// sends output to the socket
//        out = new DataOutputStream(socket.getOutputStream());
//    } catch (UnknownHostException u) {
//        //  System.out.println(u);
//    } catch (IOException i) {
//        //  System.out.println(i);
//    }// string to read message from input
//    String line = "";
//// keep reading until "Over" is input
//
//// close the connection
//    try {
//        input.close();
//        out.close();
//        socket.close();
//    } catch (IOException i) {
//        System.out.println(i);
//    }
//
//}
//}
