/*
 interface Animal {
   api {
     func maxSpeed() -> Int

     func printMaxSpeed() -> Void {
       println("Max speed is ${maxSpeed()}")
     }
   }
 }
*/

package jvm.java8.example1.implementInterface;

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
        @Override
        default void printMaxSpeed() {
            System.out.println(MessageFormat.format("Max speed is {0}", maxSpeed()));
        }
    }
}
