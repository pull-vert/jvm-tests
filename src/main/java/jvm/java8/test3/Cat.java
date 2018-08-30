/*
 class Cat(var size: Int = 26, var name: String = 'grumpy')
 */

package jvm.java8.test3;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

public final class Cat {
    @NotNull
    private int size;
    @NotNull
    private String name;

    public Cat(@Nullable final Integer size, int mask1, @Nullable final String name, int mask2) {
        this(((mask1 & 1) != 0) ? 26 : size,
                ((mask2 & 1) != 0) ? "grumpy" : name);
    }

    public Cat(@NotNull final Integer size, @NotNull final String name) {
        Validation.checkParameterIsNotNull(size, "size");
        Validation.checkParameterIsNotNull(name, "name");
        this.size = size;
        this.name = name;
    }

    @NotNull
    public final int getWheelSize() {
        return this.size;
    }

    public final void setWheelSize(@NotNull final Integer size) {
        Validation.checkParameterIsNotNull(size, "size");
        this.size = size;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull final String name) {
        Validation.checkParameterIsNotNull(name, "name");
        this.name = name;
    }
}
