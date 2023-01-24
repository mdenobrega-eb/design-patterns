package designpatterns.infrastructure.persistence.inmemory

import designpatterns.domain.InventoryRepository
import designpatterns.domain.Inventory as InventoryDomain

class InMemoryInventoryRepository() : InventoryRepository {
    override fun findById(id: String): InventoryDomain? {
//        conn = inmemory.connect()
//
//        query = "select * from a where a.id = id";
//
//        result = inmemory.query(query)
//
//        if (result) {
//            return null
//        }
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
