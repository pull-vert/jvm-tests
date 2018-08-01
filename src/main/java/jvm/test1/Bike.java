package jvm.test1;

import java.io.Serializable;

// class Bike() is Vehicle(), Serializable
// or
// class Bike is Vehicle, Serializable
public final class Bike extends Vehicle implements Serializable {

    // func maxSpeed() -> Int { return 12 }
    // or
    // func maxSpeed() -> Int = 12
    public final int maxSpeed() {
        return 12;
    }

    private void demoValVar() {
        // val constant = 1000
        final var constant = Integer.valueOf(1000); // a local val or val doesn't use Optional
        // var variable = 0
        // ...
        // variable = 42
        var variable = Integer.valueOf(0);
        variable = 42;
    }
}
