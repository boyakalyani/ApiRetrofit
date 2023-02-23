package com.example.apiretrofit

data class responseDataClass(
    val author:String,
    val nsfw:Boolean,
    val postLink:String,
    val preview:List<String>,
    val spoiler:Boolean,
    val title:String,
    val ups:Int,
    val url:String
) {
}