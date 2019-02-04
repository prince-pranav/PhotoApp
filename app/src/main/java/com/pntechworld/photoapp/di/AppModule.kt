package main.java.com.pntechworld.photoapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import main.java.com.pntechworld.photoapp.ThisApp
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    var mApplication: Application = application

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
}