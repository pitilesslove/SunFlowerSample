package com.example.sunflowersample;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.example.sunflowersample.databinding.ActivityGardenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Displaying edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)
    }
}