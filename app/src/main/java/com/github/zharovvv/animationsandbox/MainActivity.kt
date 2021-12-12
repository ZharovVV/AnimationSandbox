package com.github.zharovvv.animationsandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import com.github.zharovvv.animationsandbox.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, mainFragment, "main_fragment")
                .commit()
        } else {
            mainFragment =
                supportFragmentManager.findFragmentByTag("main_fragment") as MainFragment
        }
        //Не относится к анимации.
        //LoaderSandbox
        LoaderManager.getInstance(this)
            .initLoader(R.id.stub_loader_id, Bundle.EMPTY, StubLoaderCallback(this))
    }
}