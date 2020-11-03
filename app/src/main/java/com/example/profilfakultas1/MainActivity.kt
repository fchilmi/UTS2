package com.example.profilfakultas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakData()
        RV.layoutManager = LinearLayoutManager(this)
        RV.setHasFixedSize(true)
        RV.adapter = FakAdapter(testData, { fakItem: FakData -> ItemClicked(fakItem)})
    }

    private fun ItemClicked(fakItem: FakData) {
        val showIntent = Intent(this, FakDetailActivity::class.java)
        showIntent.putExtra(Intent.EXTRA_TEXT, fakItem.namaFak.toString())
        showIntent.putExtra(Intent.EXTRA_TEMPLATE, fakItem.descFak.toString())
        showIntent.putExtra(Intent.EXTRA_REFERRER, fakItem.fotoFak.toString())
        startActivity(showIntent)
    }

    private fun createFakData() : List<FakData> {
        val partList = ArrayList<FakData>()
        partList.add(FakData("Fakultas Ilmu Komputer","Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Teknik Informatika\n" +
                "\t2. Prodi S1 Sistem Informasi\n" +
                "\t3. Prodi S1 Data Science", R.drawable.upn))

        partList.add(FakData("Fakultas Teknik", "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Teknik Kimia\n" +
                "\t2. Prodi S1 Teknik Industri\n" +
                "\t3. Prodi S1 Teknik Sipil\n" +
                "\t4. Prodi S1 Teknik Lingkungan\n" +
                "\t5. Prodi S1 Teknologi Pangan\n" +
                "\t6. Prodi S1 Teknik Mesin", R.drawable.upn))

        partList.add(FakData("Fakultas Ekonomi Dan Bisnis", "Fakultas Ekonomi Dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                " \t1. Prodi S1 Ekonomi Pembangunan\n" +
                "\t2. Prodi S1 Akuntansi\n" +
                "\t3. Prodi S1 Manajemen", R.drawable.upn))

        partList.add(FakData("Fakultas Pertanian", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Agroteknologi\n" +
                "\t2. Prodi S1 Agribisnis", R.drawable.upn))

        partList.add(FakData("Farid Chilmi",
            "TTL\t\t\t\t\t\t\t\t: Surabaya, 20 Mei 2000\n" +
                    "ALAMAT\t\t\t\t\t: Jl. Setro Baru Utara X/7 Surabaya\n" +
                    "NO.HP\t\t\t\t\t\t\t: +62819-3928-4446\n" +
                    "E-MAIL\t\t\t\t\t\t: faridchilmi10@gmail.com\n" +
                    "E-MAIL\t\t\t\t\t\t: www.github.com/fchilmi\n\n" +
                    "RIWAYAT PENDIDIKAN\t:\n"+
                    "\t\t\tSDN Rangkah 6 Surabaya\n" +
                    "\t\t\tSMPN 9 Surabaya\n" +
                    "\t\t\tSMA Muhammadiyah 7 Surabaya\n\n" +
                    "PENGHARGAAN\t\t:", R.drawable.profile_icon))
        return partList
    }
}

