package com.example.android.sathwik_saarang_mobops;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sathwik_saarang_mobops.MainActivity;
import com.example.android.sathwik_saarang_mobops.R;
import com.example.android.sathwik_saarang_mobops.RegisterActivity;
import com.example.android.sathwik_saarang_mobops.SendMailActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

public class DetailsActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE11 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE11";
    public final static String EXTRA_MESSAGE12 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE12";

    String title, contact, emailId, coordinates, venue;
    int timeAMPM, timeHour, timeMinute, timeDate, position;
    public String[] subevents = {"lightmusic", "lightmusic", "westernmusic", "westernmusic", "choreo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_details);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);



        //Get intent:
        Intent intent = getIntent();
        title = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        timeAMPM = intent.getIntExtra("timeAMPM", 0);
        timeDate = intent.getIntExtra("date", 0);
        timeHour = intent.getIntExtra("hour", 0);
        timeMinute = intent.getIntExtra("minute", 0);

        venue = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String description = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        String prize = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);
        String coordName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE6);
        contact = intent.getStringExtra(MainActivity.EXTRA_MESSAGE7);
        emailId = intent.getStringExtra(MainActivity.EXTRA_MESSAGE8);
        int imageId = intent.getIntExtra("intVariableName", 0);
        coordinates = intent.getStringExtra(MainActivity.EXTRA_MESSAGE9);
        position = intent.getIntExtra("positionint", 0);

//        Initiate TextView and ImageView:

        TextView textView = (TextView) findViewById(R.id.tv);
        TextView eventTime = (TextView) findViewById(R.id.event_time);
        TextView eventVenue = (TextView) findViewById(R.id.event_venue);
        TextView eventDescription = (TextView) findViewById(R.id.event_description);
        TextView eventPrize = (TextView) findViewById(R.id.event_prize);
        TextView eventCoord = (TextView) findViewById(R.id.event_contact);
        TextView eventMail = (TextView) findViewById(R.id.event_mail_id);
        ImageView eventImage = (ImageView) findViewById(R.id.event_image);

//        Set different values, based on values got through getIntent:

        textView.setText(title);

        //String ampm: to decide whether AM or PM
        String ampm;
        if (timeAMPM == 0) ampm = "AM";
        else ampm = "PM";

        //If minute has single digit, then display it with a preceding '0'
        if (timeMinute < 10)
            eventTime.setText(timeDate + " January, " + timeHour + ":0" + timeMinute + " " + ampm);
        else eventTime.setText(timeDate + " January, " + timeHour + ":" + timeMinute + " " + ampm);

        eventVenue.setText(venue);
        eventDescription.setText(description);
        eventPrize.setText(prize);
        eventCoord.setText(coordName + "\n" + contact);
        eventMail.setText(emailId);
        eventImage.setImageResource(imageId);



    }

    public void callCore(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + contact));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void mailOnClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, SendMailActivity.class);
        intent.putExtra(EXTRA_MESSAGE11, emailId);
        intent.putExtra(EXTRA_MESSAGE12, "Queries | Event: " + title);
        startActivity(intent);
    }


    public void mapOnClick(View view) {
        showMap(Uri.parse(coordinates));
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void calendarOnClick(View view) {

        int timeHour24format = 0;

        //Convert hour to 24 format
        if (timeAMPM == 1) {
            if (timeHour != 12) timeHour24format = timeHour + 12;
            else timeHour24format = timeHour;
        } else if (timeAMPM == 0) {
            if (timeHour == 12) timeHour24format = 0;
            else timeHour24format = timeHour;
        }

        Calendar calendar = new GregorianCalendar(2017, 0, timeDate, timeHour24format, timeMinute, 00);
        addEvent("Attend " + title, venue, calendar);

    }

    public void shareOnClick(View view) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_SUBJECT, "Participate in " + title + " at Saarang 2016");
        share.putExtra(Intent.EXTRA_TEXT, "Participate in " + title + " at #saarang16" + "\nhttp://www.saarang.org/2016/main/events/" + subevents[position] + "/" + title);

        startActivity(Intent.createChooser(share, "Share using"));
    }

    public void addEvent(String title, String location, Calendar begin) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin.getTimeInMillis());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void registerForEvent(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("positionInt", position);
        startActivity(intent);
    }
}

