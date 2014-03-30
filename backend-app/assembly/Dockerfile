#Run Grocery app
FROM dockerfile/java

# Add grocery app
ADD target/lib/ /grocery/lib
ADD target/assembly-1.0-SNAPSHOT.jar /grocery/grocery.jar

# Expose the port
EXPOSE 9090

CMD ["java", "-jar", "/grocery/grocery.jar"]

