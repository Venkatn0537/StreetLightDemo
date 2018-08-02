package nyc.jsjrobotics.streetlight.countdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nyc.jsjrobotics.streetlight.DefaultFragment
import javax.inject.Inject


class CountdownFragment : DefaultFragment() {

    @Inject lateinit var view : CountdownFragmentView
    @Inject lateinit var presenter : CountdownFragmentPresenter

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