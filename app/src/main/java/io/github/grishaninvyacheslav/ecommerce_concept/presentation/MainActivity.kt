package io.github.grishaninvyacheslav.ecommerce_concept.presentation

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.github.grishaninvyacheslav.core_ui.presentation.IBottomNavigation
import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), IBottomNavigation {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            viewModel.replaceWithExplorer()
        }
        initViews()
        initObservers()
    }

    private fun initViews() = with(binding) {
        bottomNavigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.explorer -> {
                    viewModel.replaceWithExplorer()
                    return@setOnItemSelectedListener true
                }
                R.id.cart -> {
                    viewModel.navigateToCart()
                    return@setOnItemSelectedListener false
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }

    private fun initObservers() {
        viewModel.basketSizeState.observe(this@MainActivity) { renderBasketSizeState(it) }
    }

    private fun renderBasketSizeState(state: BasketSizeState) = with(binding) {
        when (state) {
            BasketSizeState.Loading -> {}
            is BasketSizeState.Success -> setBadgeNumber(state.basketSize)
            is BasketSizeState.Error -> Toast.makeText(
                applicationContext,
                state.error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override var isNavigationVisible: Boolean = true
        set(value) {
            field = value
            binding.bottomNavigationBar.isVisible = value
        }

    private fun setBadgeNumber(number: Int) {
        binding.bottomNavigationBar.getOrCreateBadge(R.id.cart).apply {
            this.number = number
            backgroundColor = ContextCompat.getColor(
                applicationContext,
                R.color.orange
            )
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private lateinit var binding: ActivityMainBinding

    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator: AppNavigator by lazy {
        object : AppNavigator(this, R.id.container, supportFragmentManager) {
            override fun setupFragmentTransaction(
                fragmentTransaction: FragmentTransaction,
                currentFragment: Fragment?,
                nextFragment: Fragment?
            ) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
                )
            }
        }
    }

    private val viewModel: MainViewModel by viewModel()
}