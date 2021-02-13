package shevtsov.daniil.asciiart.structure.presentation

import shevtsov.daniil.asciiart.storage.domain.InformationItem
import shevtsov.daniil.asciiart.structure.view.adapter.StructureInformationItem
import javax.inject.Inject

class StructureInformationItemMapper @Inject constructor() {

    fun map(informationItem: InformationItem) = with(informationItem) {
        StructureInformationItem(
            id = id,
            title = name
        )
    }

}