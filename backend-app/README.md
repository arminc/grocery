This is the backend of the Grocery application.

### Modules
There are 3 modules:
1. app (the actual backend of the Grocery application)
2. assembly
3. integration-test

The assembly and integration-test modules were first only build as a part of a profile "int" but this is gone. The full
backend depends on the two modules (assembly and integration-test) so there is no point in hiding them behind a profile.

But the goal is to be able to develop, build and run the backend Grocery application needing to install Docker. To
achieve this the app module is a separate module and contains the actual backend.