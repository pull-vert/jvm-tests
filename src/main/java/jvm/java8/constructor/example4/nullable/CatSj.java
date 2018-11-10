package jvm.java8.constructor.example4.nullable;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

public final class CatSj {
    // uninstanciable
    private CatSj() {
    }

    public static interface Api {
        @NotNull
        public OptionalInt getSize();

        public void setSize(@NotNull OptionalInt size);

        @NotNull
        public Optional<String> getName();

        public void setName(@NotNull Optional<String> name);
    }

    public static final class FuncWithDefaultValue {
        // uninstanciable
        private FuncWithDefaultValue() {
        }

        public static Cat constructor(@Nullable final OptionalInt size, int mask1, @Nullable final Optional<String> name, int mask2) {
            return new Cat(((mask1 & 1) != 0) ? OptionalInt.of(26) : size,
                    ((mask2 & 1) != 0) ? Optional.empty() : name);
        }
    }

    static final class Implementation implements Api {
        @NotNull
        private OptionalInt size;
        @NotNull
        private Optional<String> name;

        /**
         * called by Cat class
         */
        Implementation(@NotNull final OptionalInt size, @NotNull final Optional<String> name) {
            Validation.checkParameterIsNotNull(size, "size");
            Validation.checkParameterIsNotNull(name, "name");
            this.size = size;
            this.name = name;
        }

        @Override
        @NotNull
        public final OptionalInt getSize() {
            return this.size;
        }

        @Override
        public void setSize(@NotNull OptionalInt size) {
            Validation.checkParameterIsNotNull(size, "size");
            this.size = size;
        }

        @Override
        @NotNull
        public final Optional<String> getName() {
            return this.name;
        }

        @Override
        public void setName(@NotNull Optional<String> name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
        }
    }
}
