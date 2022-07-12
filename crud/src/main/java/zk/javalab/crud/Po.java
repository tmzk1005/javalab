package zk.javalab.crud;

public interface Po<D extends Dto> {

    Po<D> fromDto(D dtoInstance);

}
