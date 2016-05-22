package com.example.android.sathwik_saarang_mobops;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sathwik_saarang_mobops.R;

public class SendMailActivity extends AppCompatActivity {

    String emailId, subject, composeText;
    EditText composeEdit, subjectEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        Intent intent = getIntent();
        emailId = intent.getStringExtra(com.example.android.sathwik_saarang_mobops.MainActivity.EXTRA_MESSAGE11);
        subject = intent.getStringExtra(com.example.android.sathwik_saarang_mobops.MainActivity.EXTRA_MESSAGE12);


        TextView to = (TextView) findViewById(R.id.mail_to_email_id);
        subjectEdit = (EditText) findViewById(R.id.mail_subject);
        composeEdit = (EditText) findViewById(R.id.mail_message);

        to.setText("To: " + emailId);
        subjectEdit.setText(subject);


    }

    public void composeEmail(View view) {

        composeText = composeEdit.getText().toString();
        subject = subjectEdit.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailId});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, composeText);

        //If nothing is entered in Compose email
        if (composeText.length() == 0) {
            Context presentContext = getApplicationContext();
            CharSequence text = "Compose email should not be blank";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(presentContext, text, duration);
            toast.show();
        } else if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
