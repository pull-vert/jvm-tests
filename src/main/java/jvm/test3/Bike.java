package jvm.test3;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

// class Bike(var wheelSize: Int = 26, val height: Int = 30)
public final class Bike {
    @NotNull
    private Integer wheelSize;
    @NotNull
    private final Integer height;

    // NOT ACCESSIBLE from Java !!!
    // One Constructor for default values
    public Bike(@Nullable final Integer wheelSize, int mask1, @Nullable final Integer height, int mask2) {
        // Call full parameters Constructor
        this(((mask1 & 1) != 0) ? Integer.valueOf(26) : wheelSize,
                ((mask2 & 1) != 0) ? Integer.valueOf(30) : height);
    }

    // full parameters Constructor
    public Bike(@NotNull final Integer wheelSize, @NotNull final Integer height) {
        Validation.checkParameterIsNotNull(wheelSize, "wheelSize");
        Validation.checkParameterIsNotNull(height, "height");
        this.wheelSize = wheelSize;
        this.height = height;
    }

    @NotNull
    public final Integer getWheelSize() {
        return this.wheelSize;
    }

    public final void setWheelSize(@NotNull final Integer wheelSize) {
        Validation.checkParameterIsNotNull(wheelSize, "wheelSize");
        this.wheelSize = wheelSize;
    }

    @NotNull
    public final Integer getHeight() {
        return this.height;
    }
}
