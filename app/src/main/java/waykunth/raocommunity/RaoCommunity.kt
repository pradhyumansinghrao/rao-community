package waykunth.raocommunity

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class RaoCommunity : Application()
{
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}