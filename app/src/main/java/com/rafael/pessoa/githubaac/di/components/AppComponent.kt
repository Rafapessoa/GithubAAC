package com.rafael.pessoa.githubaac.di.components

import android.app.Application
import com.rafael.pessoa.githubaac.MyApp
import com.rafael.pessoa.githubaac.di.modules.ActivityModule
import com.rafael.pessoa.githubaac.di.modules.AppModule
import com.rafael.pessoa.githubaac.di.modules.FragmentModules
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ActivityModule::class,
            FragmentModules::class,
            AppModule::class
        ]
)
interface AppComponent{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApp)


}