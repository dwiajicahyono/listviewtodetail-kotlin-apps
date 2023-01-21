package com.provinsi.sumatra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.provinsi.sumatra.databinding.ActivityDetailedBinding


class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val area = intent.getStringExtra("area")
            val populasi = intent.getIntExtra("populasi", R.string.populasiAceh)
            val desc = intent.getIntExtra("desc", R.string.acehDesc)
            val image = intent.getIntExtra("image", R.drawable.aceh)

            binding.detailName.text = name
            binding.detailArea.text = area
            binding.detailDesc.setText(desc)
            binding.populasi.setText(populasi)
            binding.detailImage.setImageResource(image)
        }
    }
}