package com.kismiwati.myapplication


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kismiwati.myapplication.databinding.ActivityMasukBinding


class MasukActivity : AppCompatActivity() {
    var idPengguna = ""

    //componion object untuk medeklarasikan objek kelas web_prefix
    companion object {

        const val WEB_PREFIX = "https://github.com/Kismiwati"
    }

    //onCreate digunakan untuk menginisialisasikan Activity pada kondisi awal
    //saveInstanceState merupakan objek bundle yang berisi status yang sebelumnya disimpan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tombolGithub.setOnClickListener { cekIg() }
        binding.tombolUser.setOnClickListener { tmlWisata() }
    }

    private fun cekIg() {
        // menggunakan intent implisit yang digunakan untuk menjembatani atau menghubungkan interaksi antar Activitimain dan masuk activity
        // dengan variabel queryUrl, data didalamnya web_prefix + idPengguna
        val queryUrl: Uri = Uri.parse(WEB_PREFIX)
        // digunakan untuk menyiapkan variabel intent dengan menggunakan parameter
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // startActivity digunakan untuk mengaktifkan intent
        startActivity(intent)

    }

    private fun tmlWisata(){
        val intentWisata = Intent(this, WisataActivity::class.java)
        // startActivity digunakan untuk mengaktifkan intentWisata
        startActivity(intentWisata)
    }
}