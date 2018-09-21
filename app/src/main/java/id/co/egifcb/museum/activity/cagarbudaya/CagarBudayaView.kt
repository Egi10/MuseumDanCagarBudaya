package id.co.egifcb.museum.activity.cagarbudaya

import id.co.egifcb.museum.model.CagarBudaya

interface CagarBudayaView {
    fun showLoading()
    fun onResponse(listCagarBudaya: ArrayList<CagarBudaya>)
    fun isEmpty()
    fun onError(message: String?)
    fun hideLoading()
}