package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextView extends AppCompatActivity {
    android.widget.AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    //定义字符串数组，作为提示的文本
    String[] books =new String[]{
            "Android讲义",
            "Java讲义",
            "Ajax讲义",
            "XML讲义"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        //创建一个ArrayAdapter，封装数组
        ArrayAdapter<String> aa =new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,books);
        actv = (android.widget.AutoCompleteTextView) findViewById(R.id.auto);
        actv.setAdapter(aa);
        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        //为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


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
