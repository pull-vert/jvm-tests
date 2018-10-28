/*
 class CatOwner(private val cat: Cat = new Cat()) {
   api {
     func increaseSize() -> Void {
       val previousSize = cat.size
       cat.size = previousSize? + 2
     }

     func changeName(nameSuffix: String) -> Void {
       val previousName = cat.name
       cat.name = previousName? + nameSuffix
     }
   }
 }
 */

package jvm.java8.serialize.jacksonAnnotations;

import internal.annotations.NotNull;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

public final class CatOwner {

    public static interface Api {
        public void increaseSize();
        public void changeName(@NotNull final String nameSuffix);
    }

    public static final class Builder {
        @NotNull
        private Cat.Api cat = new Cat.Builder().build();

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

//        public CatOwner(@Nullable final Cat cat, int mask1) {
//            this(((mask1 & 1) != 0) ? new Cat(null, 1, null, 1) : cat);
//        }

        private Class(@NotNull final Cat.Api cat) {
            Validation.checkParameterIsNotNull(cat, "cat");
            this.cat = cat;
        }

        @Override
        public final void increaseSize() {
            final OptionalInt previousSize = this.cat.getSize();
            this.cat.setSize((previousSize.isPresent()) ? OptionalInt.of(previousSize.getAsInt() + 2) : OptionalInt.empty());
        }

        @Override
        public final void changeName(@NotNull final String nameSuffix) {
            Validation.checkParameterIsNotNull(nameSuffix, "nameSuffix");
            final Optional<String> previousName = this.cat.getName();
            this.cat.setName(previousName.map(pn -> pn + nameSuffix));
        }
    }
}
