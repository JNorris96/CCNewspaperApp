package t.angelicafabila.thecornellianapp;

//import android.content.Context;
//import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
//import android.app.AlertDialog;


public class Contact_Us extends AppCompatActivity {

    Intent intent = new Intent();

//    private EditText editText2;
//    private EditText editText;
//    public String Name;
//    public String Message;
//    String storedMessage;
//    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //      Submit =new Submit(getApplicationContext());
        //     editText2 = (EditText) findViewById(R.id.editText2);
        //     editText = (EditText) findViewById(R.id.editText);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();
        configureEmailButton();
    }

//      public void SubmitMessage(View view) {
//       try {
//           Name = editText2.getText().toString();
//           Message = editText.getText().toString();
//           if (Name.equals("") || Message.equals("")) {
//              AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//              alertDialog.setTitle("ALERT!");
//              alertDialog.setMessage("Fill All Fields");
//              alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//              public void onClick(DialogInterface dialog, int which) {
//              }
//              });
//              alertDialog.show();
//           }
//          // fetch the Message form database for respective user name
//          if (Name.equals("")) {
//              storedMessage = Submit;
//             // check if the Stored Message matches with Message entered by user
//          if (Message.equals("")) {
//             storedMessage = Submit;
//
//     protected void onDestroy()
//    {
//         // TODO Auto-generated method stub
//         super.onDestroy();
//         // Close The Database
//          Submit.close();
//     }
//    }

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
                    intent.setType("message");
                    String [] recipient = {"thecornellian@cornellcollege.edu"};
                    intent.putExtra(Intent.EXTRA_EMAIL, recipient);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Letter to the Editor");
                    //String[] to = {"thecornellian@cornellcollege.edu"};
                    // intent.putExtra(Intent.EXTRA_EMAIL, to);
                    //intent.putExtra(Intent.EXTRA_SUBJECT, "Letter to the Editor");
                    //intent.setType("message");
                    // Intent.createChooser(intent, "Send Email");
                }
        });
    }


    /* Activity to send user to the Cornellian website. */
    public void website(View view){
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://blogs.cornellcollege.edu/cornellian/"));
        startActivity(websiteIntent);
    }
    /* Activity to send user to the Cornellian Facebook page. */
    public void facebook(View view){
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/TheCornellian/"));
        startActivity(facebookIntent);
    }
    /* Activity to send user to the Cornellian Twitter page. */
    public void twitter(View view){
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/")); //TODO
        startActivity(twitterIntent);
    }
}
