/*
 interface Animal {
   api func maxSpeed() -> Int

   api func printMaxSpeed() -> Void {
     println("Max speed is ${maxSpeed()}")
   }
 }
*/

package jvm.java8.builder.example1.implementInterface;

import internal.annotations.NotNull;

import java.text.MessageFormat;

public final class Animal {

    private Animal() { } // uninstanciable


    public static interface Api {
        @NotNull
        public int maxSpeed();

        public void printMaxSpeed();
    }

    public interface Interface extends Api {
        default void printMaxSpeed_jvm_java8_example1_implementInterface_Animal() {
            System.out.println(MessageFormat.format("Max speed is {0}", maxSpeed()));
        }

        @Override
        default void printMaxSpeed() {
            printMaxSpeed_jvm_java8_example1_implementInterface_Animal();
        }
    }
}
