package com.example.lab2d19it014;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.DialogInterface;

import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button butt;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("🏃🏻‍♂ 🏃🏻 ️"); // Setting Message
        progressDialog.setTitle("Loading...."); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();


        EditText editText;
        button = findViewById(R.id.button);
        butt=findViewById(R.id.button2);
        editText =  findViewById(R.id.editText);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"My notification");
                builder.setContentTitle("ALERT");
                builder.setContentText("Some Motions detected!! Avii");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.au:
                Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Aboutus.class);
                startActivity(intent);
                return true;
            case R.id.tm:
                Toast.makeText(this,"Team members",Toast.LENGTH_SHORT).show();
                Intent intenttm = new Intent(MainActivity.this,Teammembers.class);
                startActivity(intenttm);
                return true;
            case R.id.td:
                Toast.makeText(this,"Team details",Toast.LENGTH_SHORT).show();
                Intent intenttd = new Intent(MainActivity.this,Teamdetails.class);
                startActivity(intenttd);
                return true;
            case R.id.sa:
                Intent intentsa = new Intent(MainActivity.this,setAlarm.class);
                startActivity(intentsa);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public void onBackPressed()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ? 😕 ");

        // Set Alert Title
        builder.setTitle("CAUTION!");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                finish();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }
}