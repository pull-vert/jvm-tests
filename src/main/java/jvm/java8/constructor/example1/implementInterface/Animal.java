/*
 interface Animal {
   api func maxSpeed() -> Int

   protected func printMaxSpeed() -> Void {
     println("Max speed is ${maxSpeed()}")
   }
 }
*/

package jvm.java8.constructor.example1.implementInterface;

import internal.annotations.NotNull;

public interface Animal {
    @NotNull
    public int maxSpeed();
}
