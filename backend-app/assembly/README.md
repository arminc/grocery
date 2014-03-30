Assembly module is responsible of building a independently runnable Grocery app using Docker. It first makes the Grocery
app runnable jar with the required dependencies and then it builds the docker image under the "armin/grocery:v1"

### Build module
To build the module use the profile "int"

### Run docker
##### Run the image
> docker run -i -t -p 9090:9090 armin/grocery:v1 bash

##### Run the grocery app in foreground
> docker run -i -rm -t -p 9090:9090 armin/grocery:v1

##### Run the grocery app in background
> docker run -d -t -p 9090:9090 armin/grocery:v1

### Build docker
> docker build -rm -t armin/grocery:v1 .

