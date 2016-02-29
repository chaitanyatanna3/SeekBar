package com.example.chaitanya.seekbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seekR, seekG, seekB;
    SeekBar seekRed, seekGreen, seekBlue;
    LinearLayout mScreen;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextView = (TextView) findViewById(R.id.textView);
        mScreen = (LinearLayout) findViewById(R.id.myScreen);
        seekRed = (SeekBar) findViewById(R.id.seekBarR);
        seekGreen = (SeekBar) findViewById(R.id.SeekBarG);
        seekBlue = (SeekBar) findViewById(R.id.SeekBarB);

        seekRed.setOnSeekBarChangeListener(seekBarChangeListener);
        seekGreen.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBlue.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //updateBackground();
            switch (seekBar.getId()) {
                case R.id.seekBarR:
                    seekR = progress;
                    break;
                case R.id.SeekBarG:
                    seekG = progress;
                    break;
                case R.id.SeekBarB:
                    seekB = progress;
                    break;
            }
            doSomethingWithColor();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

//    private void updateBackground() {
//        seekR = seekRed.getProgress();
//        seekG = seekGreen.getProgress();
//        seekB = seekBlue.getProgress();
//        mScreen.setBackgroundColor(
//                0xff000000 + seekR * 0x1000 + seekG * 0x100 + seekB
//        );
//    }

    private void doSomethingWithColor() {
        int color = Color.rgb(seekR,  seekG, seekB);
        mTextView.setTextColor(color);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
