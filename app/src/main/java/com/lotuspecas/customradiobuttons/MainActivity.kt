package com.lotuspecas.customradiobuttons

import android.os.Bundle
import android.view.Gravity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lotuspecas.customradiobuttons.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
    }

    private fun initViews() {

        // Toasty ayarları
        Toasty.Config.getInstance().tintIcon(true).setTextSize(34).setGravity(Gravity.BOTTOM)
            .allowQueue(
                true
            ).apply()


        // Default olarak elma seçili
        binding.rbMeyveler.check(R.id.rbElma)

        binding.rbMeyveler.setOnCheckedChangeListener { radioGroup, optionId ->

            // Seçilen radio butonun id'sini al
            when (optionId) {
                R.id.rbElma -> {
                    Toasty.success(this@MainActivity, "Elma seçildi", Toasty.LENGTH_SHORT, true)
                        .show()
                }

                R.id.rbArmut -> {
                    Toasty.success(this, "Armut seçildi", Toasty.LENGTH_SHORT, true).show()
                }

                R.id.rbMuz -> {
                    Toasty.success(this, "Muz seçildi", Toasty.LENGTH_SHORT, true).show()
                }

                R.id.rbKiraz -> {
                    Toasty.success(this, "Kiraz seçildi", Toasty.LENGTH_SHORT, true).show()
                }

                R.id.rbUzum -> {
                    Toasty.success(this, "Üzüm seçildi", Toasty.LENGTH_SHORT, true).show()
                }
            }
        }

    }


}