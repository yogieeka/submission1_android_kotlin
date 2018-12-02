package yogi.dicoding.football.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import yogi.dicoding.football.model.ClubData
import yogi.dicoding.football.ui.ClubUI

/**
 * Created by yogi on 12/2/18.
 */
class ClubAdapter(val items: List<ClubData>, val listener: (ClubData) -> Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ClubUI().createView(AnkoContext.Companion.create(parent.context, parent)))


    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(ClubUI.club_image)
        val name = itemView.findViewById<TextView>(ClubUI.club_name)

        fun bind(item: ClubData, listener: (ClubData) -> Unit) {
            Glide.with(itemView.context)
                    .load(item.clubLogo)
                    .into(image)

            name.text = item.clubName

            itemView.setOnClickListener { listener(item) }
        }
    }


}