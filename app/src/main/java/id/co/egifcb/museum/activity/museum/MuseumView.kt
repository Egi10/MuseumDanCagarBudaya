package id.co.egifcb.museum.activity.museum

import id.co.egifcb.museum.model.Museum

interface MuseumView {
    fun showLoading()
    fun onResponse(listMuseum: ArrayList<Museum>)
    fun isEmpty()
    fun onError(message: String?)
    fun hideLoading()
}