package be.bxlforma.api.service;

import be.bxlforma.api.models.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    List<Task> getAll();
    Task getOne(long id);
    List<Task> getBefore(LocalDate maxDeadline);
    void add(Task toAdd);
    void update(long id, Task task);
    void upUrgency(long id);
    void downUrgency(long id);

}
