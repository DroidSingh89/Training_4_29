package com.example.training_4_29.ui.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import com.example.training_4_29.R
import com.example.training_4_29.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_animation.*


class AnimationActivity : BaseActivity() {
    var translationY = 0f
    var translationX = 0f
    var translationZ = 0f
    var rotation = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        btnAnimate.setOnClickListener {
            animate(tvMain)
        }
    }

    private fun animate(view: TextView) {

        val valueAnimator = ValueAnimator.ofFloat(translationY, translationY+ 500f)
            .apply {
                interpolator = AccelerateDecelerateInterpolator()
                duration = 5000
                addUpdateListener { animation ->
                    translationY = animation.animatedValue as Float
                    view.translationY = translationY
                }
                //starts the animation
                start()
            }

        rotation += 90f

        tvMain.animate().rotation(rotation).setDuration(5000).start()


    }
}
