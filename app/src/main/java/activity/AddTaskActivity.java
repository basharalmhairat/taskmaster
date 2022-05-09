package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.applicationL26.R;
import database.TaskMasterDatabase;
import model.StateEnum;
import model.Task;

import java.util.Date;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        TextView submittedText = findViewById(R.id.submittedText);
        List<Task> tasksList = null;
        TaskMasterDatabase taskMasterDatabase;

        taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        "task_master_base")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Spinner statusSpinner =  findViewById(R.id.statusSpinner);
        statusSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                StateEnum.values()));

        Button submitTaskButton = findViewById (R.id.submitTaskButton);
        submitTaskButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Task newTask  =  new Task(
                        ((EditText)findViewById(R.id.taskTitleEditText)).getText().toString(),
                        ((EditText)findViewById(R.id.doSomethingEditText)).getText().toString(),
                        StateEnum.fromString(statusSpinner.getSelectedItem().toString()),
                        new Date()
                );

                taskMasterDatabase.taskDao().insertTask(newTask);
                submittedText.setVisibility(View.VISIBLE);


            }
        });


    }

}