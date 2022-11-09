package ru.sb066coder.sferaedu.view

import androidx.recyclerview.widget.DiffUtil
import ru.sb066coder.sferaedu.adapter.Person

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Person, newItem: Person): Any? {
        return if (oldItem.subscribed != newItem.subscribed) true else null
    }
}
