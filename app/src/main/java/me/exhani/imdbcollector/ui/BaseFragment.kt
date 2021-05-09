package me.exhani.imdbcollector.ui

import dagger.hilt.android.AndroidEntryPoint
import me.exhani.imdbcollector.presentation.base.BaseView
import moxy.MvpAppCompatFragment

@AndroidEntryPoint
class BaseFragment: MvpAppCompatFragment(), BaseView {
}