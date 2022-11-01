package ru.sb066coder.sferaedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sb066coder.sferaedu.adapter.ChroniclesPhotoAdapter
import ru.sb066coder.sferaedu.adapter.MomentsPhotoAdapter
import ru.sb066coder.sferaedu.adapter.ProfilePhotoAdapter
import ru.sb066coder.sferaedu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}