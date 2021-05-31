package com.jose.photoalbum.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jose.photoalbum.R
import com.jose.photoalbum.viewModel.MediaViewModel

class AlbumListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.album_list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.albumRecyclerView)
        var mediaAdapter: RecyclerView.Adapter<*>?

        MediaViewModel().onLoadAlbums().subscribe {
            var mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerView!!.layoutManager = mLayoutManager
            mediaAdapter = AlbumAdapter(it!!)
            recyclerView!!.adapter = mediaAdapter
        }
    }
}