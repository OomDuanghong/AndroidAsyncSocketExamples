package com.github.renewb.androidasyncsocketexamples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.github.reneweb.androidasyncsocketexamples.R;

public class SetTimeAndPressure extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_and_pressure);
    }

    NumberPicker np= (NumberPicker) findViewById(R.id.numberPicker);
//    np.setMaxValue(9);
//    np.setMinValue(0);
//    np.setWrapSelectorWheel(false);

}
