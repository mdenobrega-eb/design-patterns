package designpatterns.infrastructure.persistence.MySQL

import designpatterns.domain.InventoryRepository
import designpatterns.domain.Inventory as InventoryDomain

/***
Repository Pattern:
mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects

This is an implementation of InventoryRepository in the domain.

Methods here should receive and return domain objects.
 */

class MySQLInventoryRepository() : InventoryRepository {
    override fun findById(id: String): InventoryDomain? {
//        conn = Mysql.connect()
//
//        query = "select * from a where a.id = id";
//
//        result = Mysql.query(query)
//
//        return InventoryDomain(
//            id = result.id,
//            product = result.product,
//            stock = result.stock
//        )
        return null
    }

    override fun save(inventory: InventoryDomain) {
    }
}
