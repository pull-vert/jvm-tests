/*
 class Cat(var size: Int = 26, var name: String = 'Grumpy')
 */

package jvm.java8.constructor.example3.dependency;

import internal.annotations.NotNull;

public final class Cat implements CatSj.Api {
    private CatSj.Implementation delegate;

    public Cat(@NotNull final int size, @NotNull final String name) {
        this.delegate = new CatSj.Implementation(size, name);
    }

    @Override
    public int getSize() {
        return this.delegate.getSize();
    }

    @Override
    public void setSize(@NotNull int size) {
        this.delegate.setSize(size);
    }

    @Override
    public String getName() {
        return  this.delegate.getName();
    }

    @Override
    public void setName(@NotNull String name) {
        this.delegate.setName(name);
    }
}
