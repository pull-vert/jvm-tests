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

package jvm.java8.constructor.example4.nullable;

import internal.annotations.NotNull;
import internal.validation.Validation;

public final class CatOwner implements CatOwnerSj.Api {
    private CatOwnerSj.Implementation delegate;

    public CatOwner(@NotNull final Cat cat) {
        Validation.checkParameterIsNotNull(cat, "cat");
        this.delegate = new CatOwnerSj.Implementation(cat);
    }

    @Override
    public void increaseSize() {
        this.delegate.increaseSize();
    }

    @Override
    public void changeName(@NotNull String nameSuffix) {
        this.delegate.changeName(nameSuffix);
    }
}
