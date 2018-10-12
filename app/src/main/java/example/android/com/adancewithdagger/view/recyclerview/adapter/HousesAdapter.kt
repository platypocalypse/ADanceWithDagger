package example.android.com.adancewithdagger.view.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.android.com.adancewithdagger.data.model.HouseDto
import java.util.function.BiFunction

class HousesAdapter(func: BiFunction<HouseDto, HouseDto, Boolean>) : BaseRecyclerAdapter<HouseDto>(func) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, element: HouseDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}