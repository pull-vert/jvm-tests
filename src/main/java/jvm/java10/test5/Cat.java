/*
class Cat(var size: nullable Int = 26, var name: nullable String = null) is Serializable
 */

package jvm.java10.test5;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.io.Serializable;
import java.util.Optional;
import java.util.OptionalInt;

public final class Cat implements Serializable {
    @NotNull
    private OptionalInt size;
    @NotNull
    private Optional<String> name;

    public Cat() {}

    public Cat(@Nullable final OptionalInt size, int mask1, @Nullable final Optional<String> name, int mask2) {
        this(((mask1 & 1) != 0) ? OptionalInt.of(26) : size,
                ((mask2 & 1) != 0) ? Optional.empty() : name);
    }

    public Cat(@NotNull final OptionalInt size, @NotNull final Optional<String> name) {
        Validation.checkParameterIsNotNull(size, "size");
        Validation.checkParameterIsNotNull(name, "name");
        this.size = size;
        this.name = name;
    }

    @Nullable
    public final Integer getSize() {
        return (this.size.isPresent()) ? this.size.getAsInt() : null ;
    }

    @NotNull
    public final OptionalInt optionalSize() {
        return this.size;
    }

    public final void setSize(@Nullable final Integer size) {
        this.size = (null != size) ? OptionalInt.of(size) : OptionalInt.empty();
    }

    public final void setOptionalSize(@NotNull final OptionalInt size) {
        Validation.checkParameterIsNotNull(size, "size");
        this.size = size;
    }

    @Nullable
    public final String getName() {
        return this.name.orElse(null);
    }

    @NotNull
    public final Optional<String> optionalName() {
        return this.name;
    }

    public final void setName(@Nullable final String name) {
        this.name = Optional.ofNullable(name);
    }

    public final void setOptionalName(@NotNull final Optional<String> name) {
        Validation.checkParameterIsNotNull(name, "name");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final var cat = (Cat) o;

        if (!size.equals(cat.size)) return false;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        var result = size.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
