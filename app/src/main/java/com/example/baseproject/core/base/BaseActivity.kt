package com.example.baseproject.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.baseproject.core.extensions.changeDarkMode

abstract class BaseActivity< VB : ViewBinding>: AppCompatActivity() {
    protected lateinit var binding: VB
        private set


    abstract val bindingInflater: (LayoutInflater) -> VB
    abstract val viewModel: BaseViewModel?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(layoutInflater).apply {
            setContentView(this.root)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            com.example.baseproject.R.id.action_darkmode -> {
                changeDarkMode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
