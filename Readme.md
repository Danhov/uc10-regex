## App Description

Simple application to validate string against a set of predefined conditions it
should satisfy. Validation is done via regural expression.

## Implementation Details

Regex uses a set of lookahead blocks to check all conditions.

## How to run locally

1. Make sure you have java 17 or above
    * BTW, please change Use Case instructions document, which says to use `Java 8` or higher.
      I had an issue with SonarCloud integration when using `Java 8`, at least for Gradle apps. Minimal working version
      is `Java 11`.
2. Clone the project from github.
3. Open terminal and change directory to the one containing this app
4. Run `./gradlew run --args='<string to be validated> <max length param>`
5. You should see result in the log message

### Alternatively you can run executable jar

1. Must have `Java 8`
2. Go to `uc10-regex/app/build/libs`
3. Run `java -jar app.jar '<string to validate>' '<desired max length>'`
4. See result in the terminal