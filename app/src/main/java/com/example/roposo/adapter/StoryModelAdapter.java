package com.example.roposo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.roposo.MainActivity;
import com.example.roposo.R;
import com.example.roposo.Utils.UtilitySingleton;
import com.example.roposo.model.StoryList;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by himanshugupta on 10/5/16.
 */
public class StoryModelAdapter extends RecyclerView.Adapter<StoryModelAdapter.CardViewHolder> {


    Context context;
    List<StoryList> resultSet;
    String modelName;
    final String TAG = "StoryModelAdapter";
    static CardViewHolder.OnItemClickListener onItemClickListener;
    String pickupSubStatus[] = {"1", "2", "9"};

    public StoryModelAdapter(Context context, List<StoryList> jobDetailList, CardViewHolder.OnItemClickListener onItemClickListener) {
        this.resultSet = jobDetailList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;

    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {

        final StoryList jobDetailModel = resultSet.get(position);
        holder.authorName.setText(jobDetailModel.getUsername());
        holder.storyTitle.setText(jobDetailModel.getTitle());
        holder.storyDescription.setText(jobDetailModel.getDescription());
        if(jobDetailModel.getImage()!=null) {
            holder.storyLayout.setVisibility(View.GONE);
            holder.authorLayout.setVisibility(View.VISIBLE);
            holder.authorHandle.setText(jobDetailModel.getHandle());
            holder.authorDescription.setText(jobDetailModel.getAbout());
            holder.authorFollowers.setText(jobDetailModel.getFollowers()+"");
            holder.authorFollowing.setText(jobDetailModel.getFollowing()+"");
            holder.authorCreated.setText(UtilitySingleton.getInstance(context).getDateFromTimestamp(jobDetailModel.getCreatedOn()));
            Glide.with(context).load(jobDetailModel.getImage()).placeholder(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.authorImage);
        }else{
            holder.authorLayout.setVisibility(View.GONE);
            holder.storyImage.setVisibility(View.VISIBLE);
            Glide.with(context).load(jobDetailModel.getSi()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.storyImage);
        }
        ArrayList<String> dbValues=UtilitySingleton.getInstance(context).getStatusTypes();
        if(dbValues.contains(MainActivity.storyList.get(position).getDb())||(jobDetailModel.getIsFollowing())) {
            holder.followStory.setText("Following");
        }else{
            holder.followStory.setText("Follow");
        }
        holder.followStory.setBackgroundResource(R.drawable.oval);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_cardlayout, parent, false);

        return new CardViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return resultSet.size();
    }

//    public void setAnimation(View view, int position) {
//
//
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.to_top);
//        animation.setStartOffset(1000);
//        view.startAnimation(animation);
//
//    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView authorName;
        TextView storyTitle;
        TextView storyDescription;
        TextView followStory;
        TextView authorHandle;
        TextView authorDescription;
        TextView authorFollowers;
        TextView authorFollowing;
        TextView authorCreated;
        ImageView authorImage;
        ImageView storyImage;
        RelativeLayout authorLayout;
        LinearLayout storyLayout;

        public CardViewHolder(View itemView) {
            super(itemView);

            authorName = (TextView) itemView.findViewById(R.id.author_name);
            storyTitle = (TextView) itemView.findViewById(R.id.story_title);
            storyDescription = (TextView) itemView.findViewById(R.id.story_description);
            followStory = (TextView) itemView.findViewById(R.id.follow_status);
            authorHandle = (TextView) itemView.findViewById(R.id.author_handle);
            authorDescription = (TextView) itemView.findViewById(R.id.author_desc);
            authorFollowers = (TextView) itemView.findViewById(R.id.author_followers);
            authorFollowing = (TextView) itemView.findViewById(R.id.author_following);
            authorCreated = (TextView) itemView.findViewById(R.id.author_created);
            authorImage = (ImageView) itemView.findViewById(R.id.author_image);
            storyImage = (ImageView) itemView.findViewById(R.id.story_image);
            authorLayout=(RelativeLayout)itemView.findViewById(R.id.author_layout);
            storyLayout=(LinearLayout) itemView.findViewById(R.id.story_layout);
            itemView.setOnClickListener(this);
            followStory.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, this.getAdapterPosition());
//            this.onItemClick(getAdapterPosition());
        }


//    public void addAll(List<JobDetail> data) {
//        resultSet.addAll(data);
//    }

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
        }

    }
}
