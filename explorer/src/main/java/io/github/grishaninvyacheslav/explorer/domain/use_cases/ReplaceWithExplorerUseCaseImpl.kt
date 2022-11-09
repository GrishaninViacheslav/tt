package io.github.grishaninvyacheslav.explorer.domain.use_cases

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.github.grishaninvyacheslav.explorer.ui.fragments.ExplorerFragment
import io.github.grishaninvyacheslav.navigation.domain.use_cases.ReplaceWithExplorerUseCase

class ReplaceWithExplorerUseCaseImpl(private val router: Router): ReplaceWithExplorerUseCase {
    override fun invoke() {
        val explorer = FragmentScreen { ExplorerFragment.newInstance() }
        router.replaceScreen(explorer)
    }
}