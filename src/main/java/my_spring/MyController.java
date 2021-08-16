package my_spring;

import lombok.Data;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Data
class Record {
    private int id;
    private String name;
    private String data;
}

@RestController
public class MyController {
    private Map<Integer, Record> storage = new HashMap<>();

    @GetMapping("/record")
    @Cacheable(value = "records", key = "id")
    public Record get(@RequestParam int id) {
        System.out.println("getting");
        return storage.get(id);
    }

    @PostMapping("/record")
    @CachePut(value = "records", key="#record.id")
    public void post(@RequestBody Record record) {
        System.out.println("posting");
        storage.put(record.getId(), record);
    }

}
