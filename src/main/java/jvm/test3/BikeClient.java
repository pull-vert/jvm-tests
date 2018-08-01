package jvm.test3;

import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

// class BikeClient(val bike: Bike = Bike()) {
// func increaseWheelSize() -> Void {
// val previousSize = bike.wheelSize
// bike.wheelSize = previousSize + 2
// }
//}
public final class BikeClient {
    @NotNull
    private final Bike bike;

    // NOT ACCESSIBLE from Java !!!
    // One Constructor for default values
    public BikeClient(@Nullable final Bike bike, int mask1) {
        // Call full parameters Constructor
        this(((mask1 & 1) != 0) ? new Bike(null, 1, null, 1) : bike);
    }

    // full parameters Constructor
    public BikeClient(@NotNull final Bike bike) {
        Validation.checkParameterIsNotNull(bike, "bike");
        this.bike = bike;
    }

    @NotNull
    public final Bike getBike() {
        return this.bike;
    }

    public final void increaseWheelSize() {
        final var previousSize = this.bike.getWheelSize();
        this.bike.setWheelSize(previousSize + 2);
    }
}
