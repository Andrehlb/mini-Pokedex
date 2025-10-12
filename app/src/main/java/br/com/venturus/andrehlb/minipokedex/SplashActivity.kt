package br.com.venturus.andrehlb.minipokedex

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // vai criar activity_splash.xml com a logo

        Handler (Looper.getMinLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // para fechar a SplashActivity e não voltar para ela ao pressionar o botão de voltar
        }, 2000) // 2000 milissegundos = 2 segundos de delay
    }
}