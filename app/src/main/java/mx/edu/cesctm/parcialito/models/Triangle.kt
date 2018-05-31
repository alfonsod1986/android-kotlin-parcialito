package mx.edu.cesctm.parcialito.models

class Triangle(val base: Double, val height: Double): Figure() {

    constructor(base: Double):this(base, 1.0)

    override fun area(): Double = (this.base * this.height)/2

    override fun perimeter(): Double = this.base * 3
}