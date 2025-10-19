package br.com.venturus.andrehlb.minipokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        // Installs the splash screen. This must be called before super.onCreate()
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(tag, "onCreate chamado")
        binding.searchEditText.requestFocus()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            Log.d(tag, "Padding aplicado")
            v.setPadding(
                systemBars.left,
                systemBars.top * 2,
                systemBars.right,
                systemBars.bottom * 2
            )
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart chamado")
    }
}