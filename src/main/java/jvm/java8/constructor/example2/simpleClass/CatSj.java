package jvm.java8.constructor.example2.simpleClass;

import internal.annotations.NotNull;
import internal.validation.Validation;

public class CatSj {
    // uninstanciable
    private CatSj() {
    }

    public static interface Api {
        @NotNull
        public int getSize();

        @NotNull
        public String getName();
    }

    static final class Implementation implements Api {
        @NotNull
        private final int size;
        @NotNull
        private final String name;

        /**
         * called by builder only
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
        @NotNull
        public final String getName() {
            return this.name;
        }
    }
}
