package ru.sb066coder.sferaedu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.javafaker.Faker
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.databinding.PeopleItemLayoutBinding
import kotlin.random.Random

class PeopleAdapter : RecyclerView.Adapter<PeopleViewHolder>() {

    private val avatars = listOf(
        "https://placepic.ru/wp-content/uploads/2021/03/women-model-face-portrait-wallpaper-preview-600x400.jpg",
        "https://img1.goodfon.ru/original/320x240/d/47/devushka-lico-gubki-vzglyad.jpg",
        "https://img2.goodfon.ru/original/640x960/1/25/kenze-thomas-devushka-seksi-2809.jpg",
        "https://i.pinimg.com/736x/44/44/ef/4444ef31006cf2dc018cf517da44c7a3--boy-models-handsome-faces.jpg",
        "https://static10.vivoo.ru/datas/photos/240x160/8c/de/584c13f3a4f63d2470556008ede4.jpg?0",
        "https://www.stitch.su/images/patterns/small/15712.jpg",
        "https://i.ytimg.com/vi/XS6GmEfrk0A/hqdefault.jpg",
        "https://i.pinimg.com/236x/3c/cb/ab/3ccbabc36791644fb16c93dd8cf4c8bd--glimmer-angelina-jolie.jpg",
        "https://sun9-82.userapi.com/impg/HAEZKRkz7jN5q_IQx9sYhqRzzafAETynHYcNcA/OJCU6DTZmrM.jpg?size=130x130&quality=96&sign=ff528998481ea218776590404fc0b45c&c_uniq_tag=UelZaaNAK7pUFqive2TNKXEY9G-NRUuhbswKKHMRH9M&type=album",
        "https://i.pinimg.com/280x280_RS/17/42/08/1742089b8ab1ad395f41122b3c5ded56.jpg"
    )
    private val faker = Faker()
    private val people = mutableListOf<Person>()
    init {
        repeat(40) {
            people.add(Person(
                avatar = avatars[Random.nextInt(0, 10)],
                name = faker.funnyName().name(),
                subscribed = false
            ))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = PeopleItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = people[position]
        with(holder.binding) {
            if (person.avatar.isNotBlank()) {
                Glide.with(ivAvatar.context)
                    .load(person.avatar)
                    .placeholder(R.drawable.ic_not_found_image)
                    .into(ivAvatar)
            } else {
                ivAvatar.setImageResource(R.drawable.ic_not_found_image)
            }
            tvName.text = person.name
            tvSubscribe.isChecked = person.subscribed
            if (person.subscribed) {
                tvSubscribe.text = "Unsubscribe"
            } else {
                tvSubscribe.text = "Subscribe"
            }
            tvSubscribe.setOnClickListener {
                person.subscribed = !person.subscribed
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return people.size
    }

}

data class Person (
    val avatar: String,
    val name: String,
    var subscribed: Boolean
        )

class PeopleViewHolder(val binding: PeopleItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
