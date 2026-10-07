package lat.pam.profil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lat.pam.profil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameExtra = intent.getStringExtra("EXTRA_USERNAME")
        if (!usernameExtra.isNullOrEmpty()) {
            binding.tvWelcome.text = getString(R.string.welcome_message, usernameExtra)
        } else {
            binding.tvWelcome.text = getString(R.string.welcome_message_default)
        }

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
