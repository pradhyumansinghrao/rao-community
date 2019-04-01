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
import waykunth.raocommunity.adapters.NotificationAdapter
import waykunth.raocommunity.models.Notification



class NotificationsFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_notifications, container, false)
        recyclerView = view.findViewById(R.id.rv_notifications)
        setupRecyclerView()
        return view
    }


    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayout.VERTICAL
        val list = listOf(
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"welcome to the next generation app welcome to the next gene ration app welcome to the next generation app welcome ration app welcome to the next generation app welcomeration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome ration app welcome to the next generation app welcome to the next generation app welcome to the next generation app welcome to the next generation app",context!!.resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"3 days"),
            Notification(1,"welcome to the next generation app",context!!.resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"4 days"),
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"6 days"),
            Notification(1,"welcome to the next generation app",context!!.resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"8 days"),
            Notification(1,"welcome to the next generation app welcome to the next generation app",context!!.resources.getDrawable(R.drawable.sample1),"2 days"),
            Notification(1,"parth",context!!.resources.getDrawable(R.drawable.sample1),"9 days"),
            Notification(1,"parth welcome to the next generation app w welcome to the next generation app w welcome to the next generation app w welcome to the next generation app w",context!!.resources.getDrawable(R.drawable.sample1),"21 days")
        )

        val notificationAdapter = NotificationAdapter(activity,list)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = notificationAdapter

    }



}
