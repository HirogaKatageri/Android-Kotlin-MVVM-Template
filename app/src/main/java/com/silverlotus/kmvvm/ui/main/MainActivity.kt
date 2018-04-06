package com.silverlotus.kmvvm.ui.main

import android.os.Bundle
import com.silverlotus.kmvvm.R
import com.silverlotus.kmvvm.base.BaseActivity

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainFragment())
                .commit()

    }
}