package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import waykunth.raocommunity.R
import waykunth.raocommunity.adapters.NotificationAdapter
import waykunth.raocommunity.models.Notification

class MyNotificationActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notification)
        recyclerView = findViewById(R.id.rv_my_notifications)
        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"welcome to the next generation app welcome to the next gene ration app welcome to the next generation app welcome ration app welcome to the next generation app welcomeration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome to the next generation app welcome to the next generation app welcome to the next generation app",resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"3 days"),
            Notification(1,"welcome to the next generation app",resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"4 days"),
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"6 days"),
            Notification(1,"welcome to the next generation app",resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"8 days"),
            Notification(1,"welcome to the next generation app welcome to the next generation app",resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",resources.getDrawable(R.drawable.sample1),"9 days"),
            Notification(1,"parth welcome to the next generation app w welcome to the next generation app w welcome to the next generation app w welcome to the next generation app w",resources.getDrawable(R.drawable.sample1),"21 days")
        )

        val notificationAdapter = NotificationAdapter(this,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = notificationAdapter

    }
}
