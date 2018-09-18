package com.aranirahan.pldproject

import java.io.Serializable

data class AllBook(
        var titleBook: String? = null,
        var coverBook: String? = null
) : Serializable