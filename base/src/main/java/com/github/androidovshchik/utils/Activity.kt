@file:Suppress("unused", "DEPRECATION")

package com.github.androidovshchik.utils

import android.app.Activity
import android.app.ProgressDialog
import com.github.androidovshchik.R

fun Activity.newProgressDialog(): ProgressDialog {
    return ProgressDialog.show(this, getString(R.string.wait), null, true)
}