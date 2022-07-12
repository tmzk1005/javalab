package zk.javalab.crud;

import java.util.List;

public class PersonService {

    private final PersonDao personDao = new PersonDao();

    public void create(PersonDto personDto) {
        personDao.create(new PersonPo().fromDto(personDto));
    }

    public List<PersonPo> list() {
        return personDao.list();
    }

}
