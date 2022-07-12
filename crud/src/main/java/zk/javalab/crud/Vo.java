package zk.javalab.crud;

public interface Vo<P extends Po<? extends Dto>> {

    Vo<P> fromPo(P poInstance);

}
