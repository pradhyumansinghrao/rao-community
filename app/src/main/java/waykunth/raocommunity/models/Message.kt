package waykunth.raocommunity.models

import android.graphics.drawable.Drawable

data class Message(
    var id : Int,
    var name : String,
    var image : Drawable,
    var message : String
)