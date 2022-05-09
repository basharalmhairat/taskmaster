package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import model.Task;
import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM Task")
    List<Task> findAll();

    @Query("SELECT * FROM Task ORDER BY title ASC")
    List<Task> findAllSortedByName();

    @Query("SELECT * FROM Task WHERE id = :id")
    Task findById(long id);

}