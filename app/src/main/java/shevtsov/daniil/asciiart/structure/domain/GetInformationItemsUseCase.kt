package shevtsov.daniil.asciiart.structure.domain

import shevtsov.daniil.asciiart.storage.domain.TextStorageRepository
import javax.inject.Inject

class GetInformationItemsUseCase @Inject constructor(
    private val textStorageRepository: TextStorageRepository
) {

    operator fun invoke() = textStorageRepository.getItems()

}