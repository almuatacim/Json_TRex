package ly.raqam.json_trex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ly.raqam.json_trex.data.model.ListPostItem

class PostAdapter(var postlist : ArrayList<ListPostItem>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    class PostHolder(post : View) : RecyclerView.ViewHolder(post){
        var title : TextView = post.findViewById(R.id.titletxt)
        var subtitle : TextView = post.findViewById(R.id.subtitletxt)
    }

    var click : OnClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        var currentpost = LayoutInflater.from(parent.context).inflate(R.layout.postitem,parent,false)
        return PostHolder(currentpost)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.title.text = postlist[position].title
        holder.subtitle.text = postlist[position].body
        holder.itemView.setOnClickListener {
            click?.onClick(postlist[position],holder)
        }
    }
}
interface OnClick{
    fun onClick(post : ListPostItem , holder: PostAdapter.PostHolder)
}