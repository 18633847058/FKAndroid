package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListView extends AppCompatActivity {
    private String[] names = new String[]{"虎头","弄玉","李清照","李白"};
    private String[] descs = new String[]{"可爱的小孩","一个擅长音乐的小孩","一个擅长文学的女性","浪漫主义诗人"};
    private int[] imageIds = new int[]{R.drawable.tiger,R.drawable.nongyu,R.drawable.qingzhao,R.drawable.libai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        android.widget.ListView list2 = (android.widget.ListView) findViewById(R.id.list2);
        //定义一个数组
        String[] arr= {"孙悟空","猪八戒","牛魔王"};
        //将数组包装为ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.array_item,arr);
        //为listView设置adapter
        list2.setAdapter(adapter);

        List<Map<String,Object>> listitems =
                new ArrayList<>();
        for(int i = 0; i<names.length;i++){
            Map<String,Object> listitem = new HashMap<>();
            listitem.put("header",imageIds[i]);
            listitem.put("personName", names[i]);
            listitem.put("desc", descs[i]);
            listitems.add(listitem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitems,R.layout.simple_item,
                new String[]{"personName","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});
        android.widget.ListView mylist = (android.widget.ListView) findViewById(R.id.mylist);
        mylist.setAdapter(simpleAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被单击了");
            }
        });
        mylist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被选中了");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
