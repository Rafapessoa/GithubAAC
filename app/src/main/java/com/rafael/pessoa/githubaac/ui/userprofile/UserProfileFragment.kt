package com.rafael.pessoa.githubaac.ui.userprofile


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rafael.pessoa.githubaac.R
import com.rafael.pessoa.githubaac.di.modules.AppModule_ProvideDatabaseFactory
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_profile.*
import javax.inject.Inject


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UserProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactor: ViewModelProvider.Factory
    private lateinit var viewModel: UserProfileViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpDragger()
        setupViewModel()
        setupView()
    }

    private fun setUpDragger(){
        AndroidSupportInjection.inject(this)
    }

    private fun setupView(){
        btPesquisar.setOnClickListener{
            viewModel.getUser(etUsuario.text.toString())
            viewModel.user.observe(this, Observer {
                tvUsuario.text = it?.name
                Picasso.get().load(it?.avatarURL).into(ivUsuario)
            })
        }
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders
                .of(this,viewModelFactor)
                .get(UserProfileViewModel::class.java)

    }

}
