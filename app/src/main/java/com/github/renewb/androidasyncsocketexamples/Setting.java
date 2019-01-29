package com.github.renewb.androidasyncsocketexamples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.reneweb.androidasyncsocketexamples.R;

public class Setting extends ActionBarActivity {

    SetPressureAndMinute dataMode1 = new SetPressureAndMinute();
    String psi[],sec[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bindView();
        initView();
    }

    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_back_mode1).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.user_mode1).setOnClickListener(new InnerOnClickListener());

    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.user_mode1:
                    Next(1);
                    break;
                case R.id.btn_back_mode1:
                    Next(2);
                    break;

            }
//            hideKeyboardInput(v);
        }
    }

    private void Next(int number) {
        if(number == 1){
            psi[0] = ((EditText) findViewById(R.id.Prein1_mode1)).getText().toString();
            psi[1] = ((EditText) findViewById(R.id.Prein2_mode1)).getText().toString();
            psi[2] = ((EditText) findViewById(R.id.Prein3_mode1)).getText().toString();
            psi[3] = ((EditText) findViewById(R.id.Prein4_mode1)).getText().toString();
            sec[0] = ((EditText) findViewById(R.id.Secin1_mode1)).getText().toString();
            sec[1] = ((EditText) findViewById(R.id.Secin2_mode1)).getText().toString();
            sec[2] = ((EditText) findViewById(R.id.Secin3_mode1)).getText().toString();
            sec[3] = ((EditText) findViewById(R.id.Secin4_mode1)).getText().toString();
            for(int i=0;i<4;i++) {
                dataMode1.setPressure(psi[i], i);
                dataMode1.setSec(sec[i],i);
            }
            dataMode1.setDeflate(((EditText)findViewById(R.id.deflate_mode1)).getText().toString());
            dataMode1.setMode("mode1");
            Intent intent = new Intent (this,UserPage.class);
            startActivity(intent);
        }else if (number == 2){
            Intent intent = new Intent (this,FirstSetting.class);
            startActivity(intent);
        }
    }


}
