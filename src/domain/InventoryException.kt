package designpatterns.domain

open class InventoryException(override val message: String) : Exception(message)

data class InventoryNotFound(val id: String) : InventoryException("Inventory $id Not Found")
