package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.applicationL26.R;
import activity.MyTasksActivity;
import activity.TaskDetailActivity;
import model.Task;


import java.util.List;

public class MyTasksListRecyclerViewAdapter extends RecyclerView.Adapter<MyTasksListRecyclerViewAdapter.MyTasksListViewHolder> {
    List<Task> tasksList;
    Context gettingActivity;


    public MyTasksListRecyclerViewAdapter(List<Task> tasksList, Context gettingActivity) {
        this.tasksList = tasksList;
        this.gettingActivity = gettingActivity;
    }

    @NonNull
    @Override
    public MyTasksListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskListFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_tasks_list, parent, false);

        return new MyTasksListViewHolder(taskListFragment);
    }


    @Override
    public void onBindViewHolder(@NonNull MyTasksListViewHolder holder, int position) {
        TextView taskFragmentTextView = holder.itemView.findViewById(R.id.taskFragmentTextView);
        String taskTitle = tasksList.get(position).getTitle();
        taskFragmentTextView.setText(taskTitle);

        View myTaskViewHolder = holder.itemView;
        myTaskViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTasksDetailsIntent = new Intent(gettingActivity, TaskDetailActivity.class);
                goTasksDetailsIntent.putExtra(MyTasksActivity.TASK_DETAIL_TITLE_TAG, taskTitle);
                gettingActivity.startActivity(goTasksDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public static class MyTasksListViewHolder extends RecyclerView.ViewHolder{

        public MyTasksListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}