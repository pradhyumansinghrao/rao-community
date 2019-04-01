package waykunth.raocommunity.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_messages.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.activities.NewConversationActivity
import waykunth.raocommunity.adapters.MessagesAdapter
import waykunth.raocommunity.models.Message


class MessagesFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var nextActivity : Intent
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_messages, container, false)
        recyclerView = view.findViewById(R.id.rv_messages)
        setupRecyclerView()

        view.fab_message.setOnClickListener {
            nextActivity = Intent(activity,NewConversationActivity::class.java)
            startActivity(nextActivity)
        }

        return view
    }


    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
            Message(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"hello"),
            Message(1,"deepak singh chouhan",context!!.resources.getDrawable(R.drawable.sample1),"how are you"),
            Message(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"good"),
            Message(1,"Raju Padihar",context!!.resources.getDrawable(R.drawable.sample1),"thanks"),
            Message(1,"Suresh Andra",context!!.resources.getDrawable(R.drawable.sample1),"welcome to my app"),
            Message(1,"Ramesh yadav",context!!.resources.getDrawable(R.drawable.sample1),"where are you"),
            Message(1,"dinesh raj",context!!.resources.getDrawable(R.drawable.sample1),"he is my friend"),
            Message(1,"Raghuveer singh",context!!.resources.getDrawable(R.drawable.sample1),"i am ok"),
            Message(1,"Rakesh Ram",context!!.resources.getDrawable(R.drawable.sample1),"i find another PG"),
            Message(1,"Rohini thakur",context!!.resources.getDrawable(R.drawable.sample1),"are you ok ?"),
            Message(1,"Naresh Dangi",context!!.resources.getDrawable(R.drawable.sample1),"No")
        )

        val messageAdapter = MessagesAdapter(activity,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = messageAdapter

    }

}
