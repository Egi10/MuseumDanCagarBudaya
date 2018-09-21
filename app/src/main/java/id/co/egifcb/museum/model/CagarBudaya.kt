package id.co.egifcb.museum.model

import com.google.gson.annotations.SerializedName

data class CagarBudaya (
        @SerializedName("cagar_budaya_id")
        val cagarBudayaId: String? = null,

        @SerializedName("kode_pengelolaan")
        val kodePengelolaan: String? = null,

        @SerializedName("nama")
        val nama: String? = null,

        @SerializedName("alamat_jalan")
        val alamatJalan: String? = null,

        @SerializedName("desa_kelurahan")
        val desaKelurahan: String? = null,

        @SerializedName("kecamatan")
        val kecamatan: String? = null,

        @SerializedName("kabupaten_kota")
        val kabupatenKota: String? = null,

        @SerializedName("propinsi")
        val propinsi: String? = null,

        @SerializedName("lintang")
        val lintang: String? = null,

        @SerializedName("bujur")
        val bujur: String? = null,

        @SerializedName("nomor_penetapan")
        val nomorPenetapan: String? = null,

        @SerializedName("tanggal_penetapan")
        val tanggalPenetapan: String? = null,

        @SerializedName("batas_barat")
        val batasBarat: String? = null,

        @SerializedName("batas_selatan")
        val batasSelatan: String? = null,

        @SerializedName("batas_utara")
        val batasUtara: String? = null,

        @SerializedName("batas_timur")
        val batasTimur: String? = null,

        @SerializedName("pemilik")
        val pemilik: String? = null,

        @SerializedName("pengelola")
        val pengelola: String? = null,

        @SerializedName("data")
        val dataCagarBudaya: ArrayList<CagarBudaya>?)