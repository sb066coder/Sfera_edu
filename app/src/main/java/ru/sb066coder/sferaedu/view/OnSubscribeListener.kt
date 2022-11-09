package ru.sb066coder.sferaedu.view

import ru.sb066coder.sferaedu.adapter.Person

interface OnSubscribeListener {
    fun onSubscribe(person: Person) {}
}