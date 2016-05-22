package com.example.android.sathwik_saarang_mobops;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sathwik_saarang_mobops.R;

/**
 * Created by Sathwik on 24-04-2016
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    public final static String EXTRA_MESSAGE1 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE1";
    public final static String EXTRA_MESSAGE3 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE3";
    public final static String EXTRA_MESSAGE4 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE4";
    public final static String EXTRA_MESSAGE5 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE5";
    public final static String EXTRA_MESSAGE6 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE6";
    public final static String EXTRA_MESSAGE7 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE7";
    public final static String EXTRA_MESSAGE8 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE8";
    public final static String EXTRA_MESSAGE9 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE9";


    public String[] events = {"Raagapella", "Alankar", "Decibels", "Vox", "$treet$"};

    int timeDate[] = {2, 3, 2, 3, 4};
    int timeHour[] = {10, 9, 8, 9, 4};
    int timeMinute[] = {30, 5, 30, 30, 30};
    int timeAMPM[] = {0, 0, 0, 0, 1};


    public String[] venue = {"Central Lecture Theatre", "HSB Seminar Hall", "SAC Entrance", "SAC Main Stage", "SAC Bowl"};
    public String[] description = {"LM Saarang has its one of a kind, nouvelle vague event, Raagapella, tailored to fit just your needs. Come over, harmonise, clap and snap, and enjoy yourself. There is also a large audience looking forward to your mesmerising harmonies.", "Introducing LM's one and only solo singing competition Alankar where you can battle it out with over a hundred vocalists while being judged by the best singing talents out there.", "Think you have what it takes to compete against some of the best bands in the country? Then waste no time and sign your band up for Saarang Decibels 2016, one of India’s premier competitions for semi-professional bands to make your claim to fame.", "Saarang gives you a platform to get out there and win hearts with your vocal talent. This solo singing competition in 2 stages pushes you to discover the best in you.Vox is a great stage for aspiring vocalists to showcase their talent.", "Nothing like a Dance Battle. And nothing like $TREET$ when it comes to B-Boying and Freestyle. $TREET$ is one of the biggest B-Boying and Freestyle events in India. Teams will be judged by the best B-Boys in the world like HAVIKORO, B-Boy GONZA ,B-Boy SPICE and B-Boy CHINO."};
    public String[] prize = {"Prize money worth 30,000 INR!", "Prize money worth 10,000 INR!", "Prize money worth 70,000 INR!", "Prize money worth 30,000 INR!", "Prize money worth 90,000 INR!"};
    public String[] coordName = {"Isaac Newton", "Thomas Alwa Edison", "Nicolas Tesla", "Dennis Ritchie", "Werner Heisenberg"};
    public String[] coordContact = {"+91 7734015653", "+91 9546474845", "+91 8746383930", "+91 7478393038", "+91 9474833038"};
    public String[] coordEmailId = {"newtonisaac@saarang.com", "edisonthomas@saarang.com", "teslanicolas@saarang.com", "ritchiedennis@saarang.com", "heisenbergwerner@saarang.com"};
    public String[] subevents = {"Light Music", "Light Music", "Western Music", "Western Music", "Choreo"};
    public int[] imageAddress = {R.drawable.saarang_raagapella, R.drawable.saarang_alankar, R.drawable.saarang_decibels, R.drawable.saarang_vox, R.drawable.saarang_street};
    public String[] coordinates = {"geo:12.989530, 80.232084?z=20", "geo:12.989886, 80.231946?z=20", "geo:12.989476, 80.237367?z=20", "geo:12.989288, 80.238087?z=20", "geo:12.989387, 80.237783?z=20"};


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView title, subtitle;
        public final ImageView titleImage;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            title = (TextView) itemView.findViewById(R.id.text_decibels);
            subtitle = (TextView) itemView.findViewById(R.id.text_event);
            titleImage = (ImageView) itemView.findViewById(R.id.image_saarang_background);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(events[position]);
        holder.subtitle.setText(subevents[position]);
        holder.titleImage.setImageResource(imageAddress[position]);


        holder.titleImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, com.example.android.sathwik_saarang_mobops.DetailsActivity.class);

                intent.putExtra(EXTRA_MESSAGE1, events[position]);
                intent.putExtra("timeAMPM", timeAMPM[position]);
                intent.putExtra("date", timeDate[position]);
                intent.putExtra("hour", timeHour[position]);
                intent.putExtra("minute", timeMinute[position]);
                intent.putExtra(EXTRA_MESSAGE3, venue[position]);
                intent.putExtra(EXTRA_MESSAGE4, description[position]);
                intent.putExtra(EXTRA_MESSAGE5, prize[position]);
                intent.putExtra(EXTRA_MESSAGE6, coordName[position]);
                intent.putExtra(EXTRA_MESSAGE7, coordContact[position]);
                intent.putExtra(EXTRA_MESSAGE8, coordEmailId[position]);
                intent.putExtra("intVariableName", imageAddress[position]);
                intent.putExtra(EXTRA_MESSAGE9, coordinates[position]);
                intent.putExtra("positionint", position);


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.length;
    }

}

