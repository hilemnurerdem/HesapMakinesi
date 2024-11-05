package com.example.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Binding nesnesi
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewCompat kullanımı
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sayisec(view: View) {
        if (yenioperator) {
            binding.Sonuc.text = ""
        }
        yenioperator = false
        val butonsec = view as Button
        var butondeger: String = binding.Sonuc.text.toString()

        when (butonsec.id) {
            binding.sifir.id -> butondeger += "0"
            binding.bir.id -> butondeger += "1"
            binding.iki.id -> butondeger += "2"
            binding.uc.id -> butondeger += "3"
            binding.dort.id -> butondeger += "4"
            binding.bes.id -> butondeger += "5"
            binding.alti.id -> butondeger += "6"
            binding.yedi.id -> butondeger += "7"
            binding.sekiz.id -> butondeger += "8"
            binding.dokuz.id -> butondeger += "9"
        }
        binding.Sonuc.text = butondeger
    }

    var operator = ""
    var eskisayi = ""
    var yenioperator = true

    fun islem(view: View) {
        val islemsec = view as Button
        when (islemsec.id) {
            binding.carpim.id -> operator = "*"
            binding.bolu.id -> operator = "/"
            binding.arti.id -> operator = "+"
            binding.eksi.id -> operator = "-"
        }
        eskisayi = binding.Sonuc.text.toString()
        yenioperator = true
    }

    fun esittir(view: View) {
        val yenisayi = binding.Sonuc.text.toString()
        var islemsonucu: Double? = null
        when (operator) {
            "*" -> islemsonucu = eskisayi.toDouble() * yenisayi.toDouble()
            "/" -> islemsonucu = eskisayi.toDouble() / yenisayi.toDouble()
            "-" -> islemsonucu = eskisayi.toDouble() - yenisayi.toDouble()
            "+" -> islemsonucu = eskisayi.toDouble() + yenisayi.toDouble()
        }
        binding.Sonuc.text = islemsonucu.toString()
        yenioperator = true
    }

    fun ac(view: View) {
        binding.Sonuc.text = ""
        yenioperator = true
    }
}
