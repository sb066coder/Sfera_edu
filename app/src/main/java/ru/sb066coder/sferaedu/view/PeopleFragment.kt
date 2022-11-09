package ru.sb066coder.sferaedu.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.adapter.TabsAdapter
import ru.sb066coder.sferaedu.databinding.PeopleFragmentBinding
import ru.sb066coder.sferaedu.viewmodel.PeopleViewModel

class PeopleFragment : Fragment(R.layout.people_fragment) {

    val viewModel: PeopleViewModel by activityViewModels()

    private val tabNames = listOf("SUBSCRIBERS", "SUBSCRIPTIONS", "MUTUALLY")

    private lateinit var binding: PeopleFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tabsAdapter = TabsAdapter(this)
        binding = PeopleFragmentBinding.bind(view)

        binding.viewPager.adapter = tabsAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
        val searchView = binding.topAppBar.menu.findItem(R.id.action_search).actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchText.value = newText
                return true
            }

        })

    }

}