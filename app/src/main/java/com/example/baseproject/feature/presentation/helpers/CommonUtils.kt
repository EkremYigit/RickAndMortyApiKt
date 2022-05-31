package com.example.baseproject.feature.presentation.helpers

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.example.baseproject.R

object CommonUtils {
    private lateinit var progressDialog: Dialog
    fun AppCompatActivity.setProgressDialog() {
        progressDialog = Dialog(this)
        progressDialog.apply {
            this.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            this.setContentView(R.layout.progress_dialog)
            this.setCancelable(false)
            this.setCanceledOnTouchOutside(false)
        }
    }
}