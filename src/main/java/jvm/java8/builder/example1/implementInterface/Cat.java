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

package jvm.java8.builder.example1.implementInterface;

import internal.annotations.NotNull;

import java.io.Serializable;

public final class Cat {

    // uninstanciable
    private Cat() {
    }

    public final static Builder builder() {
        return new Builder();
    }

    public interface Api extends Animal.Api, Serializable {
    }

    private static class PrivateMethods {
        // No need to pass Complete parameter because code is independent
        private static void demoValVar() {
            final int constant = 1000;
            int variable = 0;
            // ...
            variable = 42;
        }
    }

    public interface Complete extends Api, Animal.Interface {
        public default int maxSpeed_jvm_java8_constructor_example1_implementInterface_Cat() {
            return 12;
        }

        @Override
        @NotNull
        public default int maxSpeed() {
            return maxSpeed_jvm_java8_constructor_example1_implementInterface_Cat();
        }
    }

    public static final class Builder {
        Builder() {
        }

        public Api build() {
            return new Class();
        }
    }

    private static final class Class implements Complete {

        /**
         * called by builder
         */
        private Class() {
        }
    }
}
