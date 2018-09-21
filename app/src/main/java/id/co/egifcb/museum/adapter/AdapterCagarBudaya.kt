package id.co.egifcb.museum.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.egifcb.museum.R
import id.co.egifcb.museum.model.CagarBudaya
import kotlinx.android.synthetic.main.layout_list.view.*

class AdapterCagarBudaya(private val context: Context, private val list: List<CagarBudaya>, private val listener: (CagarBudaya) -> Unit)
    : RecyclerView.Adapter<AdapterCagarBudaya.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            AdapterCagarBudaya.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(cagarBudaya: CagarBudaya, listener: (CagarBudaya) -> Unit) {
            itemView.tv_nama.text = cagarBudaya.nama
            itemView.tv_kabupaten_kota.text = cagarBudaya.kabupatenKota
            itemView.setOnClickListener {
                listener(cagarBudaya)
            }
        }
    }
}