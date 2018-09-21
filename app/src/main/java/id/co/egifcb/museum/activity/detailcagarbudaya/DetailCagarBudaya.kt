package id.co.egifcb.museum.activity.detailcagarbudaya

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.co.egifcb.museum.R
import id.co.egifcb.museum.api.APIConfig
import id.co.egifcb.museum.model.CagarBudaya
import kotlinx.android.synthetic.main.activity_detail_cagar_budaya.*

class DetailCagarBudaya : AppCompatActivity(), DetailCagarBudayaView {
    private lateinit var detailCagarBudayaPresenter: DetailCagarBudayaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cagar_budaya)
        title = getString(R.string.detail_cagar_budaya)

        APIConfig.getConfig(this)
        detailCagarBudayaPresenter = DetailCagarBudayaPresenter(this)

        val intent = intent
        intent?.let {
            detailCagarBudayaPresenter.getDetailCagarBudaya(intent.getStringExtra("id"))
        }
    }

    override fun showLoading() {
        pb_view.visibility = View.VISIBLE
        ll_show.visibility = View.GONE
    }

    override fun onResponse(listCagarBudaya: ArrayList<CagarBudaya>) {
        for (i in listCagarBudaya.indices) {
            tv_kode_pengelolaan.text = listCagarBudaya[i].kodePengelolaan
            tv_nama.text = listCagarBudaya[i].nama
            tv_alamat_jalan.text = listCagarBudaya[i].alamatJalan
            tv_desa_kelurahan.text = listCagarBudaya[i].desaKelurahan
            tv_kecamatan.text = listCagarBudaya[i].kecamatan
            tv_kabupaten_kota.text = listCagarBudaya[i].kabupatenKota
            tv_propinsi.text = listCagarBudaya[i].propinsi
            tv_nomor_penetapan.text = listCagarBudaya[i].nomorPenetapan
            tv_tanggal_penetapan.text = listCagarBudaya[i].tanggalPenetapan
            tv_batas_barat.text = listCagarBudaya[i].batasBarat
            tv_batas_selatan.text = listCagarBudaya[i].batasSelatan
            tv_batas_utara.text = listCagarBudaya[i].batasUtara
            tv_batas_timur.text = listCagarBudaya[i].batasTimur
            tv_pemilik.text = listCagarBudaya[i].pemilik
            tv_pengelola.text = listCagarBudaya[i].pengelola
        }
    }

    override fun isEmpty() {
        Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        pb_view.visibility = View.GONE
        ll_show.visibility = View.VISIBLE
    }
}
