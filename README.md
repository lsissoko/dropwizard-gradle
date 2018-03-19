# Dropwizard + Gradle = &hearts;

Minimal example of getting Dropwizard `(version 1.0.5)` going with Gradle.

Also includes:

- [dropwizard-configurable-assets-bundle](https://github.com/dropwizard-bundles/dropwizard-configurable-assets-bundle) - resource path configuration
- [Unirest](https://github.com/Kong/unirest-java) - HTTP requests


## Requirements

Java (1.8 or later)

Gradle (I'm running 2.10)


## Build

```
./gradlew clean oneJar
```

The resulting JAR will be saved as `./build/libs/lamine-pascal-1.0.0-standalone.jar`


## Run

```
java -jar build/libs/lamine-pascal-1.0.0-standalone.jar server config.yml
```

Open http://localhost:8000

