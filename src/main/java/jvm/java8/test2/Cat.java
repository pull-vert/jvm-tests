/*
class Cat(api val size: Int, api val name: String)
 */

package jvm.java8.test2;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class Cat {

    private Cat() { } // uninstanciable

    public static interface Api {
        @NotNull
        public int getSize();
        @NotNull
        public String getName();
    }

    @NotNull
    public static Api New(@NotNull final int size, @NotNull final String name) {
        return new Class(size, name);
    }

    private static final class Class implements Cat.Api {
        @NotNull
        private final int size;
        @NotNull
        private final String name;

        private Class(@NotNull final int size, @NotNull final String name) {
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
