package nyc.jsjrobotics.streetlight

import android.app.Activity
import android.content.res.Resources
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import nyc.jsjrobotics.streetlight.injection.ApplicationComponent
import nyc.jsjrobotics.streetlight.injection.ApplicationModule
import nyc.jsjrobotics.streetlight.injection.DaggerApplicationComponent
import nyc.jsjrobotics.streetlight.lightDisplay.LightDisplayPresenter
import javax.inject.Inject

class Application : android.app.Application(), HasActivityInjector, HasSupportFragmentInjector {

    var injector: ApplicationComponent? = null ; private set

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var mresources: Resources // This line does nothing at runtime time, but links dagger at compile time

    override fun onCreate() {
        super.onCreate()
        instance = this
        injector = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        injector!!.inject(this)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    companion object {
        private lateinit var instance: Application

        fun instance(): Application {
            return instance
        }

        fun inject(activity: Activity) {
            instance().activityInjector.inject(activity)
        }

        fun inject(fragment: Fragment) {
            instance().fragmentInjector.inject(fragment)
        }

    }
}