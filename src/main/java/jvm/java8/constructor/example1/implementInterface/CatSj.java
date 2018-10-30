package jvm.java8.constructor.example1.implementInterface;

import internal.annotations.NotNull;

import java.io.Serializable;

public final class CatSj {
    // uninstanciable
    private CatSj() {
    }

    public interface Api extends Animal, Serializable {
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

    public interface Complete extends Api, AnimalSj.Complete {
        public default int maxSpeed_jvm_java8_constructor_example1_implementInterface_Cat() {
            return 12;
        }

        @Override
        @NotNull
        public default int maxSpeed() {
            return maxSpeed_jvm_java8_constructor_example1_implementInterface_Cat();
        }
    }

    static final class Implementation implements Complete {
        /**
         * called by Cat class
         */
        Implementation() {
        }
    }
}
