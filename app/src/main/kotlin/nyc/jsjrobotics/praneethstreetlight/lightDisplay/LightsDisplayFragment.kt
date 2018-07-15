package nyc.jsjrobotics.praneethstreetlight.lightDisplay

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class LightsDisplayFragment : Fragment() {

    val view : LightsDisplayView = LightsDisplayView()
    val presenter: LightDisplayPresenter = LightDisplayPresenter()

    companion object {
        val TAG = "Fragment.LightsDisplayFragment"
    }

    override fun onResume() {
        super.onResume()
        presenter.startTimer()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        container?.let {
            view.init(inflater, container)
            presenter.setView(view)
            return view.rootXml
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}