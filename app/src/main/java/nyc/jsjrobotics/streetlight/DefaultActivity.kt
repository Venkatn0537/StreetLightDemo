package nyc.jsjrobotics.streetlight

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

abstract class DefaultActivity : FragmentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        Application.inject(this)
        super.onCreate(savedInstanceState)
    }
}
