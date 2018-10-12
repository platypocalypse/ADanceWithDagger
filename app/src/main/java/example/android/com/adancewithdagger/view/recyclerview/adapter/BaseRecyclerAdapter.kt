package example.android.com.adancewithdagger.view.recyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable

import java.util.ArrayList
import java.util.function.BiFunction

abstract class BaseRecyclerAdapter<T>
    constructor(private val isSame: BiFunction<T, T, Boolean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val values = ArrayList<T>()

    private val clicksRelay = PublishRelay.create<Pair<Int, T>>()

    fun getCloneOfValues(): List<T> {
        val items = ArrayList<T>()
        items.addAll(values)
        return items
    }

    fun getClicks(): Observable<Pair<Int, T>> = clicksRelay

    override fun getItemCount(): Int {
        return values.size
    }

    fun swap(newValues: List<T>) {
        val diffResult = DiffUtil.calculateDiff(createElementsDiffCallback(newValues), true)
        values.clear()
        values.addAll(newValues)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun createElementsDiffCallback(newValues: List<T>): DiffUtil.Callback {
        return object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = values.size

            override fun getNewListSize(): Int = newValues.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = isSame.apply(values[oldItemPosition], newValues[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = values[oldItemPosition] == newValues[newItemPosition]
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val element = values[position]
        RxView.clicks(holder.itemView)
            .map{ Pair(holder.adapterPosition, element) }
            .subscribe(clicksRelay)
        onBindViewHolder(holder, position, element)
    }

    protected abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, element: T)

    protected fun getPosition(position: Int): T {
        return values[position]
    }
}