package waykunth.raocommunity.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import waykunth.raocommunity.R
import waykunth.raocommunity.adapters.ExploreAdapter
import waykunth.raocommunity.models.ExploreItem
import android.support.v7.widget.GridLayoutManager



class ExploreFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_explore, container, false)
        recyclerView = view.findViewById(R.id.rv_explore)
        setupRecyclerView()
        return view
    }


    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
                      ExploreItem(1,"Cricket",resources.getDrawable(R.drawable.cricket)),
                      ExploreItem(2,"Volly Ball",resources.getDrawable(R.drawable.vollyball)),
                      ExploreItem(3,"Find",resources.getDrawable(R.drawable.vollyball))

        )

        val notificationAdapter = ExploreAdapter(activity,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = notificationAdapter

    }

}
