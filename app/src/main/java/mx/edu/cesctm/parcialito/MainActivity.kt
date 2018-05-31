package mx.edu.cesctm.parcialito

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_next.setOnClickListener {
            var figure: Int
            var checked: Int? = main_rg_figures.checkedRadioButtonId

            when(checked){
                R.id.main_rb_square -> figure = 1
                R.id.main_rb_rectangle -> figure = 2
                R.id.main_rb_triangle -> figure = 3
                R.id.main_rb_circle -> figure = 4
                else -> figure = 0
            }

            sendToOperation(figure)
        }
    }

    fun sendToOperation(figure: Int):Unit{
        val intentOperation: Intent = Intent(this, OperationActivity::class.java)
        intentOperation.putExtra("figure", figure)
        startActivity(intentOperation)
    }
}
