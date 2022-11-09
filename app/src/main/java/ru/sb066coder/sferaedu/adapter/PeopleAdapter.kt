package ru.sb066coder.sferaedu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.sb066coder.sferaedu.R
import ru.sb066coder.sferaedu.databinding.PeopleItemLayoutBinding
import ru.sb066coder.sferaedu.view.OnSubscribeListener
import ru.sb066coder.sferaedu.view.PersonDiffCallback

class PeopleAdapter(
    private val onSubscribeListener: OnSubscribeListener
) : ListAdapter<Person, PeopleViewHolder>(PersonDiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = PeopleItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding, onSubscribeListener)
    }

    override fun onBindViewHolder(
        holder: PeopleViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads[0] == true) {
                holder.bindSubscribedState(getItem(position).subscribed)
            }
        }
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }
}

data class Person(
    val id: Long,
    val avatar: String,
    val name: String,
    var subscribed: Boolean
        )

class PeopleViewHolder(
    private val binding: PeopleItemLayoutBinding,
    private val onSubscribeListener: OnSubscribeListener
) : RecyclerView.ViewHolder(binding.root) {
    private val context : Context = binding.root.context
    fun bind(person: Person) {
        binding.apply {
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
                tvSubscribe.text = context.getString(R.string.unsubscribe)
            } else {
                tvSubscribe.text = context.getString(R.string.subscribe)
            }
            tvSubscribe.setOnClickListener {
                onSubscribeListener.onSubscribe(person)
            }
        }
    }
    
    fun bindSubscribedState(state: Boolean) {
        binding.tvSubscribe.isChecked = state
        if (state) {
            binding.tvSubscribe.text = context.getString(R.string.unsubscribe)
        } else {
            binding.tvSubscribe.text = context.getString(R.string.subscribe)
        }
    }
}
