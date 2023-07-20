package be.bxlforma.api.service.impl;

import be.bxlforma.api.models.entity.Task;
import be.bxlforma.api.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//@Service
public class TaskServiceMock implements TaskService {
    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task getOne(long id) {
        return null;
    }

    @Override
    public List<Task> getBefore(LocalDate maxDeadline) {
        return null;
    }

    @Override
    public void add(Task toAdd) {

    }

    @Override
    public void update(long id, Task task) {

    }

    @Override
    public void upUrgency(long id) {

    }

    @Override
    public void downUrgency(long id) {

    }
}
