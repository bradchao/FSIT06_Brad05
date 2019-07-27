package tw.org.iii.appps.brad05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private int[] to = {R.id.item_title};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    private String[] from = {"brad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){

        for (int i=0; i<10; i++) {
            HashMap<String, String> row = new HashMap<>();
            row.put("brad", "Item: " + (int) (Math.random() * 38 + 1));
            data.add(row);
        }

        adapter = new SimpleAdapter(this, data,
                R.layout.item, from, to);
        listView.setAdapter(adapter);
    }



}
