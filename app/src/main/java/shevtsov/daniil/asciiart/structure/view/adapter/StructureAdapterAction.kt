package shevtsov.daniil.asciiart.structure.view.adapter

sealed class StructureAdapterAction {
    data class ItemSelected(val itemId: String) : StructureAdapterAction()
}