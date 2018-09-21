/*
class Cat(val size: Int, val name: String)
 */

package jvm.java10.test2;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class Cat {
    @NotNull
    private final int size;
    @NotNull
    private final String name;

    public Cat(@NotNull final int size, @NotNull final String name) {
        Validation.checkParameterIsNotNull(name, "name");
        this.size = size;
        this.name = name;
    }

    @NotNull
    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
