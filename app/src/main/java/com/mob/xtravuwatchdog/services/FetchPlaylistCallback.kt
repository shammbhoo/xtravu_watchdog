package com.mob.xtravuwatchdog.services

interface FetchPlaylistCallback {
    fun onCompleted(jsonString: String)
    fun onFailed(msg:String)
}