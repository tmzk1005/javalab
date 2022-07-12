package zk.javalab.crud;

import java.util.UUID;

public class PersonPo implements Po<PersonDto> {

    public String id;

    public String firstName;

    public String lastName;

    public int age;

    @Override
    public PersonPo fromDto(PersonDto dtoInstance) {
        this.id = UUID.randomUUID().toString();
        this.firstName = dtoInstance.firstName;
        this.lastName = dtoInstance.lastName;
        this.age = dtoInstance.age;
        return this;
    }

}
