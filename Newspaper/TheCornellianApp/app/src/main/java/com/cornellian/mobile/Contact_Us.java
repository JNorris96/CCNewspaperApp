package com.cornellian.mobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contact_Us extends AppCompatActivity {

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();
        configureEmailButton();
    }
    //Function to configure the Home page button.
    private void configureMainButton()
    {
        Button mainButton = (Button) findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Contact_Us.this, Main.class));
            }
        });
    }
    //Function to configure the About Us button.
    private void configureAboutUsButton()
    {
        Button aboutUsButton = (Button) findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Contact_Us.this, About_Us.class));
            }
        });
    }
    //Function to configure the Contact Us button.
    private void configureContactUsButton()
    {
        Button contactUsButton = (Button) findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Contact_Us.this, Contact_Us.class));
            }
        });
    }
    //Function to configure the archive button.
    private void configureArchiveButton()
    {
        Button archiveButton = (Button) findViewById(R.id.ArchiveButton);
        archiveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        /** Tells the content provider what needs to be accessed. Content providers connect data in one process with
                         * another data in another process.
                        **/
                        Uri.parse("http://cornellcollege.advantage-preservation.com/")));
            }
        });
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
