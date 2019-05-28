package com.example.training_4_29.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.crashlytics.android.Crashlytics
import com.example.training_4_29.R
import com.example.training_4_29.manager.AnalyticsManager
import com.example.training_4_29.ui.base.BaseActivity
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_analytics.*

class AnalyticsActivity : BaseActivity(), View.OnClickListener {
    val imageURL =
        "https://images.pexels.com/photos/257540/pexels-photo-257540.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"

    override fun onCreate(savedInstanceState: Bundle?) {
        Fabric.with(this, Crashlytics())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)
        btnRunning.setOnClickListener(this)
        btnWalking.setOnClickListener(this)
        btnSwimming.setOnClickListener(this)
        btnLoadImage.setOnClickListener(this)


        btnForceCrash.setOnClickListener {
            throw RuntimeException("Forcing a crash")
        }

    }

    override fun onClick(view: View?) {
        Log.d(AnalyticsActivity::class.java.simpleName, "onClick: ")
        when (view?.id) {
            R.id.btnRunning -> AnalyticsManager.logEvent("Running", "1", "Click")
            R.id.btnWalking -> AnalyticsManager.logEvent("Walking", "2", "Click")
            R.id.btnSwimming -> AnalyticsManager.logEvent("Swimming", "3", "Click")
            R.id.btnLoadImage -> loadImage()

        }
    }

    private fun loadImage() {
        Log.d(AnalyticsActivity::class.java.simpleName, "loadImage: ")
        Glide.with(this)
            .load(imageURL)
            //.listener(GlideListener())
            .into(ivMain)
    }

}

class GlideListener : RequestListener<Drawable> {
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {

        Log.d(AnalyticsActivity::class.java.simpleName, "onLoadFailed: ")
        AnalyticsManager.logEvent("loadImage", "4", "Loading failed")
        return false
    }

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        Log.d(AnalyticsActivity::class.java.simpleName, "onResourceReady: ")
        AnalyticsManager.logEvent("loadImage", "4", "Resource Ready")
        return false
    }

}

