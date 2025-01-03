package com.fanntt.dbsqllite_fanntt.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fanntt.dbsqllite_fanntt.R
import com.fanntt.dbsqllite_fanntt.databinding.ActivityTambahDataMahasiswaBinding
import com.fanntt.dbsqllite_fanntt.dbhelper.helper
import com.fanntt.dbsqllite_fanntt.model.ModelMahasiswa

class TambahDataMahasiswa : AppCompatActivity() {

    //binding : cara ringkas untuk deklarasi variabel dan widget
        private lateinit var  binding : ActivityTambahDataMahasiswaBinding
        private lateinit var db : helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTambahDataMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        db = helper(this)
        binding.btnTambahData.setOnClickListener(){
            val nama = binding.txtInputNama.text.toString()
            val nim = binding.txtInputNIM.text.toString()

            val dataMahasiswa = ModelMahasiswa(0,nama,nim.toInt(),"Teknik Komputer")
            db.insertDataMahasiswa(dataMahasiswa)
            finish();
            Toast.makeText(this, "Berhasil Tambah Data", Toast.LENGTH_SHORT).show()
        }
    }
}