package id.co.egifcb.museum.activity.detailmuseum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.co.egifcb.museum.R
import id.co.egifcb.museum.api.APIConfig
import id.co.egifcb.museum.model.Museum
import kotlinx.android.synthetic.main.activity_detail_museum.*

class DetailMuseumActivity : AppCompatActivity(), DetailMuseumView {
    private lateinit var detailMuseumPresenter: DetailMuseumPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_museum)
        title = getString(R.string.detail_museum)

        APIConfig.getConfig(this)
        detailMuseumPresenter = DetailMuseumPresenter(this)

        val intent = intent
        intent?.let {
            detailMuseumPresenter.getDetailMuseum(it.getStringExtra("id"))
        }
    }

    override fun showLoading() {
        pb_view.visibility = View.VISIBLE
        ll_show.visibility = View.GONE
    }

    override fun onResponse(listMuseum: ArrayList<Museum>) {
        for (i in listMuseum.indices) {
            tv_kode_pengelolaan.text = listMuseum[i].kodePengelolaan
            tv_nama.text = listMuseum[i].nama
            tv_sdm.text = listMuseum[i].sdm
            tv_alamat_jalan.text = listMuseum[i].alamatJalan
            tv_desa_kelurahan.text = listMuseum[i].desaKelurahan
            tv_kecamatan.text = listMuseum[i].kecamatan
            tv_kabupaten_kota.text = listMuseum[i].kabupatenKota
            tv_propinsi.text = listMuseum[i].propinsi
            tv_koleksi.text = listMuseum[i].koleksi
            tv_sumber_dana.text = listMuseum[i].sumberDana
            tv_pengelola.text = listMuseum[i].pengelola
            tv_tipe.text = listMuseum[i].tipe
            tv_standar.text = listMuseum[i].standar
            tv_tahun_berdiri.text = listMuseum[i].tahunBerdiri
            tv_bangunan.text = listMuseum[i].bangunan
            tv_luas_tanah.text = listMuseum[i].luasTanah
            tv_status_kepemilikan.text = listMuseum[i].statusKepemilikan
        }
    }

    override fun isEmpty() {
        Toast.makeText(this, "Data Saat Ini Tidak Ada", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        pb_view.visibility = View.GONE
        ll_show.visibility = View.VISIBLE
    }
}
