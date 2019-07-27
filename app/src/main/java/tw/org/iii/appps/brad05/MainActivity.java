package tw.org.iii.appps.brad05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);

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


    public void addItem(View view) {
        HashMap<String, String> row = new HashMap<>();
        row.put("brad", input.getText().toString());
        data.add(0,row);

        adapter.notifyDataSetChanged();
    }

    public void search(View view) {
        String key = input.getText().toString();
        Log.v("brad", "size: " + data.size());

        LinkedList<HashMap<String,String>> temp = new LinkedList<>();
        for (HashMap<String,String> row : data){
            String brad = row.get("brad");
            if (brad.contains(key)){
                temp.add(row);
                Log.v("brad", brad);
            }
        }

        data.clear();
        for (HashMap<String,String> row : temp){
            data.add(row);
        }


        adapter.notifyDataSetChanged();
    }
}
