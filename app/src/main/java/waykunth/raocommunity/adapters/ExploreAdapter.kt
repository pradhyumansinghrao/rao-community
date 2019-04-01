package waykunth.raocommunity.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_explore.view.*
import waykunth.raocommunity.R
import waykunth.raocommunity.models.ExploreItem

class ExploreAdapter(private val context: Context?, private val exploreItemList: List<ExploreItem>?) : RecyclerView.Adapter<ExploreAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ExploreAdapter.ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_explore, parent, false))
    }

    override fun getItemCount(): Int
    {
            return exploreItemList!!.size
    }

    override fun onBindViewHolder(holder: ExploreAdapter.ViewHolder, position: Int)
    {
        exploreItemList?.let {
            holder.tvTitle.text = exploreItemList[position].title
            holder.ivPhoto.setImageDrawable(exploreItemList[position].image)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
            val tvTitle : TextView = itemView.e_tv_title
            val ivPhoto : ImageView = itemView.e_iv_photo

    }
}
