package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_edit_text.*
import waykunth.raocommunity.R

class EditTextActivity : AppCompatActivity(){

    private lateinit var backBtn : ImageView
    private lateinit var  toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }

        val str  = intent.getStringExtra("eName")
        activityName.text = str
        changer.text = str
        val str2 = intent.getStringExtra("eData")
        data.setText(str2)


        toolbar = findViewById(R.id.toolbar_main)
        toolbar.inflateMenu(R.menu.menu_create_post)
        toolbar.setOnMenuItemClickListener{

            when(it.itemId)
            {
                R.id.done -> finish()
            }
            true
        }

    }

}
