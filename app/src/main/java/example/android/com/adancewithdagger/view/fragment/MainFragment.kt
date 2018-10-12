package example.android.com.adancewithdagger.view.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import example.android.com.adancewithdagger.R
import example.android.com.adancewithdagger.view.recyclerview.adapter.BaseRecyclerAdapter
import example.android.com.adancewithdagger.view.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

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

//        activity.searchView.setOnQueryTextListener

        activity.housesRecyclerView.layoutManager = LinearLayoutManager(activity)
        activity.housesRecyclerView.adapter = BaseRecyclerAdapter()
    }

}
