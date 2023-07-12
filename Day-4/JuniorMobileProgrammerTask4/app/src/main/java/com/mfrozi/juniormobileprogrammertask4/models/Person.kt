package com.mfrozi.juniormobileprogrammertask4.models

import java.io.Serializable

data class Person(
    var profileUrl : String,
    var name : String,
    var email : String,
    var jurusan : String,
    var semester: Int,
): Serializable