package nyc.jsjrobotics.streetlight.lightDisplay

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nyc.jsjrobotics.streetlight.DefaultFragment
import javax.inject.Inject


class LightsDisplayFragment : DefaultFragment() {

    @Inject
    lateinit var view : LightsDisplayView
    @Inject
    lateinit var presenter: LightDisplayPresenter

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