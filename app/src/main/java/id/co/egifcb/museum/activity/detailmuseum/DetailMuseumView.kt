package id.co.egifcb.museum.activity.detailmuseum

import id.co.egifcb.museum.model.Museum

interface DetailMuseumView {
    fun showLoading()
    fun onResponse(listMuseum: ArrayList<Museum>)
    fun isEmpty()
    fun onError(message: String?)
    fun hideLoading()
}