# JavaLoggingLibrary #

## Init the library ##
To use the library, your first need to specify the directory which will store the log files, by writing the following line :
```java
Log.setDirectory(new File("path"));
```
You can only specify the path using the same function name :
```java
Log.setDirectory("path");
```

## Print objects ##
To print an object to the console and log file, use this :
```java
Log.info(object);
```

If you want to print a warn, use :
```java
Log.warn(object);
```

And if your message is an error, use :
```java
Log.error(object);
```