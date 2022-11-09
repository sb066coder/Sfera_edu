package ru.sb066coder.sferaedu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.adapter.PeopleAdapter
import ru.sb066coder.sferaedu.adapter.Person
import ru.sb066coder.sferaedu.databinding.PlaceholderFragmentBinding
import ru.sb066coder.sferaedu.viewmodel.PeopleViewModel

class PlaceholderFragment(private val position: Int) : Fragment() {

    val viewModel: PeopleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.placeholder_fragment, container, false)
    }

    private lateinit var binding: PlaceholderFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PlaceholderFragmentBinding.bind(view)

        val adapter = PeopleAdapter(
            object : OnSubscribeListener {
                override fun onSubscribe(person: Person) {
                    viewModel.subscribeById(position, person.id)
                }
            }
        )

        binding.rvPeople.adapter = adapter

        when (position) {
            0 -> {
                viewModel.data01.observe(viewLifecycleOwner) { people01 ->
                    adapter.submitList(people01)
                }
            }
            1 -> {
                viewModel.data02.observe(viewLifecycleOwner) { people02 ->
                    adapter.submitList(people02)
                }
            }
            else -> {
                viewModel.data03.observe(viewLifecycleOwner) { people03 ->
                    adapter.submitList(people03)
                }
            }
        }
        viewModel.searchText.observe(viewLifecycleOwner) {
            adapter.submitList(viewModel.searchData(position, it))
        }
    }
}