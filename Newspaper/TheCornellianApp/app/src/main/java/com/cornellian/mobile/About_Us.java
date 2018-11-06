package com.cornellian.mobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class About_Us extends AppCompatActivity {

    Spinner activitySpinner;
    int currentActivity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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
                        intent = new Intent(About_Us.this, Main.class);
                        break;
                    case 2:
                        intent = new Intent(About_Us.this, Contact_Us.class);
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cornellcollege.advantage-preservation.com/"));
                        break;
                    case 1:
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

        //The following block of lines are the in-text hyperlink to the editors bio.
        TextView editorChiefHyperlink = findViewById(R.id.EditorChief);
        editorChiefHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView assistantEditorChiefHyperlink = findViewById(R.id.AssistantEditorChief);
        assistantEditorChiefHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView newsEditorHyperlink = findViewById(R.id.NewsEditor);
        newsEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView featuresEditorHyperlink = findViewById(R.id.FeaturesEditor);
        featuresEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView artEntertainmentEditorHyperlink = findViewById(R.id.ArtEntertainmentEditor);
        artEntertainmentEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView opinionEditorHyperlink = findViewById(R.id.OpinionEditor);
        opinionEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView copyEditorHyperlink = findViewById(R.id.CopyEditor);
        copyEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView layoutEditorHyperlink = findViewById(R.id.LayoutEditor);
        layoutEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}