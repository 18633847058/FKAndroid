package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class GridLayout extends AppCompatActivity {
    android.widget.GridLayout gridLayout;
    //定义16个按钮的文本
    String[] chars = new String[]{
            "7","8","9","÷",
            "4","5","6","×",
            "1","2","3","-",
            ".","0","=","+",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        gridLayout = (android.widget.GridLayout) findViewById(R.id.root);
        for(int i = 0; i<chars.length;i++){
            Button btn = new Button(this);
            btn.setText(chars[i]);
            //设置该按钮的字体大小
            btn.setTextSize(40);
            //设置按钮四周的空白区域
            btn.setPadding(5,35,5,35);
            //指定该组件所在的行
            android.widget.GridLayout.Spec rowSpec =android.widget.GridLayout.spec(i / 4 + 2);
            //指定该组件所在的列
            android.widget.GridLayout.Spec columnSpec = android.widget.GridLayout.spec(i%4);
            android.widget.GridLayout.LayoutParams params = new android.widget.GridLayout.LayoutParams(rowSpec,columnSpec);
            //指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridLayout.addView(btn,params);
        }

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
