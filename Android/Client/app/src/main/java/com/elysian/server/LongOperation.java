//package com.elysian.server;
//
//import android.os.AsyncTask;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//import static com.elysian.server.MainActivity.client;
//import static com.elysian.server.MainActivity.messsage;
//import static com.elysian.server.MainActivity.printwriter;
//import static com.elysian.server.MainActivity.results;
//
//public class LongOperation extends AsyncTask<String, Void, String> {
//
//
//    @Override
//    protected String doInBackground(String... params) {
//        try {
//
//            client = new Socket("192.168.29.176", 14444);  //connect to server
//            OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
//            PrintWriter out = new PrintWriter(os); // responsible to send data
//            os.write("str");
//            os.flush(); // to forcefully send the data
//            os.close();
//            client.close();   //closing the connection
//
//        } catch (UnknownHostException e) {
//            results = e.toString();
//            e.printStackTrace();
//        } catch (IOException e) {
//            results = e.toString();
//            e.printStackTrace();
//        }
//        results = "Executed";
//        return "Executed";
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        results = result;
//       // EditText txt = (EditText) findViewById(R.id.greetings);
//        //txt.setText("Executed"); // txt.setText(result);
//        // might want to change "executed" for the returned string passed
//        // into onPostExecute() but that is upto you
//    }
//
//    @Override
//    protected void onPreExecute() {}
//
//    @Override
//    protected void onProgressUpdate(Void... values) {}
//}
