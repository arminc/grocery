#Run Grocery app
FROM dockerfile/java

# Add grocery app
ADD target/lib/ /grocery/lib
ADD target/assembly-1.0-SNAPSHOT.jar /grocery/grocery.jar

CMD ["java", "-jar", "/grocery/grocery.jar"]

