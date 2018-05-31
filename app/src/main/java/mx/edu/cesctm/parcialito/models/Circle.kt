package mx.edu.cesctm.parcialito.models

class Circle(val radius: Double): Figure() {
    override fun area(): Double = Math.PI * Math.pow(this.radius, 2.0)

    override fun perimeter(): Double = Math.PI * (this.radius * 2)
}