package ru.sb066coder.sferaedu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.databinding.FirstRowPhotoLayoutBinding
import ru.sb066coder.sferaedu.databinding.MomentsItemLayoutBinding

class MomentsPhotoAdapter : RecyclerView.Adapter<MomentsViewHolder>() {

    private val photos: List<String> = listOf(
        "https://i.pinimg.com/originals/f8/6c/ee/f86ceeb6e27fe6c42ab148cce499434d.jpg",
        "https://storage.ws.pho.to/s2/69ea06791aed986a14c60ed1f2435de6e9811ded_m.gif",
        "https://burnqueue.files.wordpress.com/2011/02/elf_cosmetic_beauty.jpg",
        "https://jigidi-images.s3.amazonaws.com/puzzles/1MY150O63AA8CGET.jpg",
        "https://i.pinimg.com/736x/6d/45/f5/6d45f56358650110376808273dc45a71.jpg",
        "https://i.pinimg.com/originals/ef/72/eb/ef72eb8a95f9f3cf6e9e1457466fb009.png"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentsViewHolder {
        val binding = MomentsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MomentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MomentsViewHolder, position: Int) {
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

class MomentsViewHolder(val binding: MomentsItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)
