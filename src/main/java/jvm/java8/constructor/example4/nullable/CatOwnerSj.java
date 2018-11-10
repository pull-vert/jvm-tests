package jvm.java8.constructor.example4.nullable;

import internal.annotations.NotNull;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

public final class CatOwnerSj {

    // uninstanciable
    private CatOwnerSj() {
    }

    public static interface Api {
        public void increaseSize();
        public void changeName(@NotNull final String nameSuffix);
    }

    static final class Implementation implements Api {
        @NotNull
        private final Cat cat;

        Implementation(@NotNull final Cat cat) {
            Validation.checkParameterIsNotNull(cat, "cat");
            this.cat = cat;
        }

        public final void increaseSize() {
            final OptionalInt previousSize = this.cat.getSize();
            this.cat.setSize((previousSize.isPresent()) ? OptionalInt.of(previousSize.getAsInt() + 2) : OptionalInt.empty());
        }

        public final void changeName(@NotNull final String nameSuffix) {
            Validation.checkParameterIsNotNull(nameSuffix, "nameSuffix");
            final Optional<String> previousName = this.cat.getName();
            this.cat.setName(previousName.map(pn -> pn + nameSuffix));
        }
    }
}
