package com.fanntt.dbsqllite_fanntt.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ThemedSpinnerAdapter.Helper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fanntt.dbsqllite_fanntt.R
import com.fanntt.dbsqllite_fanntt.databinding.ActivityUpdateNoteBinding
import com.fanntt.dbsqllite_fanntt.dbhelper.helper
import com.fanntt.dbsqllite_fanntt.model.ModelMahasiswa

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateNoteBinding
    private lateinit var db : helper
    private  var mhsId : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = helper(this)

        mhsId = intent.getIntExtra("id_mhs",-1)
        if(mhsId == -1){
            finish()
            return
        }
        // proses menampilkan data ke edit text di edit view

        val mhs = db.getMhsbyId(mhsId)
        binding.etEditNama.setText(mhs.nama)
        binding.etEditNIM.setText(mhs.nim.toString())
        binding.etEditJurusan.setText(mhs.jurusan)

        //update dari button
        binding.btnEditNote.setOnClickListener(){
            val newNama = binding.etEditNama.text.toString()
            val newNIM = binding.etEditNIM.text.toString()
            val newJurusan = binding.etEditJurusan.text.toString()

            val updatedMhs = ModelMahasiswa(mhsId, newNama,newNIM.toInt(),newJurusan)
            db.updateDataMahasiswa(updatedMhs)
            finish()
            Toast.makeText(this, "Update Berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}