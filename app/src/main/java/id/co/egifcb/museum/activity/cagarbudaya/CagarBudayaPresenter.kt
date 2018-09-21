package id.co.egifcb.museum.activity.cagarbudaya

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.egifcb.museum.model.CagarBudaya

class CagarBudayaPresenter(private val cagarBudayaView: CagarBudayaView) {
    fun getCagarBudaya(kodeProp: String?) {
        cagarBudayaView.showLoading()
        AndroidNetworking.get("http://jendela.data.kemdikbud.go.id/api/index.php/CcariCagarBudaya/searchGET?kode_prop={kode_prop}")
                .addPathParameter("kode_prop", kodeProp)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(CagarBudaya::class.java, object : ParsedRequestListener<CagarBudaya> {
                    override fun onResponse(response: CagarBudaya?) {
                        if (response?.dataCagarBudaya!!.isEmpty()) {
                            cagarBudayaView.isEmpty()
                        } else {
                            cagarBudayaView.onResponse(response.dataCagarBudaya)
                        }
                        cagarBudayaView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        cagarBudayaView.onError(anError?.message)
                        cagarBudayaView.hideLoading()
                    }

                })
    }
}