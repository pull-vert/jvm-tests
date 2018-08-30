/*
 class CatOwner(private val cat: Cat = Cat()) {
   func increaseSize() -> Void {
     val previousSize = cat.size
     cat.size = previousSize? + 2
   }
   func changeName(nameSuffix: String) -> Void {
     val previousName = cat.name
     cat.name = previousName? + nameSuffix
   }
 }
 */

package jvm.java11.test5;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.Optional;
import java.util.OptionalInt;

public final class CatOwner {
    @NotNull
    private final Cat cat;

    public CatOwner(@Nullable final Cat cat, int mask1) {
        this(((mask1 & 1) != 0) ? new Cat(null, 1, null, 1) : cat);
    }

    public CatOwner(@NotNull final Cat cat) {
        Validation.checkParameterIsNotNull(cat, "cat");
        this.cat = cat;
    }

    public final void increaseSize() {
        final var previousSize = (null != this.cat.getSize()) ? OptionalInt.of(this.cat.getSize()) : OptionalInt.empty();
        this.cat.setSize((previousSize.isPresent()) ? OptionalInt.of(previousSize.getAsInt() + 2) : OptionalInt.empty());
    }

    public final void changeName(@NotNull final String nameSuffix) {
        Validation.checkParameterIsNotNull(nameSuffix, "nameSuffix");
        final var previousName = Optional.ofNullable(this.cat.getName());
        this.cat.setName(previousName.map((@NotNull final var pn) -> pn + nameSuffix));
    }
}
