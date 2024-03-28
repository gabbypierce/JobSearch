package edu.quinnipiac.ser210.jobsearch


import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class RecycleAdapter(val context: Context,  var navController: NavController) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.bind(position)
    }

    inner class MyViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        private val job: Job?= null
        private val name: String? = job?.company_name.toString()
        //private val title: TextView = itemView!!.findViewById<TextView?>(R.id.jobTitle).text(name)

        //private val image: ImageView = itemView!!.findViewById(R.id.item_image)
        private var pos:Int = 0

        fun bind(position:Int){
            pos = position
            //val currHero = heroList.get(position)
            //title.text = currHero.name
            //title.text = "test"
        }

    }
}