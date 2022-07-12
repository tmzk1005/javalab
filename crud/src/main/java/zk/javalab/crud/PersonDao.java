package zk.javalab.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonDao {

    Map<String, PersonPo> database = new ConcurrentHashMap<>();

    public void create(PersonPo personPo) {
        database.put(personPo.id, personPo);
    }

    public List<PersonPo> list() {
        return new ArrayList<>(database.values());
    }

}
