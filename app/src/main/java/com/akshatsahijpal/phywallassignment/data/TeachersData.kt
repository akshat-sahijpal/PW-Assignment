package com.akshatsahijpal.phywallassignment.data

data class TeachersData(
    var items: ArrayList<TeachersDataItem>
) {
    data class TeachersDataItem(
        var id: Int,
        var name: String,
        var subjects: List<String>,
        var qualification: List<String>,
        var profileImage: String
    )
}
