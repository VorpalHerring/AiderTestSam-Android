package com.example.aidertestsam_android

import androidx.recyclerview.widget.RecyclerView
import com.example.aidertestsam_android.Messages.MessageModel
import com.example.aidertestsam_android.databinding.MessageCellBinding

class MessageViewHolder(private val itemBinding: MessageCellBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(message: MessageModel) {
        itemBinding.nameLabel.text = message.senderName;
        itemBinding.messageLabel.text = message.messageText;
    }
}