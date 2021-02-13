package shevtsov.daniil.asciiart.storage.data

import shevtsov.daniil.asciiart.storage.domain.InformationItem
import javax.inject.Inject

class InformationItemMapper @Inject constructor() {
    fun map(dto: InformationItemDto): InformationItem = with(dto) {
        InformationItem(
            id = id,
            name = name,
            content = content
        )
    }
}