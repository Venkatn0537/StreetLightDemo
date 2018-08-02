package nyc.jsjrobotics.streetlight

import android.os.Bundle
import android.support.v4.app.Fragment
import nyc.jsjrobotics.streetlight.Application

open class DefaultFragment : Fragment(){
    var performInjection : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (performInjection) {
            Application.inject(this)
        }
    }
}
