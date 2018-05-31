package mx.edu.cesctm.parcialito

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_operation.*

class OperationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        operation_btn_next.setOnClickListener {
            val figure:Int = intent.getIntExtra("figure", 0)
            var operation: Int
            var checked: Int? =  operation_rg_operations.checkedRadioButtonId

            when(checked){
                R.id.operation_rb_area -> operation = 1
                R.id.operation_rb_perimeter -> operation = 2
                else -> operation = 0
            }

            sendToParameter(figure, operation)
        }
    }

    fun sendToParameter(figure: Int, operation: Int):Unit{
        val intentParameter: Intent = Intent(this, ParamatersActivity::class.java)
        intentParameter.putExtra("figure", figure)
        intentParameter.putExtra("operation", operation)
        startActivity(intentParameter)
    }
}
