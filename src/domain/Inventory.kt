package designpatterns.domain

import designpatterns.domain.state.ActiveState
import designpatterns.domain.state.BlockedState
import designpatterns.domain.state.DraftState

class Inventory private constructor(
    var id: String,
    var stock: Int,
) {
    var state: InventoryState = DraftState(this)

    companion object Factory {
        fun createDraft(id: String, stock: Int): DraftState = DraftState(Inventory(id, stock))
        fun createActive(id: String, stock: Int): ActiveState = ActiveState(Inventory(id, stock))
        fun createBlocked(id: String, stock: Int): BlockedState = BlockedState(Inventory(id, stock))
    }

    fun addStock(amount: Int) {
        /**
         * Will be responsibility of the current State.
         * i.e.
         * If state == BlockedState, addStock method will throw an exception
         * If state == ActiveState, addStock method will proceed to execute the business rule for adding more stock
         */
        state.addStock(amount)
    }

    fun transitionTo(newState: InventoryState) {
        // TODO: Create domain exceptions
        // if (!state.canTransitionTo(newState)) throw InventoryCannotBeTransitionedException(id, newState.toString())

        state = newState
    }
}
