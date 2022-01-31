package com.example.data.utils

object HandleErrorCodes {

    fun getStringForErrorCode( code:Int) :String {
        if(code == 404){
            return "Invalid Url"
        }else{
            return "Something went wrong"
        }
    }
}