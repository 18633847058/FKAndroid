package ui.stdu.com.localbroadcasttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridView extends AppCompatActivity {

    android.widget.GridView grid;
    ImageView imageView;
    int[] imageIds = new int[]{
            R.drawable.bomb5,R.drawable.bomb6,R.drawable.bomb7,R.drawable.bomb8,
            R.drawable.bomb9,R.drawable.bomb10,R.drawable.bomb11,R.drawable.bomb12,
            R.drawable.bomb13,R.drawable.bomb14,R.drawable.bomb15,R.drawable.bomb16
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        imageView = (ImageView) findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.cell,
                new String[]{"image"}, new int[]{R.id.image1});
        grid = (android.widget.GridView) findViewById(R.id.gv1);
        grid.setAdapter(simpleAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
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
