package waykunth.raocommunity.models

import android.graphics.drawable.Drawable

data class Post(
    var id : Int,
    var userName : String,
    var userImage : Drawable?,
    var postDate : String,
    var postPhoto : Drawable?,
    var postDesc : String
)