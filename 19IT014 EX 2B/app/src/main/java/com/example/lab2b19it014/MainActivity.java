package com.example.lab2b19it014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nameEditText = (EditText) findViewById(R.id.names);
        String fullName = nameEditText.getText().toString();

        EditText goalWeightEditText = (EditText) findViewById(R.id.goal_weight);
        String GoalWeight = goalWeightEditText.getText().toString();

        EditText ageEditText = (EditText) findViewById(R.id.age);
        String age = ageEditText.getText().toString();

        EditText phoneEditText = (EditText) findViewById(R.id.names);
        String phone = phoneEditText.getText().toString();

        EditText addressEditText = (EditText) findViewById(R.id.names);
        String address = addressEditText.getText().toString();
        //initiate a check box
        CheckBox conditionsCheckBox = (CheckBox) findViewById(R.id.conditions);

        //check current state of the check box
        Boolean checkBoxState = conditionsCheckBox.isChecked();


        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void radioButtonhandler(View view) {

        // Decide what happens when a user clicks on a button
    }


    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg(View v) {
        toastMsg("Registered successfully!");
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}