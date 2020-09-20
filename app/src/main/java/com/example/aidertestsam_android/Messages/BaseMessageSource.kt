package com.example.aidertestsam_android.Messages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseMessageSource : ViewModel() {
    val messages by lazy {
        fetchMessages();
        return@lazy MutableLiveData<MutableList<MessageModel>>(mutableListOf<MessageModel>());
    }

    operator fun get(index: Int) = messages.value?.get(index) ?: MessageModel("","");

    fun size() : Int{
        return messages.value?.size ?: 0;
    }

    abstract fun fetchMessages();
}