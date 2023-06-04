package lk.ijse.dep10.mapping.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public String getAllCustomers() {
        return "<h1>I am from CustomerController::getAllCustomer</h1>";
    }

    @GetMapping("/{id:C\\d{3}}")
    public String getCustomer(@PathVariable String id){
        return String.format("<h1>I am from CustomerController::getCustomer(%s)</h1>", id);
    }

    @PostMapping(consumes = "application/json")
    public String saveCustomerJSON(){
        return "<h1>I am from CustomerController::saveCustomer and I accept only JSON</h1>";
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public String saveCustomerXML(){
        return "<h1>I am from CustomerController::saveCustomer and I accept only XML</h1>";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveCustomerMultipartFormData(){
        return "<h1>I am from CustomerController::saveCustomer and I accept only Multipart Form Data</h1>";
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveCustomerURLEncoded(){
        return "<h1>I am from CustomerController::saveCustomer and I accept only saveCustomerURLEncoded</h1>";
    }
}

