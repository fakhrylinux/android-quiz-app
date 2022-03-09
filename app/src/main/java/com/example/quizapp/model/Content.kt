package com.example.quizapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(

	@field:SerializedName("image")
	val image: String? = null,

//	@field:SerializedName("image")
//	val image: Int? = null,

	@field:SerializedName("answers")
	val answers: List<Answer>? = null,

	@field:SerializedName("body")
	val body: String? = null
) : Parcelable