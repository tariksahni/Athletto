package com.example.tarik.athletto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Registration_form extends AppCompatActivity implements View.OnClickListener {

    protected Button selectPrefrencesButton;
    Button register;

    EditText name;
    EditText age ;
    EditText contact;
    protected CharSequence[] prefrences = { "Badminton", "Cricket", "Football", "Tennis", "Table Tennis", "Basketball" };  //the differnt type of sports which a user will choose while registration
    protected ArrayList<CharSequence> selectedPrefrences = new ArrayList<CharSequence>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        name= (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        contact= (EditText) findViewById(R.id.contact);
        selectPrefrencesButton= (Button) findViewById(R.id.buttonSelector);
        selectPrefrencesButton.setOnClickListener(this);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if someone fill an invalid entry it will operate otherwise else statement will execute
                if(  name.getText().toString() =="" || age.getText().toString()=="" || contact.getText().toString()==""   ){
                    name.setError("Enter a valid value");
                    age.setError("Enter a valid value");
                    contact.setError("Enter a valid value");
                }
                // it will sshow a toast and then return to the main display
                else{
                    Toast.makeText(getApplicationContext(),"Successfull!!!",Toast.LENGTH_LONG).show();
                    Intent it = new Intent(Registration_form.this,MainActivity.class);
                    startActivity(it);
                }
            }
        });
    }

    @Override // on clicking to the add button in registration form a dialouge box will open showing various sports to select as a prefrence
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSelector:
                showSelectPrefrencesDialog();
                break;
            default:
                break;
        }
    }
    protected void  onChangeSelectedPrefrences() {  // on selectibg a prefrence it will add it to a string
        StringBuilder stringBuilder = new StringBuilder();
        for(CharSequence Prefrence : selectedPrefrences)
            stringBuilder.append(Prefrence + ",");
        if(selectedPrefrences.size()==0){
            selectPrefrencesButton.setText("None");
        }
        else
            selectPrefrencesButton.setText(stringBuilder.toString());
    }

    protected void  showSelectPrefrencesDialog() {
        boolean[] checkedPrefrences = new boolean[prefrences.length];
        int count = prefrences.length;
        for(int i = 0; i < count; i++)
            checkedPrefrences[i] = selectedPrefrences.contains(prefrences[i]);

        DialogInterface.OnMultiChoiceClickListener PrefrencesDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // if in diaouge box a box is checked it is selected and added to string otherwise it will remove the sports on deselecting the sport
                if(isChecked)
                    selectedPrefrences.add(prefrences[which]);
                else
                    selectedPrefrences.remove(prefrences[which]);

                onChangeSelectedPrefrences();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Prefrences");
        builder.setMultiChoiceItems(prefrences,  checkedPrefrences, PrefrencesDialogListener);
        // on clicking to "ok button " we are done with the prefrences to be selected
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }
}
