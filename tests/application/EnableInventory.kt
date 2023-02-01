package application

import designpatterns.domain.Inventory
import designpatterns.domain.InventoryRepository
import designpatterns.domain.PaymentMethod
import designpatterns.infrastructure.persistence.MySQL.MySQLInventoryRepository

class EnableInventory {
    companion object {
        // Mocked
        private lateinit var inventoryRepository: MySQLInventoryRepository

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