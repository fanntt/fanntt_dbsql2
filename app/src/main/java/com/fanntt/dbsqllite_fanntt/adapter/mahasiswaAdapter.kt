package com.fanntt.dbsqllite_fanntt.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fanntt.dbsqllite_fanntt.DetailPage
import com.fanntt.dbsqllite_fanntt.MainActivity
import com.fanntt.dbsqllite_fanntt.R
import com.fanntt.dbsqllite_fanntt.dbhelper.helper
import com.fanntt.dbsqllite_fanntt.model.ModelMahasiswa
import com.fanntt.dbsqllite_fanntt.screen_page.TambahDataMahasiswa
import com.fanntt.dbsqllite_fanntt.screen_page.UpdateNoteActivity

class mahasiswaAdapter(
    private var  ListMahasiswa : List<ModelMahasiswa>,
    val context : Context

) : RecyclerView.Adapter<mahasiswaAdapter.MahasiswaViewHolder>(){

    private val db : helper = helper (context)

    class MahasiswaViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val txtNama : TextView = itemView.findViewById(R.id.txtNama)
        val txtJurusan : TextView = itemView.findViewById(R.id.txtItemJurusan)
        val txtNIM : TextView = itemView.findViewById(R.id.txtNIM)
        val cardMahasiswa : CardView = itemView.findViewById(R.id.cardMahasiswa)

        val btnEdit : ImageView = itemView.findViewById(R.id.btnEditItem)
        val btnDelete : ImageView = itemView.findViewById(R.id.btnDeleteItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_mahasiswa,
           parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListMahasiswa.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val nMahasiswa = ListMahasiswa[position]
        holder.txtNama.text = nMahasiswa.nama
        holder.txtNIM.text = nMahasiswa.nim.toString()
        holder.txtJurusan.text = nMahasiswa.jurusan

//        holder.cardMahasiswa.setOnClickListener(){
//
//            val intent = Intent(context, DetailPage::class.java)
//            //put Extra
//            intent.putExtra("nama",ListMahasiswa[position].nama)
//            intent.putExtra("nim", ListMahasiswa[position].nim)
//            intent.putExtra("jurusan",ListMahasiswa[position].jurusan)
//            context.startActivity(intent)
//
//            Toast.makeText(context,ListMahasiswa[position].nama, Toast.LENGTH_SHORT).show()
//
//        }

        holder.btnEdit.setOnClickListener(){
            val intent = Intent(holder.itemView.context, UpdateNoteActivity::class.java).apply {
                putExtra("id_mhs", nMahasiswa.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.btnDelete.setOnClickListener(){
            db.deleteMahasiswa(nMahasiswa.id)
            refreshData(db.getalldataMahasiswa())
            Toast.makeText(holder.itemView.context, "Berhasil Delete Data Mahasiswa ${nMahasiswa.nama}", Toast.LENGTH_SHORT).show()
        }


    }
    // refresh data
    fun refreshData(newMahasiswa : List <ModelMahasiswa>){
        ListMahasiswa = newMahasiswa
        notifyDataSetChanged()
    }
}