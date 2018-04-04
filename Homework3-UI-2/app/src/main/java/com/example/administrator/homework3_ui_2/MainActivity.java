package com.example.administrator.homework3_ui_2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.homework3_ui_2.model.User;
import com.example.administrator.homework3_ui_2.model.UsersArrayAdapter;
import com.example.administrator.homework3_ui_2.model.UsersBaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnArrayAdapter;
    Button btnBaseAdapter;
    Button btnSimpleAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UsersArrayAdapter usersArrayAdapter = new UsersArrayAdapter(this, getUsers());
        listView = (ListView) findViewById(R.id.listView);
        //listView.setAdapter(usersArrayAdapter);

        btnArrayAdapter = (Button)findViewById(R.id.btnArrayAdapter);
        btnBaseAdapter = (Button)findViewById(R.id.btnBaseAdapter);
        btnSimpleAdapter = (Button)findViewById(R.id.btnSimpleAdapter);

        btnArrayAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UsersArrayAdapter usersArrayAdapter = new UsersArrayAdapter(MainActivity.this, getUsers());
                listView.setAdapter(usersArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        User item = usersArrayAdapter.getItem(position);
                        if(item.getId().equals("15301078")) {
                            Toast.makeText(MainActivity.this, R.string.ArrayAdapterText, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Toast.makeText(MainActivity.this, R.string.btnArrayAdapterText, Toast.LENGTH_LONG).show();
            }
        });

        btnBaseAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UsersBaseAdapter usersBaseAdapter = new UsersBaseAdapter(MainActivity.this, getUsers());
                listView.setAdapter(usersBaseAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        User item = (User)usersBaseAdapter.getItem(position);
                        if(item.getId().equals("15301078")) {
                            Toast.makeText(MainActivity.this, R.string.BaseAdapterText, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Toast.makeText(MainActivity.this, R.string.btnBaseAdapterText, Toast.LENGTH_LONG).show();
            }
        });

        btnSimpleAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] from = {"name", "id", "image"};
                int[] to = {R.id.tvName, R.id.tvID, R.id.imageView};
                final SimpleAdapter usersSimpleAdapter = new SimpleAdapter(MainActivity.this, getHashMapUsers(), R.layout.item_user, from, to);
                listView.setAdapter(usersSimpleAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        HashMap item = (HashMap)usersSimpleAdapter.getItem(position);
                        if(item.get("id").equals("15301078")) {
                            Toast.makeText(MainActivity.this, R.string.SimpleAdapterText, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, item.get("name").toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Toast.makeText(MainActivity.this, R.string.btnSimpleAdapterText, Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user;
        Resources resources = getResources();

        user = new User("吴静远", "15301078", resources.getDrawable(R.drawable.head));
        users.add(user);
        user = new User("楼上太帅了", "666", resources.getDrawable(R.drawable.cat));
        users.add(user);
        user = new User("二楼说得对", "66666", resources.getDrawable(R.drawable.weixin));
        users.add(user);

        return users;
    }

    private ArrayList<HashMap<String, Object >> getHashMapUsers() {
        ArrayList<HashMap<String, Object>> users = new ArrayList<>();
        ArrayList<User> list = getUsers();
        int[] img = {R.drawable.head, R.drawable.cat, R.drawable.weixin};
        int i = 0;

        for (User user: list) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", user.getName());
            hashMap.put("id", user.getId());
            hashMap.put("image", img[i]);
            users.add(hashMap);
            i++;
        }

        return users;
    }

    /*
    public class UsersArrayAdapter extends ArrayAdapter<User> {
        public UsersArrayAdapter(Context context, ArrayList<User> users) {
            super(context, 0, users);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            User user = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }

            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvID = (TextView) convertView.findViewById(R.id.tvID);

            tvName.setText(user.getName());
            tvID.setText(user.getId());

            return convertView;
        }
    }
    */
}
