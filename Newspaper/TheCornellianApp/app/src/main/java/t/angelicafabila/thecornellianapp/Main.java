package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main extends AppCompatActivity
{
    TextView itemTitleBox;
    TextView itemAuthorBox;
    TextView itemDateBox;
    TextView itemContentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add Toolbar
        Toolbar toolbar = findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);

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

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();
    }

    private void configureMainButton()
    {
        Button mainButton = findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Main.class));
            }
        });
    }
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
    }

    public class getNews extends AsyncTask<Void, Void, Void>
    {
        String title;
        String author;
        String date;
        String content;

        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                Document url = Jsoup.connect("https://blogs.cornellcollege.edu/cornellian/").get();

                Element urlTitleText = url.select("h2.entry-title").first();
                //urlTitleText.hasClass("entry-title");
                title = urlTitleText.text();

                Element urlAuthorText = url.select("span").last();
                urlAuthorText.hasClass("author.vcard");
                author = urlAuthorText.text();

                Element urlDateText = url.select("span.posted-on").first();
                //urlDateText.hasClass("posted-on");
                date = urlDateText.text();

                Element urlContentText = url.select("div.entry-content").first();
                //urlContentText.hasClass("entry-content");
                content = urlContentText.text();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            itemTitleBox.setText(title);
            itemAuthorBox.setText(author);
            itemDateBox.setText(date);
            itemContentBox.setText(content);
        }
    }
}