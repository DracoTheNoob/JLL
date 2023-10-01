# JavaLoggingLibrary #

## Introduction ##
The displayed message will be based on the following syntax :
```
[logType][HH:MM:SS][callingThread][callingClass#callingMethod]: message

* logType => {'?'=info; '#'=warn, '!'=error}

* HH => The hour when the log method is called
* MM => The minute when the log method is called
* SS => The second where the log method is called

* callingThread => The thread where the log method is called from
* callingClass  => The class where the log method is called from
* callingMethod => The method where the log method is called from

* message => The message that you want to display


For example, if I call the Log#warn function from :
- A Test.java class
- A #main(String... args) function
- At 13hours, 42 minutes, and 52 seconds
- The main thread
- A message containing : "This is a warn"

The message would be :
[#][13:42:52][main][Test#main]: This is a warn
```

## Use the library ##
### Init the library ###
To use the library, your first need to specify the directory which will store the log files, by writing the following line :
```java
Log.setDirectory(new File("path"));
```
You can only specify the path using the same function name :
```java
Log.setDirectory("path");
```

### Print objects ###
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