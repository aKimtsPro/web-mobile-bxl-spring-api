package be.bxlforma.api.models.dto;

import be.bxlforma.api.models.entity.Task;
import be.bxlforma.api.models.entity.Urgency;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private String description;
    private Urgency urgency;
    private LocalDate deadline;

//    public static Task toEntity(AddTaskDTO dto){
//        Task task = new Task();
//        task.setDescription( dto.getDescription() );
//        task.setUrgency( dto.getUrgency() );
//        task.setDeadline( dto.getDeadline() );
//        return task;
//    }

    public Task toEntity(){
        Task task = new Task();
        task.setDescription( this.getDescription() );
        task.setUrgency( this.getUrgency() );
        task.setDeadline( this.getDeadline() );
        return task;
    }
}
