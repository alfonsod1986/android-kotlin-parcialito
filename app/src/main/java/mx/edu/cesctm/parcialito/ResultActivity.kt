package mx.edu.cesctm.parcialito

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val figure:Int = intent.getIntExtra("figure", 0)
        val operation:Int = intent.getIntExtra("operation", 0)
        val result:Double = intent.getDoubleExtra("result", 0.0)

        var figureStr:String
        var operationStr:String

        when(figure){
            1 -> figureStr = getString(R.string.lbl_rb_square).toString()
            2 -> figureStr = getString(R.string.lbl_rb_rectangle).toString()
            3 -> figureStr = getString(R.string.lbl_rb_triangle).toString()
            else -> figureStr = getString(R.string.lbl_rb_circle).toString()
        }

        operationStr = if(operation == 1) getString(R.string.lbl_rb_area).toString() else getString(R.string.lbl_rb_perimeter).toString()

        result_txt_figure.text = "Figura: $figureStr"
        result_txt_operation.text = "Operación: $operationStr"
        result_txt_result.text = "Resultado: %.2f".format(result)
    }
}
