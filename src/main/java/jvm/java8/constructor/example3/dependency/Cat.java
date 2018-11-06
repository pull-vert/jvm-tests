/*
 class Cat(var size: Int = 26, var name: String = 'Grumpy')
 */

package jvm.java8.constructor.example3.dependency;

import internal.annotations.NotNull;

public class Cat implements CatSj.Api {
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
