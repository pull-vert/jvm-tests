/*
data class Cat(api var size: nullable Int = 26, api var name: nullable String = null, api val color: String) is Serializable
 */

package jvm.java8.constructor.example5.serializeJackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

public final class Cat implements CatSj.Api {
    private CatSj.Implementation delegate;

    @JsonCreator
    private Cat(@Nullable @JsonProperty("size") final Integer size, @Nullable @JsonProperty("name") final String name, @NotNull @JsonProperty("color") final String color) {
        this((null != size) ? OptionalInt.of(size) : OptionalInt.empty(), Optional.ofNullable(name), color);
    }

    public Cat(@NotNull final OptionalInt size, @NotNull final Optional<String> name, @NotNull final String color) {
        delegate = new CatSj.Implementation(size, name, color);
    }

    @Override
    public final OptionalInt getSize() {
        return delegate.getSize();
    }

    @JsonProperty("size")
    @Nullable
    private Integer getSerializableSize() {
        return (delegate.getSize().isPresent()) ? delegate.getSize().getAsInt() : null;
    }

    @Override
    public final void setSize(@NotNull OptionalInt size) {
        Validation.checkParameterIsNotNull(size, "size");
        delegate.setSize(size);
    }

    @Override
    @NotNull
    public final Optional<String> getName() {
        return delegate.getName();
    }

    @JsonProperty("name")
    @Nullable
    private String getSerializableName() {
        return this.getName().orElse(null);
    }

    @Override
    public final void setName(@NotNull Optional<String> name) {
        Validation.checkParameterIsNotNull(name, "name");
        delegate.setName(name);
    }

    @Override
    @NotNull
    public final String getColor() {
        return delegate.getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat aClass = (Cat) o;

        if (!getSize().equals(aClass.getSize())) return false;
        if (!getName().equals(aClass.getName())) return false;
        return getColor().equals(aClass.getColor());
    }

    @Override
    public int hashCode() {
        int result = getSize().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getColor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "size=" + getSize() +
                ", name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
