package io.github.grishaninvyacheslav.explorer.domain.use_cases.explorer

import io.github.grishaninvyacheslav.explorer.data.IExplorerRepository

class ExplorerUseCasesImpl(
    private val explorerRepository: IExplorerRepository
): ExplorerUseCases {
    override suspend fun getHotSales() = explorerRepository.getHotSales()
    override suspend fun getBestSellers() = explorerRepository.getBestSellers()
}