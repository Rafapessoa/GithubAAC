package com.rafael.pessoa.githubaac.di.modules

import com.rafael.pessoa.githubaac.ui.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class  FragmentModules{

    @ContributesAndroidInjector
    abstract  fun contributeUserProfileFragment() : UserProfileFragment

}