package nyc.jsjrobotics.streetlight.lightDisplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nyc.jsjrobotics.streetlight.LightOption
import nyc.jsjrobotics.streetlight.R
import nyc.jsjrobotics.streetlight.runOnMainThread
import javax.inject.Inject

open class LightsDisplayView @Inject constructor(){
    lateinit var rootXml : View
    lateinit var redLight : View
    lateinit var yellowLight : View
    lateinit var greenLight : View
    lateinit var allLights : List<View>
    fun init(inflater: LayoutInflater, container: ViewGroup) {
        rootXml = inflater.inflate(R.layout.fragment_lights_display, container, false)
        redLight = rootXml.findViewById(R.id.red_light)
        yellowLight = rootXml.findViewById(R.id.yellow_light)
        greenLight = rootXml.findViewById(R.id.green_light)
        allLights = listOf(redLight,
                yellowLight,
                greenLight)
    }

    fun setLight(currentLight: LightOption) {
        runOnMainThread {
                showLight(getLight(currentLight))
        }
    }

    private fun getLight(currentLight: LightOption): View {
        when (currentLight) {
            LightOption.RED -> return redLight
            LightOption.YELLOW -> return yellowLight
            LightOption.GREEN -> return greenLight
        }
    }

    private fun hideAllLights() {
        allLights.forEach{ it.visibility = View.INVISIBLE}
    }

    private fun showLight(lightView: View) {
        hideAllLights()
        lightView.visibility = View.VISIBLE
    }

}
