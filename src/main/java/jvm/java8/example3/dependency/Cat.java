/*
 class Cat(var size: Int = 26, var name: String = 'Grumpy')
 */

package jvm.java8.example3.dependency;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class Cat {

    // uninstanciable
    private Cat() {
    }

    public final static Builder builder() {
        return new Builder();
    }

    public static interface Api {
        @NotNull
        public int getSize();

        public void setSize(@NotNull final int size);

        @NotNull
        public String getName();

        public void setName(@NotNull final String name);
    }

    public static final class Builder {
        @NotNull
        private int size = 26;
        @NotNull
        private String name = "Grumpy";

        Builder() {
        }

        public final Builder withSize(@NotNull final int size) {
            this.size = size;
            return this;
        }

        public final Builder withName(@NotNull final String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
            return this;
        }

        public Api build() {
            return new Class(this.size, this.name);
        }
    }

    private static final class Class implements Api {
        @NotNull
        private int size;
        @NotNull
        private String name;

        public Class(@NotNull final int size, @NotNull final String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.size = size;
            this.name = name;
        }

        @NotNull
        public final int getSize() {
            return this.size;
        }

        public final void setSize(@NotNull final int size) {
            this.size = size;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final void setName(@NotNull final String name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
        }
    }
}
