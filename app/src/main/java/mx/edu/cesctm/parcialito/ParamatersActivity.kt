package mx.edu.cesctm.parcialito

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_paramaters.*
import mx.edu.cesctm.parcialito.models.*

class ParamatersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paramaters)

        val figure:Int = intent.getIntExtra("figure", 0)
        val operation:Int = intent.getIntExtra("operation", 0)
        var f: Figure? = null
        var validate: Boolean = false

        initView(figure, operation)

        parameters_btn_calculate.setOnClickListener {
            when(figure){
                1 -> {
                    validate = emptyValue(false)
                    if(validate){
                        var side: Double = parameters_et_data_one.text.toString().toDouble()

                        f = Square(side)
                    }
                }
                2 -> {
                    validate = emptyValue(true)
                    if(validate){
                        var base: Double = parameters_et_data_one.text.toString().toDouble()
                        var height: Double = parameters_et_data_two.text.toString().toDouble()

                        f = Rectangle(base, height)
                    }
                }
                3 -> {
                    when(operation){
                        1 -> {
                            validate = emptyValue(true)
                            if(validate){
                                var base: Double = parameters_et_data_one.text.toString().toDouble()
                                var height: Double = parameters_et_data_two.text.toString().toDouble()

                                f = Triangle(base, height)
                            }
                        }
                        else -> {
                            validate = emptyValue(false)
                            if(validate){
                                var side: Double = parameters_et_data_one.text.toString().toDouble()

                                f = Triangle(side)
                            }
                        }
                    }
                }
                else -> {
                    validate = emptyValue(false)
                    if(validate){
                        var side: Double = parameters_et_data_one.text.toString().toDouble()

                        f = Circle(side)
                    }
                }
            }

            if(validate){
                val result: Double = if(operation == 1) area(f) else perimeter(f)

                sendToResult(figure, operation, result)
                //Toast.makeText(this, "Resultado $result", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "El/Los campo(s) son requeridos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun initView(figure: Int, operation: Int):Unit{
        var figureStr:String
        var operationStr:String

        when(figure){
            1 -> {
                figureStr = getString(R.string.lbl_rb_square).toString()
                parameters_et_data_one.hint = getString(R.string.lbl_hint_side)
                visible(1)
            }

            2 -> {
                figureStr = getString(R.string.lbl_rb_rectangle).toString()
                parameters_et_data_one.hint = getString(R.string.lbl_hint_base)
                parameters_et_data_two.hint = getString(R.string.lbl_hint_height)

                visible(2)
            }
            3 -> {
                figureStr = getString(R.string.lbl_rb_triangle).toString()
                when(operation){
                    1 -> {
                        parameters_et_data_one.hint = getString(R.string.lbl_hint_base)
                        parameters_et_data_two.hint = getString(R.string.lbl_hint_height)

                        visible(2)
                    }
                    else -> {
                        parameters_et_data_one.hint = getString(R.string.lbl_hint_side)

                        visible(1)
                    }
                }
            }
            else -> {
                figureStr = getString(R.string.lbl_rb_circle).toString()
                parameters_et_data_one.hint = getString(R.string.lbl_hint_radius)

                visible(1)
            }
        }
        operationStr = if(operation == 1) getString(R.string.lbl_rb_area) else getString(R.string.lbl_rb_perimeter)
        parameters_txt_header.text = "Calcular el $operationStr de/del $figureStr"
    }

    fun visible(how: Int):Unit{
        when(how){
            1 -> parameters_et_data_one.visibility = View.VISIBLE
            else ->{
                parameters_et_data_one.visibility = View.VISIBLE
                parameters_et_data_two.visibility = View.VISIBLE
            }
        }
    }

    fun emptyValue(two: Boolean): Boolean{
        if(two){
            if(parameters_et_data_one.text.isEmpty() || parameters_et_data_two.text.isEmpty()){
                return false
            }else{
                return true
            }
        }else{
            if(parameters_et_data_one.text.isEmpty()){
                return false
            }else{
                return true
            }
        }
    }

    fun sendToResult(figure: Int, operation: Int, result: Double):Unit{
        val intentResult: Intent = Intent(this, ResultActivity::class.java)
        intentResult.putExtra("figure", figure)
        intentResult.putExtra("operation", operation)
        intentResult.putExtra("result", result)

        startActivity(intentResult)
    }

    fun area(figure: Figure?): Double = figure!!.area()

    fun perimeter(figure: Figure?): Double = figure!!.perimeter()
}
