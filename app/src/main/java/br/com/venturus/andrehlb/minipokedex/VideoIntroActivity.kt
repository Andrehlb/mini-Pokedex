package br.com.venturus.andrehlb.minipokedex

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoIntroActivity : AppCompatActivity() {
    private val TAG = "VideoIntroActivity"
    private lateinit var videoView: VideoView
    private val VIDEO_DURATION_MS = 4000L // 4 segundos
    private var hasNavigated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_intro)

        videoView = findViewById(R.id.videoView)

        // Configura o vídeo MP4 do diretório raw
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.intro_video)
        videoView.setVideoURI(videoUri)

        // Configura listener para quando o vídeo terminar
        videoView.setOnCompletionListener {
            Log.d(TAG, "Vídeo completado, navegando para MainActivity")
            navigateToMainActivity()
        }

        // Configura listener para erros de reprodução
        videoView.setOnErrorListener { _, what, extra ->
            Log.e(TAG, "Erro ao reproduzir vídeo: what=$what, extra=$extra")
            // Se houver erro, navega imediatamente para MainActivity
            navigateToMainActivity()
            true
        }

        // Inicia a reprodução do vídeo
        videoView.start()
        Log.d(TAG, "Reprodução do vídeo iniciada")

        // Failsafe: garante navegação após 4 segundos mesmo se o vídeo não completar
        Handler(Looper.getMainLooper()).postDelayed({
            if (!hasNavigated) {
                Log.d(TAG, "Timeout de 4 segundos atingido, navegando para MainActivity")
                navigateToMainActivity()
            }
        }, VIDEO_DURATION_MS)
    }

    private fun navigateToMainActivity() {
        if (hasNavigated) {
            return
        }
        hasNavigated = true
        
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
    }

    override fun onResume() {
        super.onResume()
        if (!hasNavigated) {
            videoView.start()
        }
    }
}
