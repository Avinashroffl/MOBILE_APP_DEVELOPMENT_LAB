package com.example.lab2d19it014;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;

public class Teamdetails extends AppCompatActivity {

    private GridView gridview1;
    // Create a new Array of type HashMap
    private final ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamdetails);

        gridview1 = (GridView) findViewById(R.id.mainGridView1);

        gridview1.setOnItemClickListener(new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4){
                Toast.makeText(getApplicationContext(), maplist.get(p3).get("title").toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Add items to the Map list
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Karthi");
            _item.put("icon", R.drawable.male);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Avi");
            _item.put("icon",R.drawable.avi);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Vino");
            _item.put("icon",R.drawable.female);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Juhi");
            _item.put("icon",R.drawable.female);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Sharon");
            _item.put("icon",R.drawable.female);
            maplist.add(_item);
        }

        GridAdapter adapter = new GridAdapter(this);
        gridview1.setAdapter(adapter);
    }

    public class GridAdapter extends BaseAdapter {
        private Context mContext;
        public GridAdapter(Context c) {
            mContext = c;
        }
        public int getCount() {
            return maplist.size();
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            // Inflate the layout for each list item
            LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (v == null) {
                v = _inflater.inflate(R.layout.list_item, null);
            }
            // Get the TextView and ImageView from CustomView for displaying item
            TextView txtview = (TextView) v.findViewById(R.id.listitemTextView1);
            ImageView imgview = (ImageView) v.findViewById(R.id.listitemImageView1);

            // Set the text and image for current item using data from map list
            txtview.setText(maplist.get(position).get("title").toString());
            imgview.setImageResource((Integer) maplist.get(position).get("icon"));
            return v;
        }
    }
}