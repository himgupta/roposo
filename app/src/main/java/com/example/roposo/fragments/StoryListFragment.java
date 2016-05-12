package com.example.roposo.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roposo.MainActivity;
import com.example.roposo.R;
import com.example.roposo.Utils.UtilitySingleton;
import com.example.roposo.adapter.StoryModelAdapter;
import com.example.roposo.model.StoryList;

import java.util.ArrayList;

/**
 * Created by himanshugupta on 10/5/16.
 */
public class StoryListFragment extends Fragment implements StoryModelAdapter.CardViewHolder.OnItemClickListener{
    public static final String TAG = "StoryListFragment";
    private ViewGroup rootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<StoryList>datalist;
    private StoryModelAdapter storyModelAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        int index=getArguments().getInt("index");
        loadData(index);
        return rootView;
    }


    private void loadData(int idx){
        if(datalist==null){
            datalist= new ArrayList<>();
        }else{
            datalist.clear();
        }
        datalist.add(getAuthorId(idx));
        datalist.add(MainActivity.storyList.get(idx));
        storyModelAdapter= new StoryModelAdapter(getActivity(),datalist,this);
        mRecyclerView.setAdapter(storyModelAdapter);


    }
    private StoryList getAuthorId(int storyIndex){
        for(StoryList item:MainActivity.authorList){
            if(item.getId().equalsIgnoreCase(MainActivity.storyList.get(storyIndex).getDb()))
                return item;
        }
        return null;
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (view.getId()) {
            case R.id.follow_status:
                TextView textview = (TextView) view;
                ArrayList<String> dbValues = UtilitySingleton.getInstance(getActivity()).getStatusTypes();
                if (dbValues.contains(MainActivity.storyList.get(position).getDb())) {
                    dbValues.remove(MainActivity.storyList.get(position).getDb());
                    textview.setText("Follow");
                } else {
                    dbValues.add(MainActivity.storyList.get(position).getDb());
                    textview.setText("Following");
                }
                textview.setBackgroundResource(R.drawable.oval);
                storyModelAdapter.notifyItemRangeChanged(0,storyModelAdapter.getItemCount());
                break;
        }
    }
}
