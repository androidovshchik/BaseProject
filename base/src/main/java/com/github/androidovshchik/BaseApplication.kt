@file:Suppress("unused")

package com.github.androidovshchik

import android.app.Application
import android.text.TextUtils
import com.facebook.stetho.Stetho
import com.github.androidovshchik.utils.*
import org.acra.ACRA
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate", "NON_EXHAUSTIVE_WHEN")
abstract class BaseApplication: Application() {

    abstract val theme: Int

    override fun onCreate() {
        super.onCreate()
        if (ACRA.isACRASenderServiceProcess()) {
            return
        }
        if (isBuildConfigDebug()) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(appContext)
            ACRAUtil.init(this, theme)
        }
        Timber.d(TextUtils.join(newLine(), preferences.getAllSorted()))
    }
}