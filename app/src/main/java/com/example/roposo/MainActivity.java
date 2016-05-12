package com.example.roposo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.roposo.fragments.StoryDetailFragment;
import com.example.roposo.model.StoryList;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<StoryList>storyList,authorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,new StoryDetailFragment());
        fragmentTransaction.commit();
        loadData();


    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("result.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void loadData(){

        StoryList[] values= new Gson().fromJson(loadJSONFromAsset(),StoryList[].class);

        storyList = new ArrayList<>();
        authorList = new ArrayList<>();
        for(StoryList item:values){
            if(item.getType()!=null&&item.getType().equalsIgnoreCase("story"))
                storyList.add(item);
            authorList.add(item);
        }



    }
}
