package mx.edu.cesctm.parcialito.models

class Square(val side: Double): Figure(){
    override fun area(): Double = this.side * this.side

    override fun perimeter(): Double = this.side * 4
}