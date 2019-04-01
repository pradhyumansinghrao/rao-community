package waykunth.raocommunity.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import waykunth.raocommunity.R
import kotlinx.android.synthetic.main.activity_create_post.*
import java.io.File


class CreatePostActivity : AppCompatActivity() {

    private val requestCode = 71
    private var imageFileUri: Uri? = null


    private lateinit var backBtn : ImageView
    private lateinit var  toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }

        toolbar = findViewById(R.id.toolbar_main)
        toolbar.inflateMenu(R.menu.menu_create_post)
        toolbar.setOnMenuItemClickListener{

            when(it.itemId)
            {
                R.id.done -> finish()

                R.id.add_media -> chooseImage()
            }
            true
        }


    }


    private fun chooseImage() {
        val imageFilePath = Environment.getExternalStorageDirectory().absolutePath + "/picture.jpg"
        val imageFile = File(imageFilePath)
        imageFileUri = Uri.fromFile(imageFile)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri)
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        val chooser = Intent.createChooser(galleryIntent, "Select Source")
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        startActivityForResult(chooser, requestCode)
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCode && resultCode == Activity.RESULT_OK
            && data != null && data.data != null
        ) {
            val uri = data.data
            create_post_image.setImageURI(uri)
            create_post_image.visibility = View.VISIBLE
        }
    }
}
