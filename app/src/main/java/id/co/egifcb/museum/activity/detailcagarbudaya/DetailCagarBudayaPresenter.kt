package id.co.egifcb.museum.activity.detailcagarbudaya

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.egifcb.museum.model.CagarBudaya

class DetailCagarBudayaPresenter(private val detailCagarBudayaView: DetailCagarBudayaView) {
    fun getDetailCagarBudaya(cagarBudayaId: String?) {
        detailCagarBudayaView.showLoading()
        AndroidNetworking.get("http://jendela.data.kemdikbud.go.id/api/index.php/CcariCagarBudaya/profilGet?cagar_budaya_id={cagar_budaya_id}")
                .addPathParameter("cagar_budaya_id", cagarBudayaId)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(CagarBudaya::class.java, object : ParsedRequestListener<CagarBudaya> {
                    override fun onResponse(response: CagarBudaya?) {
                        if (response?.dataCagarBudaya!!.isEmpty()) {
                            detailCagarBudayaView.isEmpty()
                        } else {
                            detailCagarBudayaView.onResponse(response.dataCagarBudaya)
                        }
                        detailCagarBudayaView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        detailCagarBudayaView.onError(anError?.message)
                        detailCagarBudayaView.hideLoading()
                    }

                })
    }
}