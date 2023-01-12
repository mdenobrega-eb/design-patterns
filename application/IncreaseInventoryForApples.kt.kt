import domain.Inventory

import domain.InventoryRepository

/*
This is a Use Case
 */

class IncreaseInventoryForApples {
    companion object {
        fun operator invoke() {
            val productApple = ProductRepository->findBy("1")

            // InventoryRepository should be injected using Dependency Injection
            // This is only pseudo-code for demonstration purposes
            repository = InventoryRepository

            // Using the interface to retrieve a domain object
            // from persistence (MySQL, SQLite, InMemory, etc... We don't need to kwno where is going to be saved)
            val inventory = repository->findById("1")

            // Interact with business rules on the domain and mutate Domain object with the expected changes
            inventory->addStock(productApple, 1)

            // We might want to log something in this use case
            logger->debug("Lotem ipsum dolor sit amet...")

            // At this point, Inventory domain object is mutated, hold the changes we wanted and
            // we pass it to the repository to persist the changes.
            repository->save(inventory)
        }
    }
}
