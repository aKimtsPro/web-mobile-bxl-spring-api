package be.bxlforma.api.controller;

import be.bxlforma.api.models.dto.AddTaskDTO;
import be.bxlforma.api.models.entity.Task;
import be.bxlforma.api.service.StringService;
import be.bxlforma.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task") // préfixe l'URI à utiliser pour les endpoints du controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    // GET - http://localhost:8080/task/all
//    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @GetMapping("/all")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    // GET - http://localhost:8080/task/{id}
    @GetMapping("/{id}")
    public Task getOne(@PathVariable/*("id")*/ long id){
        return taskService.getOne(id);
    }

    // POST - http://localhost:8080/task
    @PostMapping
    public void create(@RequestBody AddTaskDTO dto){
        taskService.add( dto.toEntity() );
    }

    // GET - http://localhost:8080/task
    @GetMapping
    public List<Task> getBefore(@RequestParam LocalDate maxDeadline){
        return taskService.getBefore(maxDeadline);
    }

}
