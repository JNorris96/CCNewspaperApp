package com.cornellian.mobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Contact_Us extends AppCompatActivity
{

    Spinner activitySpinner;
    int currentActivity = 2;

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        activitySpinner = findViewById(R.id.activitySelector);
        activitySpinner.setSelection(currentActivity, false);

        activitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                final Intent intent;
                switch (position)
                {
                    case 0:
                        intent = new Intent(Contact_Us.this, Main.class);
                        break;
                    case 1:
                        intent = new Intent(Contact_Us.this, About_Us.class);
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cornellcollege.advantage-preservation.com/"));
                        break;
                    case 2:
                        default:
                            return;
                }
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                return;
            }
        });
        configureEmailButton();
    }

    //Function to configure the email button.
    private void configureEmailButton()
    {
        Button EmailButton = findViewById(R.id.EmailButton);
        EmailButton.setOnClickListener(new View.OnClickListener()
        {
                @Override
                public void onClick(View view)
                {
                    startActivity
                            (new Intent(Intent.ACTION_VIEW));
                    Uri data = Uri.parse("mailto: thecornellian@cornellcollege.edu");
                    intent.setData(data);
                    intent.setType("message/rfc822");
                    String [] recipient = {"thecornellian@cornellcollege.edu"};
                    intent.putExtra(Intent.EXTRA_EMAIL, recipient);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Letter to the Editor");
                }
        });
    }

    //Activity to set the intent of the website button.
    public void website(View view)
    {
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.cornellcollege.edu/"));
        startActivity(websiteIntent);
    }
    //Activity to set the intent of the Facebook button.
    public void facebook(View view)
    {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/TheCornellian/"));
        startActivity(facebookIntent);
    }
    //Activity to set the intent of the Twitter button.
    public void twitter(View view)
    {
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.twitter.com")); //TODO
        startActivity(twitterIntent);
    }
}
