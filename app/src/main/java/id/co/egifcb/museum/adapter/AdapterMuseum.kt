package id.co.egifcb.museum.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.egifcb.museum.R
import id.co.egifcb.museum.model.Museum
import kotlinx.android.synthetic.main.layout_list.view.*

class AdapterMuseum(private val context: Context, private val list: List<Museum>, private val listener: (Museum) -> Unit)
    : RecyclerView.Adapter<AdapterMuseum.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            AdapterMuseum.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(museum: Museum, listener: (Museum) -> Unit) {
            itemView.tv_nama.text = museum.nama
            itemView.tv_kabupaten_kota.text = museum.kabupatenKota
            itemView.setOnClickListener {
                listener(museum)
            }
        }
    }
}