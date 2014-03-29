Assembly module is responsible of building a independently runnable Grocery app using Docker. It first makes the Grocery
app runnable jar with the required dependencies and then it builds the docker image under the "armin/grocery:v1"

### Run
##### Run the image
> docker run -i -t armin/grocery:v1 bash

##### Run the grocery app
> docker run -i -rm -t armin/grocery:v1

### Build
> docker build -rm -t armin/grocery:v1 .