package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.select_avatar.*

data class item(val avatar : Int=0, val text : String="")

class AvatarFragment : Fragment() {

    private lateinit var avatarRecyclerviewAdapter: AvatarRecyclerviewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.select_avatar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var items = listOf(
            item( 0, "Kullanıcı adınızı oluşturun ve size uygun bir avatar seçin"),
            item( R.drawable.avatar1),
            item( R.drawable.avatar2),
            item( R.drawable.avatar3),
            item( R.drawable.avatar4),
            item( R.drawable.avatar5),
            item( R.drawable.avatar6),
            item( R.drawable.avatar7),
            item( R.drawable.avatar8),
            item( R.drawable.avatar9),
            item(R.drawable.avatar1),
            item( R.drawable.avatar2),
            item( R.drawable.avatar3),
            item( R.drawable.avatar4),
            item( R.drawable.avatar5),
            item( R.drawable.avatar6),
            item( R.drawable.avatar7),
            item( R.drawable.avatar8),
            item( R.drawable.avatar9)
        )
        val layoutManager = GridLayoutManager(this.context, 3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 3
                    else -> 1
                }
            }
        }

        recyclerview.layoutManager = layoutManager
        avatarRecyclerviewAdapter = AvatarRecyclerviewAdapter(items,recyclerview)
        recyclerview.adapter = avatarRecyclerviewAdapter

    }



}
