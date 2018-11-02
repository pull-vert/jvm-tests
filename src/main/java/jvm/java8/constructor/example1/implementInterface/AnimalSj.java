package jvm.java8.constructor.example1.implementInterface;

import internal.annotations.Final;
import internal.annotations.Protected;

import java.text.MessageFormat;

public final class AnimalSj {

    // uninstanciable
    private AnimalSj() {

    }

    public interface Complete extends Animal {
        @Protected
        @Final
        public default void printMaxSpeed_jvm_java8_constructor_example1_implementInterface_Animal() {
            System.out.println(MessageFormat.format("Max speed is {0}", maxSpeed()));
        }

        @Protected
        @Final
        public default void printMaxSpeed() {
            printMaxSpeed_jvm_java8_constructor_example1_implementInterface_Animal();
        }
    }
}
