package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import waykunth.raocommunity.R
import waykunth.raocommunity.adapters.PostAdapter
import waykunth.raocommunity.models.Post

class MyPostActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_post)
        recyclerView = findViewById(R.id.rv_my_posts)
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
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.google_logo),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",null,"hello welcome to this application we will give you very nice interface and good look and lots of new features who have some value."),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.google_logo),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",resources.getDrawable(R.drawable.sample1),"13/4",resources.getDrawable(R.drawable.sample1),"hello welcome to this application")

        )

        val postAdapter = PostAdapter(this,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter

    }
}
