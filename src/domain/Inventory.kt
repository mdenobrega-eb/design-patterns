package designpatterns.domain

import designpatterns.domain.state.ActiveState
import designpatterns.domain.state.BlockedState
import designpatterns.domain.state.DraftState

/**
 * Inventory is a domain object.
 * This class will model our business rules.
 * The only way to mutate an Inventory object it's through its own methods.
 *
 * In this example, we're using a State Machine to define finite and static States.
 * Inventory must alter its attributes through the State.
 * It's the State the one responsible to execute the behaviour according to every case.
 */
class Inventory private constructor(
    var id: String,
    var stock: Int,
) {
    private lateinit var state: InventoryState

    /**
     * Factory Method Design Pattern
     *
     * Here, we implement static methods that will create new Inventory objects.
     *
     * @link https://refactoring.guru/design-patterns/factory-method
     */
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
