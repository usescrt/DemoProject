package com.ms.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.Adapter.MessageRecyclerView
import com.ms.myapplication.Adapter.StoryRecyclerView
import com.ms.myapplication.models.Message
import com.ms.myapplication.models.Story


class ConversationsFragment : Fragment() {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageAdapter: MessageRecyclerView

    private lateinit var messageUserImageId: Array<Int>
    private lateinit var messageUsername: Array<String>
    private lateinit var messageSubtitle: Array<String>

    private lateinit var userSearchView: SearchView

    private lateinit var newMessageArraylist: ArrayList<Message>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup  Search View
        userSearchView = view.findViewById(R.id.userSearchView)
        userSearchView.clearFocus()
        userSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText.toString())
                return true
            }

        })

        // Set Dummy Data

        messageUserImageId = arrayOf(
            R.drawable.messageuserimage1,
            R.drawable.messageuserimage2,
            R.drawable.messageuserimage3,
            R.drawable.messageuserimage4,
            R.drawable.messageuserimage5
        )

        // Set Dummy Data

        messageUsername = arrayOf(
            "Malena Tudi",
            "Jakob Curtis",
            "Abram Levin",
            "Marilyn Herwitz",
            "Desirae Saris"
        )

        // Set Dummy Data

        messageSubtitle = arrayOf(
            "Hey, how’s it goin?",
            "Yo, are you going to the Jake’s wedding?",
            "Amir said we’d be staying over for a while... but ...",
            "hey, i got new memes for you",
            "GoT really took a nose dive huh"
        )

        // Message RecyclerView Setup
        messageRecyclerView = view.findViewById(R.id.messageRecyclerView)
        messageRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newMessageArraylist = arrayListOf<Message>()

        // Set Dummy Data
        getMessageData()

    }

    // Set Dummy Data Class Type and Recycler View

    private fun getMessageData() {
        for (i in messageUserImageId.indices) {
            val message = Message(messageUsername[i],messageSubtitle[i], messageUserImageId[i])
            newMessageArraylist.add(message)
        }
        messageAdapter = MessageRecyclerView(newMessageArraylist)
        messageRecyclerView.adapter = messageAdapter
    }

    // SearchView Filtered

    private fun filterList(newText: String) {
        val filteredList = ArrayList<Message>()
        for (s in messageUsername.indices) {
            if (messageUsername[s].contains(newText)) {
                val temp = Message(messageUsername[s],messageSubtitle[s], messageUserImageId[s])
                filteredList.add(temp)
            }
        }

        messageAdapter = MessageRecyclerView(filteredList)
        messageRecyclerView.adapter = messageAdapter
    }
}