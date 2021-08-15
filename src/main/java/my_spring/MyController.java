package my_spring;

import lombok.Data;
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
    public Record get(@RequestParam int id) {
        return storage.get(id);
    }

    @PostMapping("/record")
    public void post(@RequestBody Record record) {
        storage.put(record.getId(), record);
    }

}
