package infrastructure.persistence

import application.EnableInventory
import designpatterns.domain.Inventory
import designpatterns.domain.PaymentMethod
import designpatterns.infrastructure.persistence.MySQL.MySQLInventoryRepository

class EnableInvetory {
    companion object {
        // Mocked
        private lateinit var inventoryRepository: InMemoryBase

        // Mocked
        private lateinit var PaymentMethod: PaymentMethod

//        Given-When-Then
        test("It should save in database when I call the use case") {
            // Arrange
            val inventory = Inventory("hola", 123)
            inventoryRepository.findById(inventory.id) shouldReturn inventory

            // Act
            val useCase = EnableInventory(
                inventoryRepository,
                PaymentMethod
            )

            // Assert
            inventoryRepository shouldCalled 1
            PaymentMethod called 1
        }
    }
}