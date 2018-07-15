package nyc.jsjrobotics.praneethstreetlight.countdown

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class CountdownFragment : Fragment() {

    val view = CountdownFragmentView()
    val presenter = CountdownFragmentPresenter()
    companion object {
        val TAG = "Fragment.CountdownFragment"
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribeToDisplayUpdates(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        container?.let {
            view.init(inflater, container)
            return view.rootXml
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}