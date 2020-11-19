## Clean-Architecture with countries-microservice

This project has the intention to be a reference of how clean architecture can be applied to a microservice projects environment.

This clean architecture implementation will be structured on the following component types:

 - InputDelivery (RestControllers, MessagingConsumers) 
 - BusinessUseCases (Services, Facades)
 - Repositories (DatabaseRepositories,CacheRepositories)
 - OutputGateways (RestClients, MessagingProducers)

This project is divided in two main modules:

 1. ***core***
 2. ***infraestructure***

### core
This is where the **BusinessUseCases, Entities, DomainExceptions and Ports** will remain

### infraestructure
This module will contain the **InputDelivery, Repositories & OutputGateways** component implementations.

----

### Run the project  
```groovy  
$ gradle bootRun  
```