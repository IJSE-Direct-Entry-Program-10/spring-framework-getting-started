package lk.ijse.dep10.mapping.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping
    public String getAllItemsAsJSON(){
        return "<h1>getAllItemsAsJSON()</h1>";
    }

    @GetMapping(produces = "application/xml", consumes = "application/json")
    public String getAllItemsAsXML(){
        return "<h1>getAllItemsAsXML()</h1>";
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAllItemsAsText(){
        return "<h1>getAllItemsAsText()</h1>";
    }
}
