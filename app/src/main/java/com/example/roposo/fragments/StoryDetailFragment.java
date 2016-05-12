package com.example.roposo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roposo.MainActivity;
import com.example.roposo.R;
import com.example.roposo.Utils.UtilitySingleton;
import com.example.roposo.adapter.StoryModelAdapter;

import java.util.ArrayList;

/**
 * Created by himanshugupta on 10/5/16.
 */
public class StoryDetailFragment extends android.support.v4.app.Fragment implements StoryModelAdapter.CardViewHolder.OnItemClickListener {
    public static final String TAG = "StoryDetailFragment";
    private ViewGroup rootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private StoryModelAdapter storyModelAdapter;
//    private ArrayList<StoryList>storyList,authorList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        loadData();
        storyModelAdapter = new StoryModelAdapter(getActivity(),MainActivity.storyList,this);
        mRecyclerView.setAdapter(storyModelAdapter);
        storyModelAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }
        });
        return rootView;
    }

//    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = getActivity().getAssets().open("result.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }
//
//    private void loadData(){
//
//            StoryList[] values= new Gson().fromJson(loadJSONFromAsset(),StoryList[].class);
//
//             storyList = new ArrayList<>();
//            authorList = new ArrayList<>();
//            for(StoryList item:values){
//                if(item.getType()!=null&&item.getType().equalsIgnoreCase("story"))
//                    storyList.add(item);
//                authorList.add(item);
//            }
//
//
//
//    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("himanshu","clicked follow"+position);
        switch (view.getId()){
            case R.id.cardview:
                Bundle bundle = new Bundle();
                bundle.putInt("index",position);
                UtilitySingleton.navigateFragment(new StoryListFragment(),StoryListFragment.TAG,bundle,getActivity());
                break;
            case R.id.follow_status:
                TextView textview =(TextView)view;
                ArrayList<String> dbValues=UtilitySingleton.getInstance(getActivity()).getStatusTypes();
                if(dbValues.contains(MainActivity.storyList.get(position).getDb())) {
                    dbValues.remove(MainActivity.storyList.get(position).getDb());
                    textview.setText("Follow");
                }else{
                    dbValues.add(MainActivity.storyList.get(position).getDb());
                    textview.setText("Following");
                }

                break;
        }

    }
}
