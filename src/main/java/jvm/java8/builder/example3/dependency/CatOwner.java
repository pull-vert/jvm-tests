/*
 class CatOwner(private val cat: Cat = Cat()) {
   api func increaseSize() -> Void {
     val previousSize = cat.size
     cat.size = previousSize + 2
   }

   api func changeName(nameSuffix: String) -> Void {
     val previousName = cat.name
     cat.name = previousName + nameSuffix
   }
 }
 */

package jvm.java8.builder.example3.dependency;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class CatOwner {

    // uninstanciable
    private CatOwner() {
    }

    public final static Builder builder() {
        return new Builder();
    }

    public static interface Api {
        public void increaseSize();
        public void changeName(@NotNull final String nameSuffix);
    }

    public static final class Builder {
        @NotNull
        private Cat.Api cat = Cat.builder().build();

        Builder() {
        }

        public final Builder withCat(@NotNull final Cat.Api cat) {
            Validation.checkParameterIsNotNull(cat, "cat");
            this.cat = cat;
            return this;
        }

        public Api build() {
            return new Class(this.cat);
        }
    }

    private static final class Class implements Api {
        @NotNull
        private final Cat.Api cat;

        private Class(@NotNull final Cat.Api cat) {
            Validation.checkParameterIsNotNull(cat, "cat");
            this.cat = cat;
        }

        @Override
        public final void increaseSize() {
            final int previousSize = this.cat.getSize();
            this.cat.setSize(previousSize + 2);
        }

        @Override
        public final void changeName(@NotNull final String nameSuffix) {
            Validation.checkParameterIsNotNull(nameSuffix, "nameSuffix");
            final String previousName = this.cat.getName();
            this.cat.setName(previousName + nameSuffix);
        }
    }
}
