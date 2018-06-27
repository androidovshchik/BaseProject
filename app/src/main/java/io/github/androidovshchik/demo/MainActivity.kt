package io.github.androidovshchik.demo

import android.annotation.SuppressLint
import android.os.Bundle
import com.github.androidovshchik.BaseACActivity
import com.github.androidovshchik.utils.PermissionUtil
import timber.log.Timber

class MainActivity : BaseACActivity() {

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionUtil.request(this, *PermissionUtil.allPermissions(applicationContext))
            .subscribe {
                Timber.d("GRANTED: $it")
            }
    }
}
