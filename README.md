## Grocery
This is my playground application. The goal of this application is:

* Creating a modern scalable app using all kind of new technology and tools
* Creating a reference for [the clean architecture](http://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html)
* Creating a DevOps friendly environment and everything around it 

#### v1.3
Playing around with version, i reverted back to using the development version 1.0-SNAPSHOT.

Adding the assembly module that builds a docker image.

#### v1.2
My primary goal is having the modules be independent, all the modules can be build or used separately but to simplify
the development process it makes more sense to have a proper build structure.

Instead of having the main in the rest-api module I chose to have a separate module (main) where the bootstrap and
dependency injection are being handled. This way the rest-api module only has one responsibility: providing a rest-api.

#### v1.1
Using a parent pom to share the dependencies. The projects are not build from the parent because I want to force the
separation of the modules.

#### v1
Core app grocery list present, rest api (routes) are only present



