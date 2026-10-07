package lat.pam.profil

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lat.pam.profil.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        private const val VALID_USERNAME = "gnaliggg"
        private const val VALID_PASSWORD = "barnburning"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            binding.tilUsername.error = null
            binding.tilPassword.error = null

            if (username.isEmpty()) {
                binding.tilUsername.error = getString(R.string.error_empty_fields)
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = getString(R.string.error_empty_fields)
                return@setOnClickListener
            }

            if ((username != VALID_USERNAME) || (password != VALID_PASSWORD)) {
                val errorMessage = getString(R.string.error_invalid_credentials)
                binding.tilPassword.error = errorMessage
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Successful login, navigate to MainActivity using Intent
            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("EXTRA_USERNAME", username)
            }
            startActivity(intent)
            finish()
        }
    }
}
