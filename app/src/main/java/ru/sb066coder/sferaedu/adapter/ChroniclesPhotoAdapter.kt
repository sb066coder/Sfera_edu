package ru.sb066coder.sferaedu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.databinding.ChroniclesItemLayoutBinding
import ru.sb066coder.sferaedu.databinding.MomentsItemLayoutBinding

class ChroniclesPhotoAdapter : RecyclerView.Adapter<ChroniclesViewHolder>() {

    private val photos: List<String> = listOf(
        "https://sun9-4.userapi.com/c854416/v854416428/798ba/usXa6BPCDGw.jpg",
        "https://wallbox.ru/resize/640x960/wallpapers/main2/201706/more-plaz-palma-tropiki1.jpg",
        "https://i.pinimg.com/736x/8b/62/04/8b6204e299e94a996c2f3122960bee3c.jpg",
        "https://sun9-69.userapi.com/impg/F-x-VOvCK5XMJJr7BW4trHMGXuR6UKJEkeOEGw/kJ5tsOwd1Bc.jpg?size=492x604&quality=96&sign=badcc06ffcc698bd2e3674be8ac4c441&type=album",
        "https://i.pinimg.com/736x/b4/72/db/b472db6e59c4368db979c149c0ea2964.jpg",
        "https://i.pinimg.com/236x/87/f4/03/87f4035aac59183a71468494b58ae267.jpg?nii=t",
        "https://whatsism.com/uploads/posts/2021-09/1631902746_i.jpeg",
        "https://i.pinimg.com/236x/a0/58/15/a05815663e6c1f01f20e8f6cbd61542c.jpg",
        "https://i.pinimg.com/originals/6b/f1/61/6bf1610fb1dcd135575fe7fc9db74bd2.jpg",
        "https://interesnoe.site/wp-content/uploads/2019/05/2-12.jpg",
        "https://img3.goodfon.ru/original/320x400/1/ed/banff-national-park-canada-2489.jpg",
        "https://sun9-59.userapi.com/impf/lVatgQThQ3ODdCtaLbvVoQ_qBBurISXsbRevDQ/UfdfXVN7d3M.jpg?size=483x604&quality=96&sign=14c24fe73b3d0d8864a01e2fd47c8477&type=album",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesViewHolder {
        val binding = ChroniclesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChroniclesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChroniclesViewHolder, position: Int) {
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

class ChroniclesViewHolder(val binding: ChroniclesItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)
