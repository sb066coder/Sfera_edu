package ru.sb066coder.sferaedu.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.adapter.PeopleAdapter
import ru.sb066coder.sferaedu.databinding.PeopleFragmentBinding

class PeopleFragment : Fragment(R.layout.people_fragment) {

    private lateinit var binding: PeopleFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PeopleFragmentBinding.bind(view)

        binding.rvPeople.adapter = PeopleAdapter()
    }
}