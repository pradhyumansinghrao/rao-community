package waykunth.raocommunity.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_messages.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.activities.ConversationActivity
import waykunth.raocommunity.models.Message



class MessagesAdapter(private val context: Context?, private val messageList: List<Message>?) : RecyclerView.Adapter<MessagesAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MessagesAdapter.ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_messages, parent, false))
    }

    override fun getItemCount(): Int
    {
            return messageList!!.size
    }

    override fun onBindViewHolder(holder: MessagesAdapter.ViewHolder, position: Int)
    {
        messageList?.let {
            holder.tvName.text = messageList[position].name
            holder.tvMessage.text = messageList[position].message
            holder.ivPhoto.setImageDrawable(messageList[position].image)
            holder.mView.setOnClickListener {
                val nextActivity = Intent(context,ConversationActivity::class.java)
                nextActivity.putExtra("id",messageList[position].id)
                nextActivity.putExtra("name",messageList[position].name)
                context!!.startActivity(nextActivity)
            }
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
            val mView : View = itemView
            val tvName : TextView = itemView.tv_name
            val tvMessage : TextView = itemView.tv_message
            val ivPhoto : ImageView= itemView.iv_photo

    }
}
