# Lesson 1
- Domain.
- Business rules in a domain
- State Machine Design Pattern https://refactoring.guru/design-patterns/state
- Use Cases (Application)

# Lesson 2
- Repository Pattern: mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects
- Interfaces in domain (InventoryRepository)
- Implement interfaces in Infrastructure. Our example contains:
  - a MySQL implementation meant to be used in prod
  - Sqlite implementation meant to be used in testing.
  - InMemory implementation meant to be used in testing (alternative).
- Proposed directory structure to use infrastructure.
- How Use Cases interact with Domain and Infrastructure. This layer is the glue between Domain and Infrastructure.
