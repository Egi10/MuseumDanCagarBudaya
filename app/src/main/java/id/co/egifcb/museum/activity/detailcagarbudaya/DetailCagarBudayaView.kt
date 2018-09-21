package id.co.egifcb.museum.activity.detailcagarbudaya

import id.co.egifcb.museum.model.CagarBudaya

interface DetailCagarBudayaView {
    fun showLoading()
    fun onResponse(listCagarBudaya: ArrayList<CagarBudaya>)
    fun isEmpty()
    fun onError(message: String?)
    fun hideLoading()
}