package jvm.test1

interface Animal {
  api {
    func maxSpeed() -> Int

    func printMaxSpeed() -> Void {
      println("Max speed is ${maxSpeed()}")
    }
  }
}