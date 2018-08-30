/*
 class Cat is Animal, Serializable {
 func maxSpeed() -> Int { return 12 }
 or
 func maxSpeed() -> Int = 12

 private func demoValVar() -> Void {
 val constant = 1000
 var variable = 0
 ...
 variable = 42
 }
 }
*/

package jvm.java10.test1;

import java.io.Serializable;

public final class Cat extends Animal implements Serializable {

    public final int maxSpeed() {
        return 12;
    }

    private void demoValVar() {
        final var constant = 1000;
        var variable = 0;
        // ...
        variable = 42;
    }
}
