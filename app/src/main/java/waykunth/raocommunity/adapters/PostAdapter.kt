package waykunth.raocommunity.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_post.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.activities.OtherUserProfileActivity
import waykunth.raocommunity.models.Post

class PostAdapter(private val context: Context?, private val postList: List<Post>?) : RecyclerView.Adapter<PostAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PostAdapter.ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post, parent, false))
    }

    override fun getItemCount(): Int
    {
            return postList!!.size
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int)
    {
        postList?.let {
            holder.userName.text = postList[position].userName
            holder.userPhoto.setImageDrawable(postList[position].userImage)
            holder.postDate.text = postList[position].postDate
            holder.postPhoto.setImageDrawable(postList[position].postPhoto)
            holder.postDesc.text = postList[position].postDesc
            if(postList[position].postPhoto == null)
            {
                holder.postPhoto.visibility = View.GONE
            }

            holder.userName.setOnClickListener {
                val other = Intent(context,OtherUserProfileActivity::class.java)
                context!!.startActivity(other)
            }

            holder.userPhoto.setOnClickListener {
                val other = Intent(context,OtherUserProfileActivity::class.java)
                context!!.startActivity(other)
            }
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
            val userName : TextView = itemView.user_name
            val userPhoto : CircleImageView = itemView.user_photo
            val postDate : TextView = itemView.post_date
            val postPhoto : ImageView = itemView.post_photo
            val postDesc : TextView = itemView.post_desc


    }
}
