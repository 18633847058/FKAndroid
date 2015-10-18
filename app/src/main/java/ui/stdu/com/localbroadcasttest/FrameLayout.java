package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayout extends AppCompatActivity {
    private int currentColor = 1;
    //定义一个颜色数组
    final int[] colors = new int[]{
            R.color.c1,
            R.color.c2,
            R.color.c3,
            R.color.c4,
            R.color.c5,
            R.color.c6
    };
    final int[] names = new int[]{
            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv5,
            R.id.tv6
    };
    TextView[] textViews = new TextView[names.length];
    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            //表明消息来自本程序所发送的
            if(msg.what==0x123){
                for(int i = 0;i<names.length;i++){
                    textViews[i].setBackgroundResource(colors[(i+currentColor)%colors.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        for(int i = 0;i<names.length;i++){
            textViews[i] = (TextView) findViewById(names[i]);
        }
        //定义一个线程周期性的改变currentColor变量值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条空消息通知系统改变6个textview组件的背景色
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
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
