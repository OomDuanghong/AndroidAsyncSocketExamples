package com.github.renewb.androidasyncsocketexamples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.reneweb.androidasyncsocketexamples.R;

import java.io.FileOutputStream;

import static android.provider.ContactsContract.Intents.Insert.NOTES;

public class settingMode2 extends ActionBarActivity {
//    SetPressureAndMinute dataMode2 = new SetPressureAndMinute();
    EditText psi[],sec[],deflate;
    String dataP,dataS,mode;
    double pressure[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_mode2);
        psi[0] = (EditText) findViewById(R.id.Prein1_mode2);
        psi[1] = (EditText) findViewById(R.id.Prein2_mode2);
        psi[2] = (EditText) findViewById(R.id.Prein3_mode2);
        psi[3] = (EditText) findViewById(R.id.Prein4_mode2);
        sec[0] = (EditText) findViewById(R.id.Secin1_mode2);
        sec[1] = (EditText) findViewById(R.id.Secin2_mode2);
        sec[2] = (EditText) findViewById(R.id.Secin3_mode2);
        sec[3] = (EditText) findViewById(R.id.Secin4_mode2);
        deflate = (EditText) findViewById(R.id.deflate_mode2);
        for(int i=0;i<4;i++){
            pressure[i] = (((5*Integer.parseInt((psi[i]).getText().toString()))-(0*(Integer.parseInt((psi[i]).getText().toString())))/(0.8*1023))*(1023-(0.1*1023)))+(0*(Integer.parseInt((psi[i]).getText().toString())));
        }
        bindView();
        initView();
    }

    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_back_mode2).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.user_mode2).setOnClickListener(new InnerOnClickListener());

    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.user_mode2:
                    CollectData("Sec_mode","Pre_mode");
                    Next(1);
                    break;
                case R.id.btn_back_mode2:
                    Next(2);
                    break;

            }
//            hideKeyboardInput(v);
        }
    }

    private void CollectData(String fileS,String fileP) {

//        FileOutputStream fos = null;
        for(int j=0;j<4;j++) {
            writeTofile((sec[j]).getText().toString(),fileS);
        }
//        for(int i=0;i<4;i++) {
//            writeTofile(String.valueOf(pressure[i]),fileP);
//        }
//        dataS = dataS + deflate;
//        try {
//            fos = openFileOutput(fileS, MODE_APPEND);
//            fos.write(dataS.getBytes());
//            Toast.makeText(this, "Saved to " + getFilesDir().getAbsolutePath() + "/" + NOTES, Toast.LENGTH_LONG).show();
//        }
//        catch (Throwable t) {
//
//        }


//        FileOutputStream fos1 = null;
//        for(int j=0;j<4;j++) {
//            dataP = pressure[j] + "\n";
//        }
//        dataP = dataP + mode;
//        try {
//            fos1 = openFileOutput(fileP, MODE_APPEND);
//            fos1.write(dataS.getBytes());
//            Toast.makeText(this, "Saved to " + getFilesDir().getAbsolutePath() + "/" + NOTES, Toast.LENGTH_LONG).show();
//        }
//        catch (Throwable t) {
//
//        }

    }

    private void Next(int number) {
        if(number == 1){
//            getvalue();
//            writeTofile(,"mode1");
            Intent intent = new Intent (this,UserPage.class);
            startActivity(intent);
        }else if (number == 2){
            Intent intent = new Intent (this,FirstSetting.class);
            startActivity(intent);
        }
    }

    private void writeTofile(String dat,String file) {
//        System.out.println(dat);
        FileOutputStream fos = null;
        String data = dat + "\n";
        try {
            fos = openFileOutput(file, MODE_APPEND);
            fos.write(data.getBytes());
            Toast.makeText(this, "Saved to " + getFilesDir().getAbsolutePath() + "/" + NOTES, Toast.LENGTH_LONG).show();
        }
        catch (Throwable t) {

        }
    }

    private void getvalue() {
//        psi[0] = ((EditText) findViewById(R.id.Prein1_mode2)).getText().toString();
//        psi[1] = ((EditText) findViewById(R.id.Prein2_mode2)).getText().toString();
//        psi[2] = ((EditText) findViewById(R.id.Prein3_mode2)).getText().toString();
//        psi[3] = ((EditText) findViewById(R.id.Prein4_mode2)).getText().toString();
//        sec[0] = ((EditText) findViewById(R.id.Secin1_mode2)).getText().toString();
//        sec[1] = ((EditText) findViewById(R.id.Secin2_mode2)).getText().toString();
//        sec[2] = ((EditText) findViewById(R.id.Secin3_mode2)).getText().toString();
//        sec[3] = ((EditText) findViewById(R.id.Secin4_mode2)).getText().toString();
//        for(int i=0;i<4;i++) {
//            dataMode2.setPressure(psi[i], i);
//            dataMode2.setSec(sec[i],i);
//        }
//        dataMode2.setDeflate(((EditText)findViewById(R.id.deflate_mode2)).getText().toString());
//        dataMode2.setMode("mode2");
     }


//    private void writeTofile(String dat,String file) {
////        System.out.println(dat);
//        FileOutputStream fos = null;
//        String data = dat + "\n";
//        try {
//            fos = getActivity().openFileOutput(file, MODE_APPEND);
//            fos.write(data.getBytes());
//            Toast.makeText( "Saved to " + getContext().getFilesDir().getAbsolutePath() + "/" + NOTES, Toast.LENGTH_LONG).show();
//        }
//        catch (Throwable t) {
//
//        }

    }
