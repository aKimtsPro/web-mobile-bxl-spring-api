package be.bxlforma.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final StringService service;

    public HelloController(StringService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/hello
    @GetMapping("/hello")
    public String getHello(){
        return "Hello World!";
    }

    // GET - http://localhost:8080/uppercase
    @GetMapping("/uppercase")
    public String toUppercase(@RequestParam("msg") String message){
        return service.toUppercase(message);
    }

    // GET - http://localhost:8080/strings/{index}
    @GetMapping("/strings/{i}")
    public String getString( @PathVariable("i") int index ){
        return service.get(index);
    }

    @PostMapping("/strings/add")
    public void add( @RequestBody AddInfoDTO dto){
        service.add(dto.getIndex(), dto.getMessage());
    }
}
