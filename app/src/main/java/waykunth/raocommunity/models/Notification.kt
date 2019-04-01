package waykunth.raocommunity.models

import android.graphics.drawable.Drawable
data class Notification(
    var id : Int,
    var title : String,
    var image : Drawable,
    var time : String
)