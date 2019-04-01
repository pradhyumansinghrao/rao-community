package waykunth.raocommunity.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other_user_profile.*
import waykunth.raocommunity.R
import android.net.Uri
import android.view.View


class OtherUserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_user_profile)

        ot_user_photo.setOnClickListener{
           goToActivity(FullScreenPhotoActivity::class.java)
        }

        ot_user_say_hello.setOnClickListener {
           goToActivity(ConversationActivity::class.java)
        }
    }


    private fun goToActivity(destination : Class<*>)
    {
        val nextActivity = Intent(this,destination)
        startActivity(nextActivity)
    }

    private fun openUrl(url : String)
    {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    fun openFacebook(view : View)
    {
        openUrl("https://www.facebook.com/raoparthzx")
    }

   fun openTwitter(view : View)
    {
        openUrl("https://www.twitter.com/raoparthzx")
    }

    fun openInstagram(view : View)
    {
        openUrl("https://www.instagram.com/raoparthzx")
    }
}
