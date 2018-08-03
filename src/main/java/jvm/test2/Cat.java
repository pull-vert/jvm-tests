/*
class Cat(val size: Int)
 */

package jvm.test2;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class Cat {
    @NotNull
    private final int size;

    public Cat(@NotNull final Integer size) {
        Validation.checkParameterIsNotNull(size, "size");
        this.size = size;
    }

    @NotNull
    public final int getWheelSize() {
        return this.size;
    }
}
