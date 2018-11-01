/*
class Cat(api val size: Int, api val name: String)
 */

package jvm.java8.constructor.example2.simpleClass;

import internal.annotations.NotNull;

public final class Cat implements CatSj.Api {
    private CatSj.Implementation delegate;

    public Cat(@NotNull final int size, @NotNull final String name) {
        delegate = new CatSj.Implementation(size, name);
    }

    @Override
    public int getSize() {
        return delegate.getSize();
    }

    @Override
    public String getName() {
        return  delegate.getName();
    }
}
