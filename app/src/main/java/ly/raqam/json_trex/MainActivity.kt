package ly.raqam.json_trex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ly.raqam.json_trex.data.PostViewModel
import ly.raqam.json_trex.data.model.ListPost
import ly.raqam.json_trex.data.model.ListPostItem
import ly.raqam.json_trex.vmdata.entity.resource.ResourceFack

class MainActivity : AppCompatActivity(), OnClick {
    private  val vmPost : PostViewModel by viewModels()
    private lateinit var rvPost : RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var progbar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progbar = findViewById(R.id.progbar)
        rvPost = findViewById(R.id.recyclerView)
        vmPost.getDatafromApi()
        var postObserver = Observer<ResourceFack<ListPost>>{
            when(it){
                is ResourceFack.Success<ListPost> -> {

                    Log.d("data",it.data.size.toString())
                    var dialog = AlertDialog.Builder(this)
                    dialog.setTitle("Hello World!!")
                    dialog.show()
                    progbar.visibility = View.INVISIBLE
                    postAdapter = PostAdapter(it.data)
                    postAdapter.click = this
                    rvPost.adapter = postAdapter
                    rvPost.layoutManager = LinearLayoutManager(this)
                }
                is ResourceFack.Loading<ListPost>-> {
                    progbar.visibility = View.VISIBLE
                }
                is ResourceFack.Error<ListPost>-> {
                    progbar.visibility = View.INVISIBLE
                    var dialog = AlertDialog.Builder(this)
                    dialog.setMessage(it.message)
                    dialog.setTitle("failed")
                    dialog.show()
                }

                else -> {}
            }
        }
        vmPost.postListstate.observe(this,postObserver)
        }

    override fun onClick(post: ListPostItem, holder: PostAdapter.PostHolder) {
        if (holder.subtitle.visibility == View.GONE)
            holder.subtitle.visibility = View.VISIBLE
        else holder.subtitle.visibility = View.GONE
    }
}



