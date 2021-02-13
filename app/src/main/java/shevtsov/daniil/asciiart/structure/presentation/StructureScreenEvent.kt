package shevtsov.daniil.asciiart.structure.presentation

sealed class StructureScreenEvent {
    data class OpenLearning(val itemId: String) : StructureScreenEvent()
}