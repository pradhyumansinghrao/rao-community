package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import waykunth.raocommunity.R

class ConversationActivity : AppCompatActivity() {

    private lateinit var activityTitle : TextView
    private lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        activityTitle = findViewById(R.id.activity_title)
        val bundle: Bundle? = intent.extras

        bundle?.let {
            val name = bundle.getString("name")
            activityTitle.text = name
        }

        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}
