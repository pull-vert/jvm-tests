package internal.validation;

import internal.annotations.NotNull;
import internal.annotations.Nullable;

public class Validation {
    private Validation() {} // uninstanciable

    public static <T> void checkParameterIsNotNull(@Nullable T obj, @NotNull String paramName) {
        if (null == obj) {
            throw new NullPointerException("Parameter " + paramName + " must not be null !!!");
        }
    }
}
