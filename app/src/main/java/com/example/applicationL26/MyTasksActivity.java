package com.example.applicationL26;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.PatternSyntaxException;

public class MyTasksActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";
    public static String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";
    SharedPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);
        userPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        addTaskButtonSetUp();
        allTasksButtonSetUp();
        settingsImageButtonSetUp();
        doTaxesButtonSetUp();
        groceriesButtonSetUp();
        dogFoodButtonSetUp();


    }


    // onResume needs to be outside of on Create all methods taken out of onCreate
    @Override
    public void onResume(){
        super.onResume();

        String username = userPreferences.getString(SettingsActivity.USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.usernameTextView)).setText(getString(R.string.username_username, username));
    }

    public void addTaskButtonSetUp(){
        Button addTaskButton = findViewById(R.id.goToAddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Add Task Button!");
                Log.e(TAG, "onClick: Add Task Button!");
                Intent goToAddTaskIntent = new Intent(MyTasksActivity.this, AddTaskActivity.class);
                MyTasksActivity.this.startActivity(goToAddTaskIntent);
            }
        });
    }

    public void allTasksButtonSetUp() {

        Button allTasksButton = findViewById(R.id.allTasksButton);
        allTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("All Tasks Button!");
                Log.e(TAG, "onClick: All Tasks Button!");
                Intent goToAllTasksIntent = new Intent(MyTasksActivity.this, AllTasksActivity.class);
                startActivity(goToAllTasksIntent);
            }
        });
    }

    public void settingsImageButtonSetUp() {
        ImageButton settingsImageButton = findViewById(R.id.settingsImageButton);
        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Settings Image Button!");
                Log.e(TAG, "onClick: Settings Image Button!");
                Intent goToSettingsIntent = new Intent(MyTasksActivity.this, SettingsActivity.class);
                startActivity(goToSettingsIntent);
            }
        });
    }

    public void doTaxesButtonSetUp(){
        Button doTaxesButton = findViewById(R.id.doTaxesButton);
        doTaxesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Do Taxes Button!");
                Log.e(TAG, "onClick: Do Taxes Button!");
                Intent goToTaskDetails = new Intent(MyTasksActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskDetails);
                String taskTitle = "Do Taxes";
                SharedPreferences.Editor userPreferencesEditor = userPreferences.edit();
                userPreferencesEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                userPreferencesEditor.apply();
            }
        });
    }

    public void groceriesButtonSetUp(){
        Button groceriesButton = findViewById(R.id.groceriesButton);
        groceriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Groceries Button!");
                Log.e(TAG, "onClick: Groceries Button!");
                Intent goToTaskDetails = new Intent(MyTasksActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskDetails);
                String taskTitle = "Groceries";
                SharedPreferences.Editor userPreferencesEditor = userPreferences.edit();
                userPreferencesEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                userPreferencesEditor.apply();
            }
        });
    }
    public void dogFoodButtonSetUp(){
        Button dogFoodButton = findViewById(R.id.dogFoodButton);
        dogFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Dog Food Button!");
                Log.e(TAG, "onClick: Dog Food Button!");
                Intent goToTaskDetails = new Intent(MyTasksActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskDetails);
                String taskTitle = "Dog Food";
                SharedPreferences.Editor userPreferencesEditor = userPreferences.edit();
                userPreferencesEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                userPreferencesEditor.apply();
            }
        });
    }
}
