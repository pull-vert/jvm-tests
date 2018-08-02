package jvm.test5;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.io.Serializable;
import java.util.Optional;
import java.util.OptionalInt;

// class Cat(var size: nullable Int = 26, val name: nullable String = null) is Serializable
public final class Cat implements Serializable {
    @Nullable
    private Integer size;
    @Nullable
    private final String name;

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
        this.size = size.isPresent() ? size.getAsInt() : 26;
        this.name = name.orElse(null);
    }

    @Nullable
    public final Integer getSize() {
        return this.size;
    }

    public final void setSize(@Nullable final Integer size) {
        this.size = size;
    }

    public final void setSize(@NotNull final OptionalInt size) {
        Validation.checkParameterIsNotNull(size, "size");
        this.size = size.isPresent() ? size.getAsInt() : null;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }
}
