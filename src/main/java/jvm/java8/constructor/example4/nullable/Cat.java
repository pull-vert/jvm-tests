/*
class Cat(var size: nullable Int = 26, var name: nullable String = null)
*/

package jvm.java8.constructor.example4.nullable;

import internal.annotations.NotNull;

import java.util.Optional;
import java.util.OptionalInt;

public final class Cat implements CatSj.Api {
    private CatSj.Implementation delegate;

    public Cat(@NotNull final OptionalInt size, @NotNull final Optional<String> name) {
        this.delegate = new CatSj.Implementation(size, name);
    }

    @Override
    public OptionalInt getSize() {
        return this.delegate.getSize();
    }

    @Override
    public void setSize(@NotNull OptionalInt size) {
        this.delegate.setSize(size);
    }

    @Override
    public Optional<String> getName() {
        return  this.delegate.getName();
    }

    @Override
    public void setName(@NotNull Optional<String> name) {
        this.delegate.setName(name);
    }
}
