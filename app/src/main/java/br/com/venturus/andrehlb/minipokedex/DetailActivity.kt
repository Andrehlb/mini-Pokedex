package br.com.venturus.andrehlb.minipokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
