package com.example.duabelas.model

import kotlinx.serialization.SerialName

data class Mahasiswa(
    val nim : String,
    val nama : String,
    val alamat: String,


    @SerialName("jenis_kelamin")
    val jeniskelamin: String,

    val kelas: String,
    val angkatan: String

)
