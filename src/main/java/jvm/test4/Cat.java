package jvm.test4;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

// class Cat(var size: nullable Int = 26, val name: nullable String = null)
public final class Cat {
    @NotNull
    private OptionalInt size;
    @NotNull
    private final Optional<String> name;

    // ACCESSIBLE from Java ???
    // One Constructor for default values
    public Cat(@Nullable final OptionalInt size, int mask1, @Nullable final Optional<String> name, int mask2) {
        // Call full parameters Constructor
        this(((mask1 & 1) != 0) ? OptionalInt.of(26) : size,
                ((mask2 & 1) != 0) ? Optional.empty() : name);
    }

    // full parameters Constructor
    public Cat(@NotNull final OptionalInt size, @NotNull final Optional<String> name) {
        Validation.checkParameterIsNotNull(size, "size");
        Validation.checkParameterIsNotNull(name, "name");
        this.size = size;
        this.name = name;
    }

    @NotNull
    public final OptionalInt getSize() {
        return this.size;
    }

    public final void setSize(@NotNull final OptionalInt size) {
        Validation.checkParameterIsNotNull(size, "size");
        this.size = size;
    }

    @NotNull
    public final Optional<String> getName() {
        return this.name;
    }
}
