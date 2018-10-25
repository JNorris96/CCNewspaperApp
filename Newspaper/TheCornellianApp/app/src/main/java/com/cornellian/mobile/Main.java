package com.cornellian.mobile;

import android.content.Intent;
import android.net.Uri;
/*URI identifies an abstract/physical resource in the web. Objects in the web are also called "First Class Objects."
Android uses URI to request data and/or actions.
 */
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main extends AppCompatActivity
{
    //The following lines are initializing the textviews programmatically on the main activity so that they can be updated to different text programmatically
    TextView itemTitleBox;
    TextView itemAuthorBox;
    TextView itemDateBox;
    TextView itemContentBox;

    Spinner activitySpinner;
    int currentActivity = 0;

    /**
     * @param savedInstanceState
     *
     * The "onCreate" method is called to initially create the activity upon app startup.
     * It is called only once during the activity's life cycle. 
     * The parameter "savedInstanceState" is the main build of our app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activitySpinner = findViewById(R.id.activitySelector);
        activitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (currentActivity == position)
                {
                    return;
                }
                else if (currentActivity - position == -1)
                {
                    Intent changeToAboutUs = new Intent(Main.this, About_Us.class);
                    startActivity(changeToAboutUs);
                }
                else if (currentActivity - position == -2)
                {
                    Intent changeToContactUs = new Intent(Main.this, Contact_Us.class);
                    startActivity(changeToContactUs);
                }
                else if (currentActivity - position == -3)
                {
                    Intent followArchivesURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cornellcollege.advantage-preservation.com/"));
                    startActivity(followArchivesURL);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                return;
            }
        });

        ImageButton feedRefreshButton = findViewById(R.id.feedRefresh);
        feedRefreshButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new getNews().execute();
            }
        });

        itemTitleBox = findViewById(R.id.itemTitle);
        itemAuthorBox = findViewById(R.id.itemCreator);
        itemDateBox = findViewById(R.id.itemPubDate);
        itemContentBox = findViewById(R.id.itemContent);

          /*configureMainButton();
          configureAboutUsButton();
          configureContactUsButton();
          configureArchiveButton();*/
    }

    /*//Function to configure the Home page button.
    private void configureMainButton()
    {
        //Button mainButton = findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Main.class));
            }
        });
    }

    //Function to configure the About Us button.
    private void configureAboutUsButton()
    {
        Button aboutUsButton = findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, About_Us.class));
            }
        });
    }

    //Function to configure the Contact Us button.
    private void configureContactUsButton()
    {
        Button contactUsButton = findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Contact_Us.class));
            }
        });
    }

    //Function to configure the archive button.
    private void configureArchiveButton()
    {
        Button archiveButton = findViewById(R.id.ArchiveButton);
        archiveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://cornellcollege.advantage-preservation.com/")));
            }
        });
    }*/

    /**
     * AsyncTask allows for easy use of the UI thread, without having to manipulate the strings
     * themselves. It allows for easy use of operations that only take a few seconds.
     */
    public class getNews extends AsyncTask<Void, Void, Void>
    {
        String title;
        String author;
        String date;
        String content;

        //This method uses jsoup to connect to the Cornellian and retrieve the desired text values
        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                //This line uses jsoup to connect to the Cornellian website
                Document url = Jsoup.connect("https://blogs.cornellcollege.edu/cornellian/").get();

                //Views the HTML document at the above URL, looks for the first h2 tag that has ".entry-title" in the class name
                Element urlTitleText = url.select("h2.entry-title").first();
                //This line takes whatever is between the head and tail tag and sets it to the string
                title = urlTitleText.text();

                Element urlAuthorText = url.select("span").last();
                urlAuthorText.hasClass("author.vcard");
                author = urlAuthorText.text();

                Element urlDateText = url.select("span.posted-on").first();
                date = urlDateText.text();

                Element urlContentText = url.select("div.entry-content").first();
                content = urlContentText.text();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        //This method executes after jsoup connects to the website and gets the text values
        @Override
        protected void onPostExecute(Void aVoid)
        {
            //These lines set the text views that were initialized at the start of the class to whatever the string was set to in the previous method
            super.onPostExecute(aVoid);
            itemTitleBox.setText(title);
            itemAuthorBox.setText(author);
            itemDateBox.setText(date);
            itemContentBox.setText(content);
        }
    }
}