package jvm.test1;

import java.io.Serializable;

// class Cat() is Animal(), Serializable
// or
// class Cat is Animal, Serializable
public final class Cat extends Animal implements Serializable {

    // func maxSpeed() -> Int { return 12 }
    // or
    // func maxSpeed() -> Int = 12
    public final int maxSpeed() {
        return 12;
    }

    private void demoValVar() {
        // val constant = 1000
        // var variable = 0
        // ...
        // variable = 42
        final var constant = 1000;
        var variable = 0;
        variable = 42;
    }
}
