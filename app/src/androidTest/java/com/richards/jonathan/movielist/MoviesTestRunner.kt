package com.richards.jonathan.movielist

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.github.tmurakami.dexopener.DexOpener

class MoviesTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        DexOpener.install(this)
        System.setProperty("org.mockito.android.target", context!!.cacheDir.absolutePath)
        return super.newApplication(cl, className, context)
    }
}