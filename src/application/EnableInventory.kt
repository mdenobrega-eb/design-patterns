package designpatterns.application

import designpatterns.domain.InventoryNotFound
import designpatterns.domain.InventoryRepository
import designpatterns.domain.PaymentMethod
import designpatterns.domain.state.ActiveState

/**
 * This Use Case will enable Inventory
 */

class EnableInventory private constructor(): BaseUseCase {
    companion object {
        private lateinit var inventoryRepository: InventoryRepository
        private lateinit var PaymentMethod: PaymentMethod

        operator fun invoke(id: String) {

            // Search the desired object in the database
            val inventoryDomain = inventoryRepository.findById(id) ?: throw InventoryNotFound(id)

            // Build the desired state
            val activeInventory = ActiveState(inventoryDomain)

            // Execute the business rule defined in the domain.
            // Only the domain can mutate its attributes through its methods
            inventoryDomain.transitionTo(activeInventory)

            // Persist the mutated object
            inventoryRepository.save(inventoryDomain)

            PaymentMethod.charge(inventoryDomain.amount)
        }
    }
}
