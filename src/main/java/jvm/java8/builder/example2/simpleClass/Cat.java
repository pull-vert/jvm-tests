/*
class Cat(api val size: Int, api val name: String)
 */

package jvm.java8.builder.example2.simpleClass;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class Cat {

    // uninstanciable
    private Cat() {
    }

    public final static Builder builder(@NotNull final int size, @NotNull final String name) {
        return new Builder(size, name);
    }

    public static interface Api {
        @NotNull
        public int getSize();

        @NotNull
        public String getName();
    }

    public static final class Builder {
        @NotNull
        private int size;
        @NotNull
        private String name;

        Builder(@NotNull final int size, @NotNull final String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.size = size;
            this.name = name;
        }

        public Api build() {
            return new Class(this.size, this.name);
        }
    }

    private static final class Class implements Api {
        @NotNull
        private final int size;
        @NotNull
        private final String name;

        /**
         * called by builder only
         */
        private Class(@NotNull final int size, @NotNull final String name) {
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
