package com.example.training_4_29.ui.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.example.training_4_29.R
import com.example.training_4_29.utils.toast

class ToastedButton : AppCompatButton, View.OnClickListener {

    lateinit var listener: OnToastClickListener
    var message = "Default message"

    override fun onClick(v: View?) {
        context.toast(message)
        listener.onClick()
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }


    private fun init(context: Context, attrs: AttributeSet?) {
        setOnClickListener(this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ToastedButton)
        message = typedArray.getString(R.styleable.ToastedButton_message)
        typedArray.recycle()

    }

    fun setOnToastClickListener(listener: OnToastClickListener) {
        this.listener = listener
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    interface OnToastClickListener {
        fun onClick()
    }
}