package example.android.com.adancewithdagger.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.RxSearchView
import example.android.com.adancewithdagger.R
import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.view.recyclerview.adapter.HousesAdapter
import example.android.com.adancewithdagger.view.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.function.BiFunction
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import example.android.com.adancewithdagger.MyApplication


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context?) {
        MyApplication.get().component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MyApplication.get().component.inject(this)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        RxSearchView.queryTextChanges(searchView)
            .subscribe{ viewModel.searchTextChanged(it) }

        viewModel.getHouses().observe(this, Observer { updateHousesList(it) } )

        housesRecyclerView.layoutManager = LinearLayoutManager(activity)
        housesRecyclerView.adapter = HousesAdapter(BiFunction{ t1,t2 -> t1.url == t2.url })
    }

    fun updateHousesList(houses: List<HouseDto>) {
        (housesRecyclerView.adapter as HousesAdapter).swap(houses)
    }

}
