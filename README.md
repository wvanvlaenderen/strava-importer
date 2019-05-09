# strava-importer
A Kotlin library to wrap the Strava API.
This library is still in an early stage and nowhere near complete. 

In order to use this library you need to register an application with Strava and retrieve your credentials. Currently the library is only able to retrieve your own activities since the oauth2 flow is not yet completely implemented.

#### How to compile
```$xslt
./gradlew build
```

#### How to publish to your local maven .m2 directory
```$xslt
./gradlew build publishToMavenLocal
```

#### How to run a coverage check
```$xslt
./gradlew build jacocoTestCoverageVerification
```

#### How to use the library in a Kotlin application
```kotlin
package quickr.stravaimporter

import quickr.stravaimporter.api.ServiceBuilder

fun main(args: Array<String>) {
    val serviceBuilder = ServiceBuilder.build(
        "<CLIENT_ID>",
        "<CLIENT_SECRET>",
        "<REFRESH_TOKEN>"
    )

    val loggedInAthlete = serviceBuilder.buildAthleteService().getLoggedInAthlete()
    println(loggedInAthlete)

    val athleteStats = serviceBuilder.buildAthletesService().getStats(loggedInAthlete.id!!)
    println(athleteStats)
}
```

#### How to use the library in a Java application
Publish the library your .m2 folder and add the following dependency
```
<dependency>
    <groupId>quickr</groupId>
    <artifactId>strava-importer</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```
```java
import quickr.stravaimporter.api.ServiceBuilder;
import quickr.stravaimporter.api.athlete.Athlete;
import quickr.stravaimporter.api.athlete.AthleteStats;

public class Main {

    public static void main(String[] args) {
        ServiceBuilder serviceBuilder = ServiceBuilder.build(
                "<CLIENT_ID>",
                "<CLIENT_SECRET>",
                "<REFRESH_TOKEN>"
        );

        Athlete loggedInAthlete = serviceBuilder.buildAthleteService().getLoggedInAthlete();
        System.out.println(loggedInAthlete);

        AthleteStats athleteStats = serviceBuilder.buildAthletesService().getStats(loggedInAthlete.getId());
        System.out.println(athleteStats);
    }
}

```
