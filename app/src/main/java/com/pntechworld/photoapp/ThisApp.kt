package main.java.com.pntechworld.photoapp

import android.app.Application
import com.pntechworld.photoapp.di.DaggerDiApiComponent
import com.pntechworld.photoapp.di.DiApiComponent
import main.java.com.pntechworld.photoapp.di.ApiModule
import main.java.com.pntechworld.photoapp.di.AppModule

class ThisApp : Application() {

    lateinit var mApiComponent: DiApiComponent

    override fun onCreate() {
        super.onCreate()

        mApiComponent = DaggerDiApiComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule("https://pixabay.com/api/"))
            .build()
    }

    fun getDiApiComponent(): DiApiComponent {
        return mApiComponent
    }
}
