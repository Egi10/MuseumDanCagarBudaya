package id.co.egifcb.museum.activity.museum

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.co.egifcb.museum.R
import id.co.egifcb.museum.activity.detailmuseum.DetailMuseumActivity
import id.co.egifcb.museum.adapter.AdapterMuseum
import id.co.egifcb.museum.api.APIConfig
import id.co.egifcb.museum.model.Museum
import kotlinx.android.synthetic.main.activity_museum.*
import java.util.*

class MuseumActivity : AppCompatActivity(), MuseumView {
    private lateinit var museumPresenter: MuseumPresenter
    private var list: MutableList<Museum> = mutableListOf()
    private lateinit var adapterMuseum: AdapterMuseum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)
        title = getString(R.string.museum)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        }

        APIConfig.getConfig(this)

        museumPresenter = MuseumPresenter(this)

        swipeRefresh.post {
            loadMuseum()
        }

        swipeRefresh.setOnRefreshListener {
            loadMuseum()
        }
    }

    private fun loadMuseum() {
        museumPresenter.getMuseum("080000")

        adapterMuseum = AdapterMuseum(this, list) {
            val intent = Intent(this, DetailMuseumActivity::class.java)
            intent.putExtra("id", it.museumId)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterMuseum
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun onResponse(listMuseum: ArrayList<Museum>) {
        list.clear()
        listMuseum.let {
            list.addAll(listMuseum)
        }
        adapterMuseum.notifyDataSetChanged()
    }

    override fun isEmpty() {

    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
