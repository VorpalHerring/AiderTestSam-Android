package com.example.aidertestsam_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aidertestsam_android.Messages.RandomMessageSource
import com.example.aidertestsam_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var messageList: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val messageSource by viewModels<RandomMessageSource>();//ViewModelProvider(this).get(RandomMessageSource::class.java)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MessageListAdapter(this, messageSource);
        messageList = binding.messageList;
        messageList.layoutManager = viewManager;
        messageList.adapter = viewAdapter;
    }
}