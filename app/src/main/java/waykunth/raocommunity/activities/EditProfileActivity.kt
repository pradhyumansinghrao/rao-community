package waykunth.raocommunity.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_edit_profile.*
import waykunth.raocommunity.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var backBtn : ImageView
    private lateinit var nextActivity : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }


    private fun goToActivity(destination : Class<*>,text : String,data : String)
    {
        nextActivity = Intent(this,destination)
        nextActivity.putExtra("eName",text)
        nextActivity.putExtra("eData",data)
        startActivity(nextActivity)
    }

    fun mobileNumber(view : View)
    {
        goToActivity(EditTextActivity::class.java,_mobile_number.text.toString(),_data_mobile_number.text.toString())
    }

    fun occupation(view : View)
    {
        goToActivity(EditTextActivity::class.java,_occupation.text.toString(),_data_occupation.text.toString())
    }

    fun dob(view : View)
    {
        goToActivity(EditTextActivity::class.java,_dob.text.toString(),_data_dob.text.toString())
    }

    fun gender(view : View)
    {
        goToActivity(EditTextActivity::class.java,_gender.text.toString(),_data_gender.text.toString())
    }

    fun facebook(view : View)
    {
        goToActivity(EditTextActivity::class.java,_facebook.text.toString(),_data_facebook.text.toString())
    }

    fun twitter(view : View)
    {
        goToActivity(EditTextActivity::class.java,_twitter.text.toString(),_data_twitter.text.toString())
    }

    fun instagram(view : View)
    {
        goToActivity(EditTextActivity::class.java,_instagram.text.toString(),_data_instagram.text.toString())
    }
}
