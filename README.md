# DateUtility

**Date Utility** is a small java application
which computes the difference in days between two dates.

# Set Up

**Date Utility** requires Java 9. I recommend you use
[SDK Man](http://sdkman.io/) to install it:

```bash
sdk install java 9.0.1
```

If Java 9 is not yet available for your Platform via SDK Man,
then you need to download and install from Oracle's website.

**Date Utility** uses [Gradle](https://gradle.org/) 
for build and test automation. You can use the
provided Gradle wrapper. If you wish to install it globally:

```bash
sdk install gradle 4.4
```

Now we can compile, build, and test with a single command:

```bash
./gradlew clean build
```

To execute the application, first we need to create a
runnable jar file, and then execute it:

```bash
# Build runnable jar
./gradlew installDist

# Execute the App
java -jar build/install/DateUtility/lib/DateUtility-1.0.SNAPSHOT.jar

# Enter dates on the terminal like this:
# 08 01 1995, 24 12 2005
```

# Implementation summary

The main logic of the application is in the `Date` immutable class.
It is constructed by specifying the `day`, `month`, and `year` integers,
which are validated with rules for leap year and month lengths.
The `daysSinceAD` method computes how many days have been since the 
1st day of AD.

The `Interpreter` class takes a line of user input, parses it, and
uses `Date::daysSinceAD` to compute the difference in days between
the provided dates. It validates the input format and the dates.

The `App` class is the entry point of the application and it uses an
instance of the `Interpreter` to respond to interactive user input.

The application logic has been covered with JUnit tests. You can run them
with:

```bash
./gradlew test
```