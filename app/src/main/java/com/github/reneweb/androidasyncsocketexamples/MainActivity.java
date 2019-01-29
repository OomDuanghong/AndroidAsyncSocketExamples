package com.github.reneweb.androidasyncsocketexamples;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {

    // Added by Oom
    private TextView status;
    private EditText IPAddress,Port,Message,time,pressure;
    ListView listView;
    private static MainActivity instance;
    List<String> list = new ArrayList<String>();

    private String ipAdd,portString,state,command1,TextCom;
    private int port;
    int NumCom = 0;
    List<String> command = new ArrayList<String>();


    //////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IPAddress = (EditText)findViewById(R.id.ip);
        Port = (EditText)findViewById(R.id.port);           // BM
        Message = (EditText)findViewById(R.id.message);         // BM
        status = (TextView) findViewById(R.id.status);
        time = (EditText) findViewById(R.id.Time);
        pressure = (EditText) findViewById(R.id.Pressure);
        instance = this;
        bindView();
        initView();


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
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
                return null;
            }
        }.execute();
    }

    private void bindView(){
//        Time = (EditText) findViewById(R.id.Time);
//        Pressure = (EditText) findViewById(R.id.Pressure);
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.directControl).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.inflate1).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.inflate2).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.inflate3).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.inflate4).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.state1).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.state2).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.state3).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.state4).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.state5).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.start).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.emergency).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.read_state).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.ca).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.submit).setOnClickListener(new InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.directControl:
                    AddCommand(v);
                    break;
                case R.id.inflate1:
                    AddCommand(v);
                    break;
                case R.id.inflate2:
                    AddCommand(v);
                    break;
                case R.id.inflate3:
                    AddCommand(v);
                    break;
                case R.id.inflate4:
                    AddCommand(v);
                    break;
                case R.id.state1:
                    AddCommand(v);
                    break;
                case R.id.state2:
                    AddCommand(v);
                    break;
                case R.id.state3:
                    AddCommand(v);
                    break;
                case R.id.state4:
                    AddCommand(v);
                    break;
                case R.id.state5:
                    AddCommand(v);
                    break;
                case R.id.start:
                    AddCommand(v);
                    break;
                case R.id.emergency:
                    AddCommand(v);
                    break;
                case R.id.read_state:
                    AddCommand(v);
                    break;
                case R.id.ca:
                    AddCommand(v);
                    break;
                case R.id.submit:
                    AddTAP();
                    break;
            }
            hideKeyboardInput(v);
        }
    }




    //Check:tha last click is just the one to pick for use in the command
    private void AddCommand(View v) {
        if(command == null){
            switch (v.getId()) {
                case R.id.directControl:
//                    command.add("02 01 02");
                    ShowMessage("02 01 02");
                    break;
                case R.id.inflate1:
                    ShowMessage("02 FF 81");
                    break;
                case R.id.inflate2:
                    ShowMessage("02 FF C1");
                    break;
                case R.id.inflate3:
                    ShowMessage("02 FF E1");
                    break;
                case R.id.inflate4:
                    ShowMessage("02 FF F1");
                    break;
                case R.id.state1:
//                    command.add("01 ");
                    state = "01";
                    break;
                case R.id.state2:
//                    command.add("02 ");
                    state = "02";
                    break;
                case R.id.state3:
//                    command.add("03 ");
                    state = "03";
                    break;
                case R.id.state4:
//                    command.add("04 ");
                    state = "04";
                    break;
                case R.id.state5:
//                    command.add("05 ");
                    state = "05";
                    break;
                case R.id.start:
//                    command.add("0B FF 01 00 0000 01 0000");
//                    command1 ="0B FF 01 00 0000 01 0000";
                    ShowMessage("0B FF 01 00 0000 01 0000");
                    break;
                case R.id.emergency:
//                    command.add("EE");
                    ShowMessage("EE");
                    break;
                case R.id.read_state:
//                    command.add("01");
                    ShowMessage("01");
                    break;
                case R.id.ca:
//                    command.add("CA");
                    ShowMessage("CA");
                    break;
            }
        }else{
            state = null;
//            for(int i=0;i<command.size();i++)
//            {
//                command.remove(i);
//            }
            switch (v.getId()) {
                case R.id.directControl:
//                    command.add("02 01 02");
                    ShowMessage("02 01 02");
                    break;
                case R.id.inflate1:
                    ShowMessage("02 FF 81");
                    break;
                case R.id.inflate2:
                    ShowMessage("02 FF C1");
                    break;
                case R.id.inflate3:
                    ShowMessage("02 FF E1");
                    break;
                case R.id.inflate4:
                    ShowMessage("02 FF F1");
                    break;
                case R.id.state1:
//                    command.add("01 ");
                    state = "01";
                    break;
                case R.id.state2:
//                    command.add("02 ");
                    state = "02";
                    break;
                case R.id.state3:
//                    command.add("03 ");
                    state = "03";
                    break;
                case R.id.state4:
//                    command.add("04 ");
                    state = "04";
                    break;
                case R.id.state5:
//                    command.add("05 ");
                    state = "05";
                    break;
                case R.id.start:
//                    command.add("0B FF 01 00 0000 01 0000");
//                    command1 ="0B FF 01 00 0000 01 0000";
                    ShowMessage("0B FF 01 00 0000 01 0000");
                    break;
                case R.id.emergency:
//                    command.add("EE");
                    ShowMessage("EE");
                    break;
                case R.id.read_state:
//                    command.add("01");
                    ShowMessage("01");
                    break;
                case R.id.ca:
//                    command.add("CA");
                    ShowMessage("CA");
                    break;
            }

        }

    }

    //Check:have state before add Time and Pressure
    private boolean CheckCommand() {
        if(state != null){
            return true;
        } else {
            return false;
        }
    }

    //send Time and pressure in EditText id:Time,Pressure + send state to EditText id:message
    private void AddTAP() {
        time = (EditText) findViewById(R.id.Time);
        pressure = (EditText) findViewById(R.id.Pressure);
        String TAP;
        String Bcom = "0A FF ";
        String Ti = time.getText().toString();
        String Pr = pressure.getText().toString();
        int resultT = Integer.parseInt(Ti);
        int resultP = Integer.parseInt(Pr);
        String time1 = Integer.toHexString(resultT);
        String pressure1 = Integer.toHexString(resultP);
        if(CheckCommand() == true){
            if(NumCom == 0){
//                Integer.toHexString(result);
                if(resultT < 16 && resultP <16){
                    TextCom =  state + " 000" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT <16 && resultP>=16 &&resultP<256){
                    TextCom =  state + " 000" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }
                else if(resultT >=16 && resultP<16 &&resultT<256){
                    TextCom =  state + " 00" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=16 && resultT < 256 && resultP>=16 &&resultP<256){
                    TextCom =  state + " 00" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=16 && resultT < 256 && resultP>=256 &&resultP<4096){
                    TextCom =  state + " 00" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                } else if(resultT <16 && resultP>=256 &&resultP<4096){
                    TextCom =  state + " 000" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=256 && resultT < 4096 && resultP>=256 &&resultP<4096){
                    TextCom =  state + " 0" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                } else if(resultT >=256 && resultT < 4096 && resultP>=16 &&resultP<256){
                    TextCom =  state + " 0" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=256 && resultT < 4096 && resultP<16){
                    TextCom =  state + " 0" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP<16){
                    TextCom =  state + " " + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP>=16 &&resultP<256){
                    TextCom =  state + " " + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP>=256 &&resultP<4096){
                    TextCom =  state + " " + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else{
                    System.out.println("Time and Pressure is not a true value.");
                }
            }else {
                if(resultT < 16 && resultP <16){
                    TextCom = TextCom +" "+  state + " 000" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT <16 && resultP>=16 &&resultP<256){
                    TextCom = TextCom +" "+  state + " 000" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }
                else if(resultT >=16 && resultP<16 &&resultT<256){
                    TextCom = TextCom +" "+  state + " 00" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=16 && resultT < 256 && resultP>=16 &&resultP<256){
                    TextCom = TextCom +" "+  state + " 00" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=16 && resultT < 256 && resultP>=256 &&resultP<4096){
                    TextCom = TextCom +" "+  state + " 00" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                } else if(resultT <16 && resultP>=256 &&resultP<4096){
                    TextCom = TextCom +" "+  state + " 000" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=256 && resultT < 4096 && resultP>=256 &&resultP<4096){
                    TextCom = TextCom +" "+  state + " 0" + time1.toUpperCase() + " 0" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                } else if(resultT >=256 && resultT < 4096 && resultP>=16 &&resultP<256){
                    TextCom = TextCom +" "+  state + " 0" + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=256 && resultT < 4096 && resultP<16){
                    TextCom = TextCom +" "+  state + " 0" + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP<16){
                    TextCom = TextCom +" "+ state + " " + time1.toUpperCase() + " 000" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP>=16 &&resultP<256){
                    TextCom = TextCom +" "+  state + " " + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else if(resultT >=4096 && resultT < 65535 && resultP>=256 &&resultP<4096){
                    TextCom = TextCom +" "+  state + " " + time1.toUpperCase() + " 00" +pressure1.toUpperCase() ;
                    NumCom++;
                    TAP = Bcom.toString() + "0" +NumCom+" " + TextCom.toString();
                    ShowMessage(TAP);
                }else{
                    System.out.println("Time and Pressure is not a true value.");
                }
            }
        }else{
            System.out.println("add your state before set Time and Pressure");
        }
    }

    //show message in EditText id:message
    private void ShowMessage(String msg) {
//        Message.setText(command.get(15));
        Message.setText(msg);

    }

    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

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

    public static MainActivity getInstance() {
        return instance;
    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
    public void ClickProcess(View view) {
        Message = (EditText) findViewById(R.id.message);
        final String msg = Message.getText().toString();
        list.add(0,msg);
        IPAddress = (EditText) findViewById(R.id.ip);
        final String ip = IPAddress.getText().toString();
        Port = (EditText) findViewById(R.id.port);
        final int prt = Integer.parseInt(Port.getText().toString());
//passed         System.out.println(ip + prt + msg + "///////////////");

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                new com.github.reneweb.androidasyncsocketexamples.tcp.Client(ip, prt ,msg);
                //passed               System.out.println(ip + " and" + prt);
                return null;
            }
        }.execute();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);
        Message.setText("");
        NumCom =0;
        TextCom = null;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("EiEi  onCreateOptionsMenu 88888888888 ");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("EiEi  onOptionsItemSelected 88888888888 ");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
