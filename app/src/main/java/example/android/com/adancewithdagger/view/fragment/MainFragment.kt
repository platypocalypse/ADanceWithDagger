package example.android.com.adancewithdagger.view.fragment

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



class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        RxSearchView.queryTextChanges(searchView)
            .subscribe{ viewModel.searchTextChanged(it) }

//        viewModel.getHouses().observe(this, { } )

        housesRecyclerView.layoutManager = LinearLayoutManager(activity)
        housesRecyclerView.adapter = HousesAdapter(BiFunction{ t1,t2 -> t1.url == t2.url })
    }

    fun updateHousesList(houses: List<HouseDto>) {
        (housesRecyclerView.adapter as HousesAdapter).swap(houses)
    }

}
