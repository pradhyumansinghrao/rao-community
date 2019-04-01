package waykunth.raocommunity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import waykunth.raocommunity.R
import waykunth.raocommunity.adapters.UserAdapter
import waykunth.raocommunity.models.User



class NewConversationActivity : AppCompatActivity() {

    private lateinit var searchPeople : EditText
    private lateinit var recyclerView : RecyclerView
    private lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_conversation)
        recyclerView = findViewById(R.id.rv_people)
        searchPeople = findViewById(R.id.search_people)
        backBtn = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }

        searchPeople.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setupRecyclerView(s)
            }

        })

    }

    private fun setupRecyclerView(str : CharSequence?) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
            User(1,"parth",resources.getDrawable(R.drawable.sample1),"Teacher"),
            User(1,"deepak singh chouhan",resources.getDrawable(R.drawable.sample1),"Doctor"),
            User(1,"parth",resources.getDrawable(R.drawable.sample1),"Enginner"),
            User(1,"Raju Padihar",resources.getDrawable(R.drawable.sample1),"Producer"),
            User(1,"Suresh Andra",resources.getDrawable(R.drawable.sample1),"Director"),
            User(1,"Ramesh yadav",resources.getDrawable(R.drawable.sample1),"Developer"),
            User(1,"dinesh raj",resources.getDrawable(R.drawable.sample1),"Sels Man"),
            User(1,"Raghuveer singh",resources.getDrawable(R.drawable.sample1),"Student"),
            User(1,"Rakesh Ram",resources.getDrawable(R.drawable.sample1),"Writter"),
            User(1,"Rohini thakur",resources.getDrawable(R.drawable.sample1),"Poet"),
            User(1,"Naresh Dangi",resources.getDrawable(R.drawable.sample1),"Manager")
        )

        val filteredList : List<User> =  list.filter{ it.name.contains(str!!,true)}
        val userAdapter = UserAdapter(this,filteredList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = userAdapter

    }

}
