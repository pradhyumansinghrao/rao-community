package waykunth.raocommunity.models

import android.graphics.drawable.Drawable

data class User(
    var id : Int,
    var name : String,
    var image : Drawable,
    var occupation : String
)