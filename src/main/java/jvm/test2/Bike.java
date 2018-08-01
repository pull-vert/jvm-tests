package jvm.test2;

import internal.annotations.NotNull;
import internal.validation.Validation;

// class Bike(val wheelSize: Int)
public final class Bike {
    @NotNull
    private final Integer wheelSize;

    public Bike(@NotNull final Integer wheelSize) {
        Validation.checkParameterIsNotNull(wheelSize, "wheelSize");
        this.wheelSize = wheelSize;
    }

    @NotNull
    public final Integer getWheelSize() {
        return this.wheelSize;
    }
}
