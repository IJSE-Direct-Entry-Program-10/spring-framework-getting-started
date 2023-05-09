package lk.ijse.dep10.spring.web.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloSpringWeb {

    @GetMapping
    public String handleGetRequest(){
        System.out.println("Get Request");
        return "Get Request";
    }

    @PostMapping
    public String handlePostRequest(){
        System.out.println("Post Request");
        return "Post Request";
    }

    @PutMapping
    public String handlePutRequest(){
        System.out.println("Put Request");
        return "Put Request";
    }

    @PatchMapping
    public String handlePatchRequest(){
        System.out.println("Patch Request");
        return "Patch Request";
    }

    @DeleteMapping
    public String handleDeleteRequest(){
        System.out.println("Delete Request");
        return "Delete Request";
    }
}
