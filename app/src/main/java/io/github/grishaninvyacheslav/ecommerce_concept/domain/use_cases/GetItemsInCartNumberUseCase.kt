package io.github.grishaninvyacheslav.ecommerce_concept.domain.use_cases

interface GetItemsInCartNumberUseCase {
    suspend operator fun invoke(): Int
}