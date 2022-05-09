package fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.applicationL26.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyTasksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyTasksListFragment extends Fragment {


    public MyTasksListFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyTasksListFragment.
     */
    public static MyTasksListFragment newInstance(String param1, String param2) {
        MyTasksListFragment fragment = new MyTasksListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_tasks_list, container, false);
    }
}
