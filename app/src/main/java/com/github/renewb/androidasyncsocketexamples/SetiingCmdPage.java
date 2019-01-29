package com.github.renewb.androidasyncsocketexamples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.github.reneweb.androidasyncsocketexamples.R;

public class SetiingCmdPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setiing_cmd_page);
        bindView();
        initView();
    }

    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_directcontrol).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_manual).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_automode).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_back).setOnClickListener(new InnerOnClickListener());
    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_directcontrol:
                    Next(1);
                    break;
                case R.id.btn_manual:
                    Next(2);
                    break;
                case R.id.btn_automode:
                    Next(3);
                    break;
                case R.id.btn_back:
                    Next(4);
                    break;
            }
//            hideKeyboardInput(v);
        }
    }

    private void Next(int number) {
        if(number == 1){
            Intent intent = new Intent (this,DirectControl.class);
            startActivity(intent);
        }else if (number == 2){
            Intent intent = new Intent (this,ManualMode.class);
            startActivity(intent);
        }else if (number == 3) {
            Intent intent = new Intent (this,AutoMode.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this,SettingPage.class);
            startActivity(intent);
        }
    }

}
