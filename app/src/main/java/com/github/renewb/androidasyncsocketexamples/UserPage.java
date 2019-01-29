package com.github.renewb.androidasyncsocketexamples;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.reneweb.androidasyncsocketexamples.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.Intents.Insert.NOTES;

public class UserPage extends ActionBarActivity {
    private TextView status;
    private EditText IPAddress,Port,Message,time,pressure;
    ListView listView;
    private static UserPage instance;
    List<String> list = new ArrayList<String>();
    String start,stop,clear,emerg;

    private String ipAdd,portString,state,command1,TextCom;
    private int port;
    int NumCom = 0;
    List<String> command = new ArrayList<String>();
    EditText statusMode;
    String Pre[],Sec[];
//    SetPressureAndMinute showData;


    //////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        IPAddress = (EditText)findViewById(R.id.ip);
        Port = (EditText)findViewById(R.id.port);           // BM
        Message = (EditText)findViewById(R.id.message);         // BM
        status = (TextView) findViewById(R.id.status);
        time = (EditText) findViewById(R.id.Time);
        pressure = (EditText) findViewById(R.id.Pressure);
        statusMode = (EditText) findViewById(R.id.status);
        readFile("Sec_mode.txt");
        readFile("Pre_mode.txt");
        instance = this;
        bindView();
        initView();


//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params) {
//          TCP client and server (Client will automatically send welcome message after setup and server will respond)
//                new com.github.reneweb.androidasyncsocketexamples.tcp.Server("localhost", 7000);
//                new com.github.reneweb.androidasyncsocketexamples.tcp.Client("localhost", 7000);
//          UDP client and server (Here the client explicitly sends a message)
//                new com.github.reneweb.androidasyncsocketexamples.udp.Server("localhost", 7001);
//                new com.github.reneweb.androidasyncsocketexamples.udp.Client("localhost", 7001).send("Hello World");


                //////////  Added by Oom ///////////
//                try {
//                    new com.github.reneweb.androidasyncsocketexamples.tcp.Server("10.10.186.197", 7000);
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }


//
//passed                 System.out.println("on Create B ");
//                return null;
//            }
//        }.execute();
    }



    private void bindView(){
//        Time = (EditText) findViewById(R.id.Time);
//        Pressure = (EditText) findViewById(R.id.Pressure);
    }

    private void initView(){
        findViewById(R.id.btn_start).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_stop).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_emerg).setOnClickListener(new InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.

    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    SetAndSend(1);
//                    SetAndSend(start);
                    break;
                case R.id.btn_stop:
//                    SetAndSend(stop);
//                    SetAndSend(clear);
                    break;
                case R.id.btn_emerg:
//                   SetAndSend(4);
                    break;
            }
//            hideKeyboardInput(v);
        }
    }
    public void readFile(String FileName){
        try {
            FileInputStream fileIn=openFileInput(FileName);
            InputStreamReader InputRead= new InputStreamReader(fileIn);
            BufferedReader br = new BufferedReader(InputRead);
//            StringBuilder sb = new StringBuilder();
            String text;
            String ab = null;
            int i=0;
            while ((text = br.readLine()) != null){
                System.out.println("[Sec.]" + text);

                System.out.println("Im here nananananananna");
//                Sec[i] = text;
                i++;
            }
            InputRead.close();
//            ArrayList<String> press = new ArrayList<>();
//            for(String str : ab.split("\\s") ){
//                press.add(str);
//            }
//            PRESSURE_SIDE = press.get(2);
//            PRESSURE_MAIN = press.get(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            FileInputStream fileIn=openFileInput("Pre_mode.txt");
//            InputStreamReader InputRead= new InputStreamReader(fileIn);
//            BufferedReader br = new BufferedReader(InputRead);
////            StringBuilder sb = new StringBuilder();
//            String text;
//            String ab = null;
//            int j=0;
//            while ((text = br.readLine()) != null){
////                System.out.println("[Pressure]" + text);
//                Sec[j] = text;
//                j++;
//            }
//            InputRead.close();
////            ArrayList<String> press = new ArrayList<>();
////            for(String str : ab.split("\\s") ){
////                press.add(str);
////            }
////            PRESSURE_SIDE = press.get(2);
////            PRESSURE_MAIN = press.get(3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        statusMode.setText(Pre[4]);
    }


    private void SetAndSend(int numberOfCase) {
        final String Cmd;
        final String Ip = (IPAddress).getText().toString();
        final int Ports = Integer.parseInt((Port).getText().toString());
        if(numberOfCase == 1){
            System.out.println("Command na ja before nana");
            Cmd = "0A FF 05 81 "+Sec[0]+" "+Pre[0]+" C1 "+Sec[1]+" "+Pre[1]+" E1 "+Sec[2]+" "+Pre[2]+" F1 "+Sec[3]+" "+Pre[3]+" 00 "+Sec[4]+" 00";
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client("10.0.0.177", 12345 ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if (numberOfCase == 2){
            Cmd = "0A FF 05 81 "+Sec[0]+" "+Pre[0]+" 41 "+Sec[1]+" "+Pre[1]+" 21 "+Sec[2]+" "+Pre[2]+" 11 "+Sec[3]+" "+Pre[3]+" 00 "+Sec[4]+" 00";
            System.out.printf("Command = "+ Cmd);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client(Ip, Ports ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if(numberOfCase == 3){
            Cmd = "0A FF 02 F1 "+Sec[0]+" "+Pre[0]+" 00 "+Sec[4]+" 00";
            System.out.printf("Command = "+ Cmd);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client(Ip, Ports ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if (numberOfCase == 4){
            Cmd = "0B FF 01 00 0000 01 0000";
            System.out.printf("Command = "+ Cmd);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client(Ip, Ports ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if (numberOfCase == 5){
            Cmd = "0B FF 00 00 0000 00 0000";
            System.out.printf("Command = "+ Cmd);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client(Ip, Ports ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if (numberOfCase == 6){
            Cmd = "CA";
            System.out.printf("Command = "+ Cmd);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client(Ip, Ports ,Cmd);
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }else if(numberOfCase == 7){
            Cmd ="EE";
            System.out.println("Command naja kikikikikikikikikikikiki = "+ Cmd);
//                 ClickProcess(Cmd);

            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    new com.github.reneweb.androidasyncsocketexamples.tcp.Client("10.0.0.177", 12345 ,"EE");
                    //passed               System.out.println(ip + " and" + prt);
                    return null;
                }
            }.execute();
        }
    }

//    private void hideKeyboardInput(View v){
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//    }

    public void onClick(View v) {
//passed         System.out.println("Hello onClick Yeah !!! ");
        ipAdd = IPAddress.getText().toString();
//passed         System.out.println(ipAdd);
        portString = Port.getText().toString();
        port = Integer.parseInt(portString);
//passed         System.out.println(ipAdd + port);
        new com.github.reneweb.androidasyncsocketexamples.tcp.Client(ipAdd,port);
//passed         System.out.println(ipAdd + port);
        status.setText("connect");
//        value = txtName.getText().toString();
//        try {
//            new com.github.reneweb.androidasyncsocketexamples.tcp.Server(value, 7000);
//            status.setText("recieved !");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }


///////////////////////////// Add //////////////////////////

    public static UserPage getInstance() {
        return instance;
    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
    public void ClickProcess(final String cmd1) {
//        Message = (EditText) findViewById(R.id.message);
//        final String msg = Message.getText().toString();
//        list.add(0,msg);
//        IPAddress = (EditText) findViewById(R.id.ip);
//        final String ip = IPAddress.getText().toString();
//        Port = (EditText) findViewById(R.id.port);
//        final int prt = Integer.parseInt(Port.getText().toString());
////passed         System.out.println(ip + prt + msg + "///////////////");
////
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                new com.github.reneweb.androidasyncsocketexamples.tcp.Client("10.0.0.177", 12345 ,cmd1);
                System.out.println("Command im here = "+ cmd1);
                //passed               System.out.println(ip + " and" + prt);
                return null;
            }
        }.execute();

////        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
////        listView = (ListView) findViewById(R.id.listview);
////        listView.setAdapter(itemsAdapter);
//        Message.setText("");
//        NumCom =0;
//        TextCom = null;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("EiEi  onCreateOptionsMenu 88888888888 ");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        System.out.println("EiEi  onOptionsItemSelected 88888888888 ");
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }





}

