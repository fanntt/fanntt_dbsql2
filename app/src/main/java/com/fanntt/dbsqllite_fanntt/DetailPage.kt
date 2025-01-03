package com.fanntt.dbsqllite_fanntt

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPage : AppCompatActivity() {

    private lateinit var detailNama : TextView
    private lateinit var detailNIM : TextView
    private lateinit var detailJurusan : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)


        detailNama=findViewById(R.id.detailNama)
        detailNIM=findViewById(R.id.detailNIM)
        detailJurusan=findViewById(R.id.detailJurusan)

        //get data
        val Detailnama = intent.getStringExtra("nama")
        val Detailnim = intent.getIntExtra("nim",0).toString()
        val Detailjurusan = intent.getStringExtra("jurusan")


        //tampilkan
        detailNama.setText(Detailnama)
        detailNIM.setText(Detailnim)
        detailJurusan.setText(Detailjurusan)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}