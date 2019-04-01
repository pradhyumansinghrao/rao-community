package waykunth.raocommunity.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_notification.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.models.Notification

class NotificationAdapter(val context: Context?, private val notificationList: List<Notification>?) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NotificationAdapter.ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false))
    }

    override fun getItemCount(): Int
    {
            return notificationList!!.size
    }

    override fun onBindViewHolder(holder: NotificationAdapter.ViewHolder, position: Int)
    {
        notificationList?.let {
            holder.tvTitle.text = notificationList[position].title
            holder.tvTime.text = notificationList[position].time
            holder.ivIcon.setImageDrawable(notificationList[position].image)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
            val tvTitle : TextView = itemView.tv_title
            val tvTime : TextView = itemView.tv_time
            val ivIcon : ImageView= itemView.iv_icon

    }
}
