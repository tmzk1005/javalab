package zk.javalab.crud;

public class PersonVo implements Vo<PersonPo> {

    public String id;

    public String firstName;

    public String lastName;

    public int age;

    public String getFirstName() {
        return firstName + lastName;
    }

    @Override
    public PersonVo fromPo(PersonPo personPo) {
        this.id = personPo.id;
        this.firstName = personPo.firstName;
        this.lastName = personPo.lastName;
        this.age = personPo.age;
        return this;
    }

}
