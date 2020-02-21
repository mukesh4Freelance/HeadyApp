package com.jinxtris.ram.headapp.viewModel.home

import android.service.notification.NotificationListenerService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jinxtris.ram.headapp.R
import com.jinxtris.ram.headapp.extension.clickWithDebounce
import com.jinxtris.ram.headapp.model.Rankings
import kotlinx.android.synthetic.main.adapter_home.view.*

class HomeAdapter (var rankingList: List<Rankings>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var onItemClick: ((Rankings) -> Unit)? = null

    override fun getItemCount(): Int {
        return rankingList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_home,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtRanking?.text = rankingList[position].ranking
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtRanking = view.txt_adapter_ranking

        init {
            view.clickWithDebounce {
                var tradeObject = rankingList.get(adapterPosition)
                onItemClick?.invoke(tradeObject)
            }
        }
    }
}