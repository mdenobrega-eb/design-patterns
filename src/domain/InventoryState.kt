package designpatterns.domain

import designpatterns.domain.Inventory as InventoryDomain

/**
 * State Machine Design Pattern
 *
 * State is a behavioral design pattern that lets an object alter its behavior when its internal state changes.
 *
 * This class will be the definition for the rest of the States.
 * Methods should have their own behavior in every State.
 *
 * @link https://refactoring.guru/design-patterns/state
 */
abstract class InventoryState(open val inventory: InventoryDomain) {
    abstract fun canTransitionTo(newState: InventoryState): Boolean
    abstract fun addStock(amount: Int)
}
