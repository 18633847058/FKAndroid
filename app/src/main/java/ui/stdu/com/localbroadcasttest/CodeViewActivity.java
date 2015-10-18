package ui.stdu.com.localbroadcasttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by YLQ on 2015/10/15.
 */
public class CodeViewActivity extends Activity {
    //当第一次创建该Activity时调用该方法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建一个线性布局管理器
        LinearLayout layout = new LinearLayout(this);
        //设置该Activity显示layout
        super.setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);
        //创建一个TextView
        final TextView show = new TextView(this);
        //创建一个按钮
        Button btn = new Button(this);
        btn.setText(R.string.ok);
        btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //向layout容器中添加textview
        layout.addView(show);
        //向layout容器中添加按钮
        layout.addView(btn);
        //为按钮绑定一个事件监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("Hello,Android,"+new Date());
            }
        });



        //创建DrawView组件
        final DrawView draw = new DrawView(this);
        //设置自定义组件的最小宽度高度
        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);
        layout.addView(draw);


    }
}
