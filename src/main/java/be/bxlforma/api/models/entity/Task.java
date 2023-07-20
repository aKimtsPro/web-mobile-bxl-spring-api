package be.bxlforma.api.models.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Task {

    private Long id;
    private String description;
    private Urgency urgency;
    private LocalDate deadline;

}
