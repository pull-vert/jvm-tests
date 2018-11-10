package jvm.java8.constructor.example3.dependency;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

public final class CatSj {
    // uninstanciable
    private CatSj() {
    }

    public static interface Api {
        @NotNull
        public int getSize();

        public void setSize(@NotNull int size);

        @NotNull
        public String getName();

        public void setName(@NotNull String name);
    }

    public static final class FuncWithDefaultValue {
        // uninstanciable
        private FuncWithDefaultValue() {
        }

        public static Cat constructor(@Nullable final Integer size, int mask1, @Nullable final String name, int mask2) {
            return new Cat(((mask1 & 1) != 0) ? 26 : size,
                    ((mask2 & 1) != 0) ? "Grumpy" : name);
        }
    }

    static final class Implementation implements Api {
        @NotNull
        private int size;
        @NotNull
        private String name;

        /**
         * called by Cat class
         */
        Implementation(@NotNull final int size, @NotNull final String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.size = size;
            this.name = name;
        }

        @Override
        @NotNull
        public final int getSize() {
            return this.size;
        }

        @Override
        public void setSize(@NotNull int size) {
            this.size = size;
        }

        @Override
        @NotNull
        public final String getName() {
            return this.name;
        }

        @Override
        public void setName(@NotNull String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
        }
    }
}
