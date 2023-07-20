package be.bxlforma.api.controller;

import be.bxlforma.api.models.dto.AddTaskDTO;
import be.bxlforma.api.models.entity.Task;
import be.bxlforma.api.service.StringService;
import be.bxlforma.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/all")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/task/{id}")
    public Task getOne(@PathVariable/*("id")*/ long id){
        return taskService.getOne(id);
    }

    @PostMapping("/task")
    public void create(@RequestBody AddTaskDTO dto){
        taskService.add( dto.toEntity() );
    }

    @GetMapping("/task")
    public List<Task> getBefore(@RequestParam LocalDate maxDeadline){
        return taskService.getBefore(maxDeadline);
    }

}
