package jvm.test4;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.Optional;

// class Bike(var wheelSize: nullable Int = null)
public final class Bike {
    @Nullable
    private Integer wheelSize;

    // NOT ACCESSIBLE from Java !!!
    // One Constructor for default values
    public Bike(@Nullable final Integer wheelSize, int mask1) {
        // Call full parameters Constructor
        this(((mask1 & 1) != 0) ? Integer.valueOf(26) : wheelSize);
    }

    public Bike(@Nullable final Integer wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Bike(@NotNull final Optional<Integer> wheelSize) {
        Validation.checkParameterIsNotNull(wheelSize, "wheelSize");
        this.wheelSize = wheelSize.orElse(null);
    }

    @NotNull
    public final Optional<Integer> getWheelSize() {
        return Optional.ofNullable(this.wheelSize);
    }

    public final void setWheelSize(@Nullable final Integer wheelSize) {
        this.wheelSize = wheelSize;
    }

    public final void setWheelSize(@NotNull final Optional<Integer> wheelSize) {
        Validation.checkParameterIsNotNull(wheelSize, "wheelSize");
        this.wheelSize = wheelSize.orElse(null);
    }
}
