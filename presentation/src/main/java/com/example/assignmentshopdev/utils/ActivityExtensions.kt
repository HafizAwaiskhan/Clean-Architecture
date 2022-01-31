package com.example.assignmentshopdev.utils

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Used to start activity in simple way
 */
inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

/**
 * Show toast inside activity
 *
 * @param message message to show in toast
 */
fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Show toast inside activity
 *
 * @param message message res id to show in toast
 */
fun Activity.showToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}