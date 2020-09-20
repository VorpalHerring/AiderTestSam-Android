package com.example.aidertestsam_android.Messages

import android.os.Looper
import com.thedeanda.lorem.LoremIpsum
import kotlin.random.Random
import kotlinx.coroutines.*

class RandomMessageSource: BaseMessageSource() {
    override fun fetchMessages() {
        val mainLooper = Looper.getMainLooper()
        GlobalScope.launch {
            generateMessages()
        }
    }

    private fun generateMessages(){
        val newMessages = mutableListOf<MessageModel>()
        val messagesToGenerate = 20;
        for(i in 0 until messagesToGenerate){
            newMessages.add(generateMessage())
        }
        messages.postValue(newMessages);
    }

    private fun generateMessage() : MessageModel{
        val loremIpsum = LoremIpsum.getInstance()
        val messageText = if(Random.nextBoolean()){
            loremIpsum.getWords(1, 6)
        }else{
            loremIpsum.getParagraphs(1,2)
        }
        return MessageModel(loremIpsum.name, messageText);
    }
}