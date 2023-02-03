package com.ms.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.Adapter.PostRecyclerView
import com.ms.myapplication.Adapter.StoryRecyclerView
import com.ms.myapplication.models.Post
import com.ms.myapplication.models.Story


class HomeFragment : Fragment() {
    private lateinit var storyRecyclerView: RecyclerView
    private lateinit var storyAdapter: StoryRecyclerView

    private lateinit var postRecyclerView: RecyclerView
    private lateinit var postAdapter: PostRecyclerView

    private lateinit var storyImageId: Array<Int>
    private lateinit var newStoryArraylist: ArrayList<Story>

    private lateinit var postUsername: Array<String>
    private lateinit var postTime: Array<String>
    private lateinit var postImageBackground: Array<Int>
    private lateinit var postUserImage: Array<Int>
    private lateinit var newPostArraylist: ArrayList<Post>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Dummy Data

        storyImageId = arrayOf(
            R.drawable.addstory,
            R.drawable.userimage1,
            R.drawable.userimage2,
            R.drawable.userimage3,
            R.drawable.userimage4
        )

        // Set Dummy Data

        postUsername = arrayOf(
            "Malena Tudi",
            "Jakob Curtis"
        )

        // Set Dummy Data

        postTime = arrayOf(
            "2 hrs ago",
            "4 hrs ago"
        )

        // Set Dummy Data

        postImageBackground = arrayOf(
            R.drawable.post1,
            R.drawable.post2
        )

        postUserImage = arrayOf(
            R.drawable.postuserimage1,
            R.drawable.postuserimage2
        )

        // Story RecyclerView Setup
        storyRecyclerView = view.findViewById(R.id.story_recyclerView)
        storyRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newStoryArraylist = arrayListOf<Story>()
        getStoryData()

        // Post RecyclerView Setup
        postRecyclerView = view.findViewById(R.id.post_recyclerView)
        postRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newPostArraylist = arrayListOf<Post>()

        // Set Dummy Data
        getPostData()

    }

    // Set Story Dummy Data Class Type and Recycler View

    private fun getStoryData() {
        for (i in storyImageId) {
            val story = Story(i)
            newStoryArraylist.add(story)
        }
        storyAdapter = StoryRecyclerView(newStoryArraylist)
        storyRecyclerView.adapter = storyAdapter
    }

    // Set Post Dummy Data Class Type and Recycler View

    private fun getPostData() {
        for (s in postUsername.indices) {
            val post = Post(postUsername[s],postTime[s], postImageBackground[s], postUserImage[s])
            newPostArraylist.add(post)
        }
        postAdapter = PostRecyclerView(newPostArraylist)
        postRecyclerView.adapter = postAdapter
    }

}