package com.github.renewb.androidasyncsocketexamples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.reneweb.androidasyncsocketexamples.R;

public class SettingPage extends ActionBarActivity {
    EditText ip,port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
        ip = (EditText)findViewById(R.id.ip);
        port = (EditText)findViewById(R.id.port);
        bindView();
        initView();
    }
    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.submit).setOnClickListener(new InnerOnClickListener());
    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.submit:
                    SendAndNext(ip.getText().toString(),port.getText().toString());
                    break;

            }
//            hideKeyboardInput(v);
        }
    }

    private void SendAndNext(String ip,String port) {
        IPAndPort ippo = new IPAndPort();
        ippo.setIP(ip);
        ippo.setPort(port);
        Intent intent = new Intent (this,SetiingCmdPage.class);
        startActivity(intent);
    }
}
