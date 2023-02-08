package ly.raqam.json_trex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ly.raqam.json_trex.room.AppDatabase
import ly.raqam.json_trex.vmdata.UserViewModel
import ly.raqam.json_trex.vmdata.core.Resource
import ly.raqam.json_trex.vmdata.core.baserepostry.localUserRepostryImp
import ly.raqam.json_trex.vmdata.entity.UserEntity

class RoomActivity : AppCompatActivity() {
    private val vmUser: UserViewModel by viewModels()
    private lateinit var fnametxt: EditText
    private lateinit var lnametxt: EditText
    private lateinit var citytxt: EditText
    private lateinit var countrytxt: EditText
//    private lateinit var idtxt: EditText
    private lateinit var addbtn: Button
    private lateinit var showbtn: Button
    private lateinit var showtxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        AppDatabase.initDb(this)

        fnametxt = findViewById(R.id.fiestnametxt)
        lnametxt = findViewById(R.id.lastnametxt)
        addbtn = findViewById(R.id.addbtn)
        showbtn = findViewById(R.id.showbtn)
        showtxt = findViewById(R.id.viewtxt)
        citytxt = findViewById(R.id.citytxt)
        countrytxt = findViewById(R.id.countrytxt)
//        idtxt = findViewById(R.id.idtxt)
        var temp =""
        val observer = Observer<Resource<List<UserEntity>>> {
            when (it) {
                is Resource.Success<List<UserEntity>> -> {
                    for (i in 0.. it.data.lastIndex){
                        temp += "${it.data[i].uid.toString()}\n"
                    }
                    showtxt.text = temp

                }
                else ->{}
            }
        }
        vmUser.state.observe(this, observer)

        vmUser.getUsers()





        /*val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        ).build()
        val userDao = db.userDao()
        var users: List<UserDatabase>? = null*/
        /*GlobalScope.launch {
            var repostry = localUserRepostryImp()
            repostry.insertUser(UserEntity(uid = 12, firstName = "ss", lastName = "kkk",city = "benghazi", country = "Libya",))
            repostry.getallUser().onEach {
                when(it){
                    is Resource.Success<List<UserEntity>> ->{
                        showtxt.text = it.data!!.first().firstName
                    }
                    else ->{}
                }
            }
*/
        /*userDao.insertAll(UserDatabase(firstName = "almuatacim", lastName = "hamouda", uid = 1,
                city = "Benghazi", country = "Libya"
            ))
//            users = userDao.getAll()*/
//    }


        addbtn.setOnClickListener {

                 vmUser.insertUser(UserEntity(uid = 0, firstName = fnametxt.text.toString(),
                 lastName = lnametxt.text.toString(), city = citytxt.text.toString(), country = countrytxt.text.toString()))
                  vmUser.getUsers()
//            GlobalScope.launch {
//                launch(Dispatchers.) {  }
//            var repostry = localUserRepostryImp()
//            repostry.insertUser(UserEntity(uid = 12, firstName = fnametxt.text.toString(), lastName = lnametxt.text.toString(),city = "benghazi", country = "Libya",))
//                vmUser.getUsers()
//            }


        }


        showbtn.setOnClickListener() {
            vmUser.deleteUser(countrytxt.text.toString().toInt())
            vmUser.getUsers()
            //vmUser.getUsers()
            /*showtxt.text = "${users?.size.toString()}\n${users?.size.toString()}"
            var temp = ""
            for (user in users!!) {

                temp = temp + "\n" + user.firstName
            }

            showtxt.text = temp
            showtxt.text = "${ users.firstName }\t${ users.lastName }\n"*/
        }

    }

}