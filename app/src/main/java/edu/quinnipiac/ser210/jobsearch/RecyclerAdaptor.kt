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

    class RecyclerAdapter(val context: Context,  var navController: NavController) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {



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

            private val title: TextView = itemView!!.findViewById(R.id.jobTitle)
            //private val image: ImageView = itemView!!.findViewById(R.id.item_image)
            private var pos:Int = 0

            fun bind(position:Int){
                pos = position
                //val currHero = heroList.get(position)
                //title.text = currHero.name
                title.text = "test"
            }

        }
    }
