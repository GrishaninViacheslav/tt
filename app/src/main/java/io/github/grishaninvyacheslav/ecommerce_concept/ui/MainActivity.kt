package io.github.grishaninvyacheslav.ecommerce_concept.ui

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ActivityMainBinding
import io.github.grishaninvyacheslav.ecommerce_concept.ui.fragments.explorer.ExplorerFragment
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.IScreens
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer.BestSellersState
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer.ExplorerViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.main.BasketSizeState
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.main.MainViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.utills.toBestSellersPages
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), IBottomNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            router.replaceScreen(screens.explorer())
        }
        initViews()
        initObservers()
    }

    private fun initViews() = with(binding) {
        bottomNavigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.explorer -> {
                    router.navigateTo(screens.explorer())
                    return@setOnItemSelectedListener true
                }
                R.id.cart -> {
                    router.navigateTo(screens.cart())
                    return@setOnItemSelectedListener false
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }

    private fun initObservers() = with(binding) {
        viewModel.basketSizeState.observe(this@MainActivity) { renderBasketSizeState(it) }
    }

    private fun renderBasketSizeState(state: BasketSizeState) = with(binding) {
        when (state) {
            BasketSizeState.Loading -> {}
            is BasketSizeState.Success -> setBadgeNumber(state.basketSize)
            is BasketSizeState.Error -> Toast.makeText(applicationContext, state.error.message, Toast.LENGTH_LONG).show()

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

    private val router: Router by inject()
    private val screens: IScreens by inject()
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