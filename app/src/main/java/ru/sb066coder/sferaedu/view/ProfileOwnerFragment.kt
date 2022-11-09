package ru.sb066coder.sferaedu.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.adapter.ChroniclesPhotoAdapter
import ru.sb066coder.sferaedu.adapter.MomentsPhotoAdapter
import ru.sb066coder.sferaedu.adapter.ProfilePhotoAdapter
import ru.sb066coder.sferaedu.databinding.ProfileOwnerFragmentBinding

class ProfileOwnerFragment : Fragment(R.layout.profile_owner_fragment) {

    private lateinit var binding: ProfileOwnerFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ProfileOwnerFragmentBinding.bind(view)

        binding.rvProfilePhotos.adapter = ProfilePhotoAdapter()
        binding.rvMoments.adapter = MomentsPhotoAdapter()
        binding.rvChronicles.adapter = ChroniclesPhotoAdapter()
        binding.rvChronicles.suppressLayout(true)

        binding.btnPeople.setOnClickListener {
            findNavController().navigate(R.id.action_profileOwnerFragment_to_peopleFragment)
        }
    }

}