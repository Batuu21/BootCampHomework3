package com.example.homework3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.avatar.view.*

class AvatarRecyclerviewAdapter( val items: List<item>,  val recycle : RecyclerView) : RecyclerView.Adapter<AvatarRecyclerviewAdapter.İtemHolder>() {

    var lastselected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): İtemHolder {
        return İtemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.avatar, parent, false)
        )
    }
    override fun onBindViewHolder(holder: İtemHolder, position: Int) {
        val avatar = this.items[position]
        holder.bind(avatar)
        if(position==0){
            holder.avatarr.gone()
            holder.checkbox.gone()
        }
        else{
            holder.title.gone()
        }
        holder.itemView.setOnClickListener {

             if(lastselected==-1){
                 it.checkbox.setImageResource(R.drawable.ic_success_outline)
                 lastselected=holder.adapterPosition
             }
            else{
                val view : View? = recycle.layoutManager?.findViewByPosition(lastselected)
                 view?.checkbox?.setImageResource(R.drawable.ic_avatarbg)
                 it.checkbox.setImageResource(R.drawable.ic_success_outline)
                 lastselected=holder.adapterPosition
             }

        }
    }
    override fun getItemCount(): Int = this.items.size

    inner class İtemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<AppCompatTextView>(R.id.title)
        val avatarr = itemView.findViewById<AppCompatImageView>(R.id.avatar)
        val checkbox =itemView.findViewById<AppCompatImageView>(R.id.checkbox)

        fun bind(avatar: item) {
            title.text = avatar.text
            avatarr.setImageResource(avatar.avatar)
            checkbox.setImageResource (R.drawable.ic_avatarbg )
        }
    }
}
