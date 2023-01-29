package com.example.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.gridview.databinding.ListItemBinding

internal class ImageListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val percent: Int, // use this to render this number of dot
    private val itemList: Array<String>?
) : ArrayAdapter<ImageListAdapter.ItemViewHolder>(context, resource) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: ListItemBinding

    override fun getCount(): Int {
        //return if (this.itemList != null) this.itemList.size else 0
        return 100
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ItemViewHolder
        if (convertView == null) {
            itemBinding = ListItemBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
//            holder.name = itemBinding.textView
            holder.icon = itemBinding.icon
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
//        holder.name!!.text = this.itemList!![position]
        if (position+1 <= percent){
            holder.icon!!.setImageResource(R.drawable.dot_yellow)
        }else{
            holder.icon!!.setImageResource(R.drawable.dot_yellow_low_opacity)
        }
        return convertView
    }

    internal class ItemViewHolder {
//        var name: TextView? = null
        var icon: ImageView? = null
    }
}
