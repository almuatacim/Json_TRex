package ly.raqam.json_trex.vmdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ly.raqam.json_trex.PostAdapter
import ly.raqam.json_trex.R
import ly.raqam.json_trex.vmdata.entity.UserEntity

class UserAdapter(var listUser : ArrayList<UserEntity>): RecyclerView.Adapter<UserAdapter.UserHolde>() {
    class UserHolde(view: View): RecyclerView.ViewHolder(view){
        var fname: TextView = view.findViewById(R.id.titletxt)
        var lname : TextView = view.findViewById(R.id.fiestnametxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolde {
        var currentUser = LayoutInflater.from(parent.context).inflate(R.layout.postitem,parent,false)
        return UserAdapter.UserHolde(currentUser)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: UserHolde, position: Int) {
        holder.fname.text = listUser[position].firstName
        holder.lname.text = listUser[position].lastName
    }
}