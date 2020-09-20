package com.example.aidertestsam_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.aidertestsam_android.Messages.BaseMessageSource
import com.example.aidertestsam_android.databinding.MessageCellBinding

class MessageListAdapter(lifeCycleOwner: LifecycleOwner, private val messageSource: BaseMessageSource) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        messageSource.messages.observe(lifeCycleOwner, Observer {
            notifyDataSetChanged();
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = MessageCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MessageViewHolder) {
            holder.bind(messageSource[position]);
        }
    }

    override fun getItemCount(): Int {
        return messageSource.size();
    }
}