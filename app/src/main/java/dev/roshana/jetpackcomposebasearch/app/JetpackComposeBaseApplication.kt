package dev.roshana.jetpackcomposebasearch.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.roshana.domain.utils.initPreferenceUtils

/** PariSa;
coding and smoking ;)
 **/

@HiltAndroidApp
class JetpackComposeBaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initPreferenceUtils(applicationContext)
    }
}