package com.github.renewb.androidasyncsocketexamples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.github.reneweb.androidasyncsocketexamples.R;

public class FirstSetting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setting);
        bindView();
        initView();
    }

    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.mode1_setting).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.mode2_setting).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.mode3_setting).setOnClickListener(new InnerOnClickListener());
    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mode1_setting:
                    Next(1);
                    break;
                case R.id.mode2_setting:
                    Next(2);
                    break;
                case R.id.mode3_setting:
                    Next(3);
                    break;
//                case R.id.btn_back:
//                    Next(4);
//                    break;
            }
//            hideKeyboardInput(v);
        }
    }

    private void Next(int i) {
        if (i == 1){
            Intent intent = new Intent (this,Setting.class);
            startActivity(intent);
        }else if (i == 2){
            Intent intent = new Intent (this,settingMode2.class);
            startActivity(intent);
        }else if (i==3){
            Intent intent = new Intent (this,settingMode3.class);
            startActivity(intent);
        }
    }
}
