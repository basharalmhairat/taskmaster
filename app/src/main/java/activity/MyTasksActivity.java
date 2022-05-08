package activity;

import adapter.MyTasksListRecyclerViewAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.applicationL26.R;
import model.State;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class MyTasksActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";
    public static String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";
    SharedPreferences userPreferences;
    MyTasksListRecyclerViewAdapter myTasksListRecyclerViewAdapter;
    List<Task> tasksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);
        userPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        addTaskButtonSetUp();
        allTasksButtonSetUp();
        settingsImageButtonSetUp();
        myTasksListRecycleViewSetUp();
    }
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
    public void myTasksListRecycleViewSetUp(){
        RecyclerView myTasksListRecycleView = findViewById(R.id.tasksListRecycleView);
        RecyclerView.LayoutManager taskLayoutManager =  new LinearLayoutManager(this);
        myTasksListRecycleView.setLayoutManager(taskLayoutManager);

        tasksList.add(new Task("watch my class", "it,s daily task", State.NEW));
        tasksList.add(new Task("write some code", "it,s daily task", State.NEW));
        tasksList.add(new Task("clean the back yard", "ASAP it will rain ", State.NEW));
        tasksList.add(new Task("feed the cat", "also she might need water", State.NEW));
        tasksList.add(new Task("finch home work", "try to read some books", State.NEW));
        myTasksListRecyclerViewAdapter = new MyTasksListRecyclerViewAdapter(tasksList, this);

        myTasksListRecycleView.setAdapter(myTasksListRecyclerViewAdapter);
    }
}