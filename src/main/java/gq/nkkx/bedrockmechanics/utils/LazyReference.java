package gq.nkkx.bedrockmechanics.utils;

import java.util.function.Supplier;

public class LazyReference<T> implements Supplier<T> {

    private Supplier<T> delegate;
    private T value;

    private LazyReference(Supplier<T> delegate) {
        this.delegate = delegate;
    }

    public static <T> LazyReference<T> of(Supplier<T> delegate) {
        return new LazyReference<>(delegate);
    }

    @Override
    public T get() {
        if (delegate != null) {
            value = delegate.get();
            delegate = null;
        }
        return value;
    }

}
