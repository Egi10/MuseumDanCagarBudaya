package id.co.egifcb.museum.activity.museum

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.egifcb.museum.model.Museum

class MuseumPresenter(private val mainView: MuseumView) {
    fun getMuseum(kodeProvinsi: String?) {
        mainView.showLoading()
        AndroidNetworking.get("http://jendela.data.kemdikbud.go.id/api/index.php/CcariMuseum/searchGET?kode_prop={kode_provinsi}")
                .addPathParameter("kode_provinsi", kodeProvinsi)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(Museum::class.java, object : ParsedRequestListener<Museum> {
                    override fun onResponse(response: Museum?) {
                        if (response?.data!!.isEmpty()) {
                            mainView.isEmpty()
                        } else {
                            mainView.onResponse(response.data)
                        }
                        mainView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        mainView.onError(anError?.message)
                        mainView.hideLoading()
                    }

                })
    }
}