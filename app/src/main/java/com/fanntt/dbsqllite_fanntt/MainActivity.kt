package com.fanntt.dbsqllite_fanntt

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fanntt.dbsqllite_fanntt.adapter.mahasiswaAdapter
import com.fanntt.dbsqllite_fanntt.databinding.ActivityMainBinding
import com.fanntt.dbsqllite_fanntt.dbhelper.helper
import com.fanntt.dbsqllite_fanntt.model.ModelMahasiswa
import com.fanntt.dbsqllite_fanntt.screen_page.TambahDataMahasiswa

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var db : helper
    private lateinit var mahasiswaAdapter: mahasiswaAdapter
    private var mahasiswaList = mutableListOf<ModelMahasiswa>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = helper (this)
        mahasiswaAdapter = mahasiswaAdapter(db.getalldataMahasiswa(),this,)

        binding.rvDataMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvDataMahasiswa.adapter = mahasiswaAdapter


        //silahkan buat


        binding.btntambahdata.setOnClickListener(){
            val intent = Intent(this,TambahDataMahasiswa::class.java)
            startActivity(intent)
        }




    }
    override fun onResume () {
        super.onResume()
        val newMahasiswa = db.getalldataMahasiswa()
        mahasiswaAdapter.refreshData(newMahasiswa)
    }
}