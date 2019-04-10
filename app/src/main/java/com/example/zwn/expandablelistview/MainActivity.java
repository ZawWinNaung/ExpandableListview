package com.example.zwn.expandablelistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private CustomExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvExp);
        initData();
        listAdapter = new CustomExpandableListAdapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        List<String> cricket = new ArrayList<>();
        cricket.add("India");
        cricket.add("England");
        cricket.add("Australia");
        cricket.add("Pakistan");

        List<String> football = new ArrayList<>();
        football.add("Brazil");
        football.add("England");
        football.add("Spain");
        football.add("Italy");

        List<String> basketball = new ArrayList<>();
        basketball.add("United States");
        basketball.add("Argentina");
        basketball.add("Russia");
        basketball.add("France");

        listHashMap.put("Cricket",cricket);
        listHashMap.put("Football",football);
        listHashMap.put("Basketball",basketball);

        listDataHeader = new ArrayList<>(listHashMap.keySet());
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
