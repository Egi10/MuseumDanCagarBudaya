package id.co.egifcb.museum.activity.cagarbudaya

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import id.co.egifcb.museum.R
import id.co.egifcb.museum.activity.detailcagarbudaya.DetailCagarBudaya
import id.co.egifcb.museum.adapter.AdapterCagarBudaya
import id.co.egifcb.museum.api.APIConfig
import id.co.egifcb.museum.model.CagarBudaya
import kotlinx.android.synthetic.main.activity_cagar_budaya.*
import java.util.*

class CagarBudayaActivity : AppCompatActivity(), CagarBudayaView {
    private lateinit var cagarBudayaPresenter: CagarBudayaPresenter
    private var list: MutableList<CagarBudaya> = mutableListOf()
    private lateinit var adapterCagarBudaya: AdapterCagarBudaya

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cagar_budaya)
        title = getString(R.string.cagarBudaya)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        }


        APIConfig.getConfig(this)
        cagarBudayaPresenter = CagarBudayaPresenter(this)

        swipeRefresh.post {
            loadCagarBudaya()
        }

        swipeRefresh.setOnRefreshListener {
            loadCagarBudaya()
        }
    }

    private fun loadCagarBudaya() {
        cagarBudayaPresenter.getCagarBudaya("080000")

        adapterCagarBudaya = AdapterCagarBudaya(this, list) {
            val intent = Intent(this, DetailCagarBudaya::class.java)
            intent.putExtra("id", it.cagarBudayaId)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterCagarBudaya
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun onResponse(listCagarBudaya: ArrayList<CagarBudaya>) {
        list.clear()
        listCagarBudaya.let {
            list.addAll(listCagarBudaya)
        }
        adapterCagarBudaya.notifyDataSetChanged()
    }

    override fun isEmpty() {

    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Log.d("Error", message)
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
