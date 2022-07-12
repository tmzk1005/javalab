package zk.javalab.crud;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class PersonController {

    private final PersonService personService = new PersonService();

    public void create(@ResponseBody PersonDto personDto) {
        // 自己校验，或者用框架AOP实现对Dto的合法性的校验
        personService.create(personDto);
    }

    public List<PersonVo> list() {
        final List<PersonPo> poList = personService.list();
        return poList.stream().map(personPo -> new PersonVo().fromPo(personPo)).toList();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface ResponseBody {
    }

}
