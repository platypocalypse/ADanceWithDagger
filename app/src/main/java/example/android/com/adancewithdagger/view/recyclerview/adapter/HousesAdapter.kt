package example.android.com.adancewithdagger.view.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.android.com.adancewithdagger.R
import example.android.com.adancewithdagger.data.model.HouseDto
import kotlinx.android.synthetic.main.viewholder_house.view.*
import java.util.function.BiFunction

class HousesAdapter(func: BiFunction<HouseDto, HouseDto, Boolean>) : BaseRecyclerAdapter<HouseDto>(func) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_house, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, house: HouseDto) {
        holder.itemView.nameText.text = house.name
    }
}