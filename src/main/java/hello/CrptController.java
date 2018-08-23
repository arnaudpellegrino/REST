package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrptController {

    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/postcrypt")
    public CryptedMessage crypt(@RequestParam(value="message", defaultValue="Hello World") String message, @RequestParam(value="key", defaultValue="12345") String key) {
        
    	message = message + key;
    	
    	return new CryptedMessage(message);
    }
    
    
    @GetMapping("/crypt")
    public CryptedMessage cryptGet(@RequestParam(value="message", defaultValue="Hello World") String message, @RequestParam(value="key", defaultValue="12345") String key) {
        
    	message = key + message;
    	
    	return new CryptedMessage(message);
    }
    
 
 //   @RequestMapping("/goodbye")
 //   public Message goodbye(@RequestParam(value="name", defaultValue="World") String name) {
  //      return new Greeting(counter.incrementAndGet(),
  //                          String.format(templateGoodbye, name));
  //  }
    
}
