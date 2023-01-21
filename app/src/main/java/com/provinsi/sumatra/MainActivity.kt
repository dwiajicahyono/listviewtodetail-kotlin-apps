package com.provinsi.sumatra

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewkotpractice.ListData
import com.provinsi.sumatra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intArrayOf(
            R.drawable.aceh,
            R.drawable.sumatra_utara,
            R.drawable.sumatra_barat,
            R.drawable.riau,
            R.drawable.kepulauan_riau,
            R.drawable.jambi,
            R.drawable.bengkulu,
           R.drawable.sumatra_selatan,
            R.drawable.kepulauan_bangka_belitung,
            R.drawable.lampung
        )
        val populasiList = intArrayOf(
            R.string.populasiAceh,
            R.string.populasiSumut,
            R.string.populasiSumbar,
            R.string.populasiRiau,
            R.string.populasiKepulauanRiau,
            R.string.populasiJambi,
            R.string.populasiBengkulu,
            R.string.populasiSumut,
            R.string.populasiBangkaBelitung,
            R.string.populasiLampung

        )
        val descList = intArrayOf(
            R.string.acehDesc,
            R.string.sumutDesc,
            R.string.sumbarDesc,
            R.string.riauDesc,
            R.string.kepRiauDesc,
            R.string.jambiDesc,
            R.string.bengkuluDesc,
            R.string.sumselDesc,
            R.string.babelDesc,
            R.string.lampungDesc
        )
        val nameList = arrayOf("Aceh", "Sumatra Utara", "Sumatra Barat", "Riau", "Kepulauan Riau","Jambi", "Bengkulu","Sumatra Selatan", "Bangka Belitung", "lampung")
        val areaList = arrayOf("57.956", "72.981", "42.012", "87.024", "8256", "5058", "19.919", "91.592","16.424", "34.632")

        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                areaList[i], populasiList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("area", areaList[i])
            intent.putExtra("populasi", populasiList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }
    }
}