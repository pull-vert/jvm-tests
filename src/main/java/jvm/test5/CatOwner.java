package jvm.test5;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.util.OptionalInt;

// class CatOwner(val cat: Cat = Cat()) {
// func increaseSize() -> Void {
// val previousSize = cat.size
// cat.size = previousSize? + 2
// }
//}
public final class CatOwner {
    @NotNull
    private final Cat cat;

    // ACCESSIBLE from Java ???
    // One Constructor for default values
    public CatOwner(@Nullable final Cat cat, int mask1) {
        // Call full parameters Constructor
        this(((mask1 & 1) != 0) ? new Cat(null, 1, null, 1) : cat);
    }

    // full parameters Constructor
    public CatOwner(@NotNull final Cat cat) {
        Validation.checkParameterIsNotNull(cat, "cat");
        this.cat = cat;
    }

    @NotNull
    public final Cat getCat() {
        return this.cat;
    }

    public final void increaseSize() {
        final var previousSize = (null != this.cat.getSize()) ? OptionalInt.of(this.cat.getSize()) : OptionalInt.empty();
        this.cat.setSize((previousSize.isPresent()) ? OptionalInt.of(previousSize.getAsInt() + 2) : OptionalInt.empty());
    }

    // todo changeName
    //  this.cat.setSize(previousSize.map((@NotNull final var previous) -> previous + 2));
}
