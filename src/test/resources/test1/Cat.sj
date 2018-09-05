package jvm.test1

class Cat is Animal, Serializable {
    func maxSpeed() -> Int = 12

    private func demoValVar() -> Void {
        val constant = 1000
        var variable = 0
        //...
        variable = 42
    }
}