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

package jvm.java8.constructor.example1.implementInterface;

public final class Cat implements CatSj.Api {
    private CatSj.Implementation delegate;

    public Cat() {
        delegate = new CatSj.Implementation();
    }

    @Override
    public int maxSpeed() {
        return delegate.maxSpeed();
    }
}
