package com.kismiwati.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kismiwati.myapplication.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         //Method binding dibawah ini digunakan untuk menampilkan layout activity_main
         //layout inflate digunakan untuk menghubungkan main_activity dengan sub activity yaitu bagian kecil dari activity
         //inflate digunakan untuk memanggil widget pada activity_main
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         //method setOnClickListener digunakan user untuk selalu mendengarkan klik dari user pada objek button. dan akan menampilkan jika Button di-klik
         binding.btnLogin.setOnClickListener { cekLog() }
     }

     private fun cekLog() {
         // method toString digunakan untuk merubah nilai type data menjadi type data string.
         val namaPengguna = binding.teksPengguna.text.toString()
         val passwordPengguna = binding.teksPassword.text.toString()
         //method isEmpty digunakan untuk mengecek kondisi pada variabel type string
         //if else digunakan untuk memerikasa atau mengecek kondisi yang diisikan apakah sudah sesuai atau belum. jika sudah benar maka akan menampilkan toast.
         if (namaPengguna.isEmpty() || passwordPengguna.isEmpty()) {
             //method toast.makeText digunakan untuk membuat objek toast yang berisi pesan dibawah ini
             Toast.makeText(this, "Mohon masukkan nama dan password", Toast.LENGTH_SHORT).show()
             return
         }
         if(namaPengguna == "kismiwati" && passwordPengguna == "010902"){
             val intent = Intent(this, MasukActivity::class.java)

             intent.putExtra("nama_pengguna", binding.teksPengguna.text.toString())
             //startActivity digunakan untuk menjalankan activity melalui intent
             startActivity(intent)

             //else digunakan untuk memberikan komentar jika Nama pengguna dan password yang dimasukkan salah
         }else{
             Toast.makeText(this, "Nama dan Password yang dimasukkan salah.", Toast.LENGTH_SHORT).show()
             return
         }


     }
}