package nyc.jsjrobotics.streetlight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class DefaultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        Application.inject(this)
        super.onCreate(savedInstanceState)
    }
}
