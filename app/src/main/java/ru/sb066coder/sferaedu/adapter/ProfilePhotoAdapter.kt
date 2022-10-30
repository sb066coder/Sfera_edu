package ru.sb066coder.sferaedu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.databinding.FirstRowPhotoLayoutBinding

class ProfilePhotoAdapter : RecyclerView.Adapter<ProfilePhotoViewHolder>() {

    private val photos: List<String> = listOf(
        "https://i.pinimg.com/736x/d9/25/5f/d9255f28fdadb0f155b17a1a55fc80a6.jpg",
        "https://javasea.ru/uploads/posts/2020-11/1606298259_mega-drakon2.jpg",
        "https://i.pinimg.com/originals/50/df/09/50df09647e7c536a2c0735ca535fecb9.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/01/img_600d8a9bb79ef.jpg"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePhotoViewHolder {
        val binding = FirstRowPhotoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfilePhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfilePhotoViewHolder, position: Int) {
        val photo = photos[position]
        with(holder.binding) {
            if (photo.isNotBlank()) {
                Glide.with(image.context)
                    .load(photo)
                    .placeholder(R.drawable.ic_not_found_image)
                    .into(image)
            } else {
                image.setImageResource(R.drawable.ic_not_found_image)
            }
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

}

class ProfilePhotoViewHolder(val binding: FirstRowPhotoLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)
