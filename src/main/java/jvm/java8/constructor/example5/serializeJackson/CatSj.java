package jvm.java8.constructor.example5.serializeJackson;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.io.Serializable;
import java.util.Optional;
import java.util.OptionalInt;

public final class CatSj {
    // uninstanciable
    private CatSj() {
    }

    public static interface Api extends Serializable {
        @NotNull
        public OptionalInt getSize();

        public void setSize(@NotNull final OptionalInt size);

        @NotNull
        public Optional<String> getName();

        public void setName(@NotNull final Optional<String> name);

        @NotNull
        public String getColor();
    }

    public static final class FuncWithDefaultValue {
        // uninstanciable
        private FuncWithDefaultValue() {
        }

        public static Cat constructor(@Nullable final OptionalInt size, int mask1, @Nullable final Optional<String> name, int mask2, @NotNull final String color) {
            return new Cat(((mask1 & 1) != 0) ? OptionalInt.of(26) : size,
                    ((mask2 & 1) != 0) ? Optional.empty() : name,
                    color);
        }
    }

    static final class Implementation implements Api {
        @NotNull
        private OptionalInt size;
        @NotNull
        private Optional<String> name;
        @NotNull
        private String color;

        Implementation(@NotNull final OptionalInt size, @NotNull final Optional<String> name, @NotNull final String color) {
            Validation.checkParameterIsNotNull(size, "size");
            Validation.checkParameterIsNotNull(name, "name");
            Validation.checkParameterIsNotNull(color, "color");
            this.size = size;
            this.name = name;
            this.color = color;
        }

        @Override
        @NotNull
        public final OptionalInt getSize() {
            return this.size;
        }

        @Override
        public final void setSize(@NotNull final OptionalInt size) {
            Validation.checkParameterIsNotNull(size, "size");
            this.size = size;
        }

        @Override
        @NotNull
        public final Optional<String> getName() {
            return this.name;
        }

        @Override
        public final void setName(@NotNull final Optional<String> name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
        }

        @Override
        @NotNull
        public String getColor() {
            return this.color;
        }
    }
}
