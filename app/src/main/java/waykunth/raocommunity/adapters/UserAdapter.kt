package waykunth.raocommunity.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_user.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.activities.ConversationActivity
import waykunth.raocommunity.models.User


class UserAdapter(private val context: Context?, private val userList: List<User>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserAdapter.ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int
    {
            return userList!!.size
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int)
    {
        userList?.let {
            holder.tvName.text = userList[position].name
            holder.tvMessage.text = userList[position].occupation
            holder.ivPhoto.setImageDrawable(userList[position].image)
            holder.mView.setOnClickListener {
                val nextActivity = Intent(context,ConversationActivity::class.java)
                nextActivity.putExtra("id",userList[position].id)
                nextActivity.putExtra("name",userList[position].name)
                context!!.startActivity(nextActivity)
            }
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
            val mView : View = itemView
            val tvName : TextView = itemView.tv_uname
            val tvMessage : TextView = itemView.tv_uoccupation
            val ivPhoto : ImageView= itemView.iv_uphoto

    }
}
