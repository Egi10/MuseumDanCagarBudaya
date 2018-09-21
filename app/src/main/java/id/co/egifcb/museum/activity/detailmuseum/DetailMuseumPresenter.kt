package id.co.egifcb.museum.activity.detailmuseum

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.egifcb.museum.model.Museum

class DetailMuseumPresenter(private val detailMuseumView: DetailMuseumView) {
    fun getDetailMuseum(museumId: String?) {
        detailMuseumView.showLoading()
        AndroidNetworking.get("http://jendela.data.kemdikbud.go.id/api/index.php/CcariMuseum/profilGet?museum_id={museum_id}")
                .addPathParameter("museum_id", museumId)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(Museum::class.java, object : ParsedRequestListener<Museum> {
                    override fun onResponse(response: Museum?) {
                        if (response?.data!!.isEmpty()) {
                            detailMuseumView.isEmpty()
                        } else {
                            detailMuseumView.onResponse(response.data)
                        }
                        detailMuseumView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        detailMuseumView.onError(anError?.message)
                        detailMuseumView.hideLoading()
                    }

                })
    }
}