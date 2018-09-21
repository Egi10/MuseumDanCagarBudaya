package id.co.egifcb.museum.model

import com.google.gson.annotations.SerializedName

data class Museum (
        @SerializedName("museum_id")
        val museumId: String? = null,

        @SerializedName("kode_pengelolaan")
        val kodePengelolaan: String? = null,

        @SerializedName("nama")
        val nama: String? = null,

        @SerializedName("sdm")
        val sdm: String? = null,

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

        @SerializedName("koleksi")
        val koleksi: String? = null,

        @SerializedName("sumber_dana")
        val sumberDana: String? = null,

        @SerializedName("pengelola")
        val pengelola: String? = null,

        @SerializedName("tipe")
        val tipe: String? = null,

        @SerializedName("standar")
        val standar: String? = null,

        @SerializedName("tahun_berdiri")
        val tahunBerdiri: String? = null,

        @SerializedName("bangunan")
        val bangunan: String? = null,

        @SerializedName("luas_tanah")
        val luasTanah: String? = null,

        @SerializedName("status_kepemilikan")
        val statusKepemilikan: String? = null,

        @SerializedName("data")
        val data: ArrayList<Museum>?)