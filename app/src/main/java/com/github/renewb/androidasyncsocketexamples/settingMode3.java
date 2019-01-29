package com.github.renewb.androidasyncsocketexamples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.reneweb.androidasyncsocketexamples.R;

public class settingMode3 extends ActionBarActivity {
    SetPressureAndMinute dataMode2 = new SetPressureAndMinute();
    String psi[],sec[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_mode3);
        bindView();
        initView();
    }

    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_back_mode3).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.user_mode3).setOnClickListener(new InnerOnClickListener());

    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.user_mode3:
                    Next(1);
                    break;
                case R.id.btn_back_mode3:
                    Next(2);
                    break;

            }
//            hideKeyboardInput(v);
        }
    }

    private void Next(int number) {
        if(number == 1){
//            getvalue();
            Intent intent = new Intent (this,UserPage.class);
            startActivity(intent);
        }else if (number == 2){
            Intent intent = new Intent (this,FirstSetting.class);
            startActivity(intent);
        }
    }

    private void getvalue() {
        psi[0] = ((EditText) findViewById(R.id.Prein4_mode3)).getText().toString();
        sec[0] = ((EditText) findViewById(R.id.Secin4_mode3)).getText().toString();
        for(int i=0;i<4;i++) {
            dataMode2.setPressure(psi[i], i);
            dataMode2.setSec(sec[i],i);
        }
        dataMode2.setDeflate(((EditText)findViewById(R.id.deflate_mode3)).getText().toString());
        dataMode2.setMode("mode3");
    }
}
