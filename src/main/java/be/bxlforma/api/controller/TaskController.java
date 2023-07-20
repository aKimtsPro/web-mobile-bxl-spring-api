package be.bxlforma.api.controller;

import be.bxlforma.api.models.dto.TaskDTO;
import be.bxlforma.api.models.entity.Task;
import be.bxlforma.api.service.TaskService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Task> getOne(@PathVariable/*("id")*/ long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("mon-header", "sa/ses valeur.s");
        return new ResponseEntity<>(taskService.getOne(id), headers, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK)
//                .header("mon-header", "sa/ses valeur.s")
//                .body(taskService.getOne(id));
    } // Les headers et le body sont optionels mais le status est requis

    // POST - http://localhost:8080/task
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // par defaut: 200 - OK
    public void create(@RequestBody TaskDTO dto){
        taskService.add( dto.toEntity() );
    }

    // GET - http://localhost:8080/task
    @GetMapping
    public List<Task> getBefore(@RequestParam LocalDate maxDeadline){
        return taskService.getBefore(maxDeadline);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody TaskDTO dto){
        taskService.update(id, dto.toEntity());
    }

    @PatchMapping("/{id}/urgency")
    public void changeUrgency(@PathVariable long id, @RequestParam String direction){
        switch (direction) {
            case "down" -> taskService.downUrgency(id);
            case "up" -> taskService.upUrgency(id);
            default -> throw new RuntimeException("Invalid param \"direction\"");
        }
    }
    @PatchMapping("/{id}/urgency/up")
    public void upUrgency(@PathVariable long id){
         taskService.upUrgency(id);
    }
    @PatchMapping("/{id}/urgency/down")
    public void downUrgency(@PathVariable long id){
        taskService.downUrgency(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("not good");
    }

}
