package waykunth.raocommunity.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import waykunth.raocommunity.R
import waykunth.raocommunity.adapters.PostAdapter
import waykunth.raocommunity.models.Post


class HomeFragment : Fragment() {


    private lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.rv_posts)
        setupRecyclerView()
        return view
    }





    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.google_logo),"hello welcome to this application"),
            Post(1,"parth",null,"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",null,"hello welcome to this application we will give you very nice interface and good look and lots of new features who have some value."),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.google_logo),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application"),
            Post(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"13/4",context!!.resources.getDrawable(R.drawable.sample1),"hello welcome to this application")

            )

        val postAdapter = PostAdapter(activity,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter

    }

}
