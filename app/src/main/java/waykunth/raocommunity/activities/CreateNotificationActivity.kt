package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import waykunth.raocommunity.R

class CreateNotificationActivity : AppCompatActivity() {

    private lateinit var backBtn : ImageView
    private lateinit var  toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notification)

        toolbar = findViewById(R.id.toolbar_main)
        toolbar.inflateMenu(R.menu.menu_create_notification)
        toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.done -> finish()

            }
            true
        }


        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }

}
