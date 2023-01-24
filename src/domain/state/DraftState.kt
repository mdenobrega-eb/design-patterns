package designpatterns.domain.state

import designpatterns.domain.InventoryState
import designpatterns.domain.Inventory as InventoryDomain

class DraftState(inventory: InventoryDomain) : InventoryState(inventory) {

    /**
     * Inventories in Draft can transition to Blocked or Active states
     */
    override fun canTransitionTo(newState: InventoryState): Boolean {
        return newState is ActiveState ||
            newState is BlockedState
    }

    override fun addStock(amount: Int) {
        // TODO: In Draft state we do nothing or throw a domain exception
    }
}
