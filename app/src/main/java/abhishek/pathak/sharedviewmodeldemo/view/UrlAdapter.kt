package abhishek.pathak.sharedviewmodeldemo.view

import abhishek.pathak.sharedviewmodeldemo.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UrlAdapter(private val urls: List<String>, private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<UrlAdapter.UrlViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrlViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_url, parent, false)
        return UrlViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UrlViewHolder, position: Int) {
        val url = urls[position]
        holder.bind(url)
    }

    override fun getItemCount(): Int {
        return urls.size
    }

    inner class UrlViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewUrl: TextView = itemView.findViewById(R.id.textViewUrl)

        fun bind(url: String) {
            textViewUrl.text = url
            itemView.setOnClickListener {
                itemClickListener.onItemClick(url)
            }
        }
    }
}
