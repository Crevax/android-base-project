package com.github.crevax.androidbase.di

import android.app.Application
import com.github.crevax.androidbase.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ServiceModule::class),
    (UserInterfaceModule::class)
])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(app: BaseApplication)
}
