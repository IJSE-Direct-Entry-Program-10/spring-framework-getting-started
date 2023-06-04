package lk.ijse.dep10.mapping.api;

import lk.ijse.dep10.mapping.CustomerDTO;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController // RestController => Controller (=>Component) + Response Body
@RequestMapping("/orders")
public class OrderController {

//    @GetMapping
//    public String getAllOrders(@RequestHeader(value = "X-Token", required = false) String token,
//                               @RequestParam(value = "q", required = false) String query){
//        return String.format("<h1>getAllOrders(token=%s, query=%s)</h1>", token, query) ;
//    }

//    @GetMapping
//    public String getAllOrders(@RequestParam MultiValueMap<String, List<String>> paramsMultiValueMap, @RequestParam Map<String, String> paramsMap) {
//        System.out.println(paramsMap);
//        System.out.println(paramsMultiValueMap);
//        return "<h1>getAllOrders()</h1>";
//    }

    @GetMapping(headers = {"X-Token"})
    public String getAuthenticatedOrders(@RequestHeader("X-Token") String token) {
        return String.format("<h1>getAuthenticatedOrders(token=%s)</h1>", token);
    }

    @GetMapping(params = {"page", "size"})
    public String getPaginatedOrders(@RequestParam int page, @RequestParam int size) {
        return String.format("<h1>getPaginatedOrders(page=%s, size=%s)</h1>", page, size);
    }

    @GetMapping
    public String getOrder(@RequestParam String id,
                           @RequestParam String name,
                           @RequestParam String address,
                           @RequestParam String contact,
                           @RequestParam Map<String, String> params,
                           @RequestParam MultiValueMap<String, List<String>> params2,
                           @ModelAttribute CustomerDTO customer) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(address);
        System.out.println(contact);
        System.out.println(params);
        System.out.println(params2);
        System.out.println(customer);
        return "<h1>getOrder()</h1>";
    }

    @PostMapping
    public String saveOrder(@RequestBody Map<String, Object> jsonBody) {
        System.out.println(jsonBody);
        return "<h1>saveOrder()</h1>";
    }

    @PutMapping
    public String updateOrCreateOrder(@RequestBody Map<String, Object> jsonBody) {
        System.out.println(jsonBody);
        return "<h1>updateOrCreateOrder()</h1>";
    }

    @PatchMapping(consumes = "application/json")
    public String updateOrder(@RequestBody Map<String, Object> jsonBody) {
        System.out.println(jsonBody);
        return "<h1>updateOrder()</h1>";
    }

    @DeleteMapping
    public String deleteOrder(@RequestBody Map<String, Object> jsonBody){
        System.out.println(jsonBody);
        return "<h1>deleteOrder()</h1>";
    }
}
