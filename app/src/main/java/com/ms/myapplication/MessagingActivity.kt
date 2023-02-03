package com.ms.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.Adapter.ChatRecyclerView
import com.ms.myapplication.Adapter.MessageRecyclerView
import com.ms.myapplication.models.Message

class MessagingActivity : AppCompatActivity() {

    private lateinit var userImage: ImageView
    private lateinit var username: TextView
    private lateinit var backButton: ImageButton

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var chatAdapter: ChatRecyclerView

    private var chatMessages= ArrayList<String>()

    private lateinit var sendInputText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messaging)

        userImage = findViewById(R.id.messagingUserImage)
        username = findViewById(R.id.messagingUserName)
        backButton = findViewById(R.id.messagingBackButton)
        sendInputText = findViewById(R.id.sendInputText)
        backButton.setOnClickListener {
            finish()
        }

        // Pass Data
        val messagePastData = intent.getSerializableExtra("messageData") as Message

        userImage.setImageResource(messagePastData.userImage)
        username.text = messagePastData.username

        // Set Dummy Data

        chatMessages.add("when?")
        chatMessages.add("see the lions or sea lions? also, is mac there with u??")

        // Setup RecyclerView and Adapter
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        chatRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        chatAdapter = ChatRecyclerView(chatMessages)
        chatRecyclerView.adapter = chatAdapter


        // User Input Message Listener
        sendInputText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // Call onDone result here
                val tempMessage = sendInputText.text
                chatMessages.add(tempMessage.toString())
                sendInputText.setText("")
                true
            }
            false
        }

    }


}