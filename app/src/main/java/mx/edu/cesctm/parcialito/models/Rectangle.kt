package mx.edu.cesctm.parcialito.models

class Rectangle(val base: Double, val height: Double): Figure() {
    override fun area(): Double = this.base * this.height

    override fun perimeter(): Double = 2 * (this.base + this.height)
}