package jvm.java8.constructor.example1.implementInterface;

import java.text.MessageFormat;

public final class AnimalSj {

    // uninstanciable
    private AnimalSj() {

    }

    public interface Complete extends Animal {
        public default void printMaxSpeed_jvm_java8_constructor_example1_implementInterface_Animal() {
            System.out.println(MessageFormat.format("Max speed is {0}", maxSpeed()));
        }

        public default void printMaxSpeed() {
            printMaxSpeed_jvm_java8_constructor_example1_implementInterface_Animal();
        }
    }
}
