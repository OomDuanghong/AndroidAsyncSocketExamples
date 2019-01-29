package com.github.renewb.androidasyncsocketexamples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.github.reneweb.androidasyncsocketexamples.R;

public class DirectControl extends ActionBarActivity {

    CmdControl cmd = new CmdControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_control);
        bindView();
        initView();
    }
    private void bindView(){

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.pos1).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.pos2).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.pos3).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.pos4).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btndct_back).setOnClickListener(new InnerOnClickListener());
    }
    class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.pos1:
                    Next(1);
                    break;
                case R.id.pos2:
                    Next(2);
                    break;
                case R.id.pos3:
                    Next(3);
                    break;
                case R.id.pos4:
                    Next(4);
                    break;
                case R.id.btndct_back:
                    Next(5);
                    break;
            }
//            hideKeyboardInput(v);
        }
    }

    private void Next(int position) {

    }
}
