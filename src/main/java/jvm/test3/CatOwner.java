/*
 class CatOwner(val cat: Cat = Cat()) {
   func increaseSize() -> Void {
     val previousSize = cat.size
     cat.size = previousSize + 2
   }
 }
 */

package jvm.test3;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

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

    @NotNull
    public final Cat getCat() {
        return this.cat;
    }

    public final void increaseSize() {
        final var previousSize = this.cat.getWheelSize();
        this.cat.setWheelSize(previousSize + 2);
    }
}
