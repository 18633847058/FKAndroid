package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Chronometer extends AppCompatActivity {
    android.widget.Chronometer ch;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        ch = (android.widget.Chronometer) findViewById(R.id.ch);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置开始计时时间
                ch.setBase(SystemClock.elapsedRealtime());
                //启动计时器
                ch.start();
                start.setEnabled(false);
            }
        });
        //为Chronometer绑定事件监听器
        ch.setOnChronometerTickListener(new android.widget.Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(android.widget.Chronometer chronometer) {
                //如果从开始计时到现在超过了20s
                if(SystemClock.elapsedRealtime() - ch.getBase() > 20*1000){
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
