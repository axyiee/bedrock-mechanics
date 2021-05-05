package gq.nkkx.bedrockmechanics.client.gui.provider;

public interface IGuiProvider<T> {

    Iterable<T> index();

    T fromId(int id);

    String toString(T value);

}
