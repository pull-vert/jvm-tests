/*
 class Cat is Animal, Serializable {
   override api func maxSpeed() -> Int {
     return 12
   }
   // or
   override api func maxSpeed() -> Int = 12

   private func demoValVar() -> Void {
     val constant = 1000
     var variable = 0
     // ...
     variable = 42
   }
 }
*/

package jvm.java8.example1.implementInterface;

import internal.annotations.NotNull;

import java.io.Serializable;

public final class Cat {

    // uninstanciable
    private Cat() {
    }

    public final static Builder builder() {
        return new Builder();
    }

    public static interface Api extends Animal.Api, Serializable {
    }

    public static final class Builder {
        Builder() {
        }

        public Api build() {
            return new Class();
        }
    }

    private static final class Class implements Api, Animal.Interface {

        /**
         * called by builder
         */
        private Class() {
        }

        @Override
        @NotNull
        public final int maxSpeed() {
            return 12;
        }

        private void demoValVar() {
            final int constant = 1000;
            int variable = 0;
            // ...
            variable = 42;
        }
    }
}
