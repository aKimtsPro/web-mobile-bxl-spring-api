package be.bxlforma.api.service;

import be.bxlforma.api.models.entity.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private long nextId = 1;
    private final List<Task> tasks = new ArrayList<>();


    @Override
    public List<Task> getAll() {
        return List.copyOf(tasks);
    }

    @Override
    public Task getOne(long id) {
        return tasks.stream()
                .filter( task -> task.getId() == id )
                .findAny()
//                .get()        // lance une exception si vide
//                .orElseThrow()// pareil
//                .orElse(null) // renvoi le rslt ou null si pas de résultat
                .orElseThrow( () -> new RuntimeException("Task doesn't exist") );
    }

    @Override
    public List<Task> getBefore(LocalDate maxDeadline) {
        return tasks.stream()
                .filter( task -> task.getDeadline().isBefore(maxDeadline) )
                .toList();
//                .collect(Collectors.toCollection(ArrayList::new)); // permet de choisir l'implementation de la collection
    }

    @Override
    public void add(Task toAdd) {
        toAdd.setId( nextId++ );
        tasks.add(toAdd);
    }
}
