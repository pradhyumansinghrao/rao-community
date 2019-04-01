package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import waykunth.raocommunity.R


class FullScreenPhotoActivity : AppCompatActivity() {

    private lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_photo)

        backBtn = findViewById(R.id.back_btn_full_screen)
        backBtn.setOnClickListener {
            finish()
        }


    }

}
