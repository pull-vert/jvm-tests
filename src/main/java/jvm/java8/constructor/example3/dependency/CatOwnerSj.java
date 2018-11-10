package jvm.java8.constructor.example3.dependency;

import internal.annotations.NotNull;
import internal.validation.Validation;

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
