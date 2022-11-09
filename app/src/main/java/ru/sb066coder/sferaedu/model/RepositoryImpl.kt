package ru.sb066coder.sferaedu.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.javafaker.Faker
import ru.sb066coder.sferaedu.adapter.Person
import kotlin.random.Random

class RepositoryImpl : Repository {

    // Start list creation
    private var lastId: Long = 0L

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
    private var people01 = randomListFill(40)
    private var people02 = randomListFill(20)
    private var people03 = randomListFill(20)

    private val data01: MutableLiveData<List<Person>> = MutableLiveData(people01)
    private val data02: MutableLiveData<List<Person>> = MutableLiveData(people02)
    private val data03: MutableLiveData<List<Person>> = MutableLiveData(people03)

    override fun getAll(listNumber: Int): LiveData<List<Person>> {
        return when (listNumber) {
            0 -> data01
            1 -> data02
            else -> data03
        }
    }

    override fun getSearchList(listNumber: Int, text: String): List<Person> {
        return when (listNumber) {
            0 -> { people01.filter { person -> person.name.contains(text, true) } }
            1 -> { people02.filter { person -> person.name.contains(text, true) } }
            else -> { people03.filter { person -> person.name.contains(text, true) } }
        }
    }

    override fun subscribeById(listNumber: Int, id: Long) {
        when (listNumber) {
            0 -> {
                people01 = people01.map { if (it.id != id) it else it.copy(subscribed = !it.subscribed) }
                data01.value = people01
            }
            1 -> {
                people02 = people02.map { if (it.id != id) it else it.copy(subscribed = !it.subscribed) }
                data02.value = people02
            }
            else -> {
                people03 = people03.map { if (it.id != id) it else it.copy(subscribed = !it.subscribed) }
                data03.value = people03
            }
        }
    }

    private fun randomListFill(i: Int): List<Person> {
        val mList = mutableListOf<Person>()
        repeat(i) { mList.add(
            Person(
                id = ++lastId,
                avatar = avatars[Random.nextInt(0, avatars.size)],
                name = faker.funnyName().name(),
                subscribed = Random.nextBoolean()
            )
        ) }
        return mList.toList()
    }

}