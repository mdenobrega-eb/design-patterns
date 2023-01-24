package designpatterns.infrastructure.persistence.SQLite

import designpatterns.domain.InventoryRepository
import designpatterns.domain.Inventory as InventoryDomain

/***
Repository Pattern:
mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects

This is an implementation of InventoryRepository in the domain.

Methods here should receive and return domain objects.
 */
class SQLiteInventoryRepository : InventoryRepository {
    override fun findById(id: String): InventoryDomain? {
        // TODO("Not yet implemented")
        return null
    }

    override fun save(inventory: InventoryDomain) {
        // TODO("Not yet implemented")
    }
}
