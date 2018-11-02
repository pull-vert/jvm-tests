/*
 interface Animal {
   api func maxSpeed() -> Int

   protected func printMaxSpeed() -> Void {
     println("Max speed is ${maxSpeed()}")
   }
 }
*/

package jvm.java8.builder.example1.implementInterface;

import internal.annotations.Final;
import internal.annotations.NotNull;
import internal.annotations.Protected;

import java.text.MessageFormat;

public final class Animal {

    private Animal() { } // uninstanciable


    public static interface Api {
        @NotNull
        public int maxSpeed();
    }

    public interface Interface extends Api {
        @Protected
        @Final
        public default void printMaxSpeed_jvm_java8_builder_example1_implementInterface_Animal() {
            System.out.println(MessageFormat.format("Max speed is {0}", maxSpeed()));
        }

        @Protected
        @Final
        public default void printMaxSpeed() {
            printMaxSpeed_jvm_java8_builder_example1_implementInterface_Animal();
        }
    }
}
