package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();
    }

    private void configureMainButton()
    {
        Button mainButton = (Button) findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(About_Us.this, Main.class));
            }
        });
    }

    private void configureAboutUsButton()
    {
        Button aboutUsButton = (Button) findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(About_Us.this, About_Us.class));
            }
        });
    }

    private void configureContactUsButton() {
        Button contactUsButton = (Button) findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(About_Us.this, Contact_Us.class));
            }
        });
    }
    private void configureArchiveButton()
    {
        Button archiveButton = (Button) findViewById(R.id.ArchiveButton);
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
}
