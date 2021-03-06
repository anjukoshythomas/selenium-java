# Test Automation using Java and Selenium WebDriver

#### BrowserFactory class
This Factory class is a Java enum that has all implemented browsers to use during the test execution.
Each browser is an enum, and each enum implements two methods:
* `createDriver()`: creates the browser instance for the local execution. The browser driver is automatically managed by the WebDriverManager library
* `getOptions()`: creates a new browser Options setting some specific configurations. It's used for the remote executions

You can see that the `createDriver()` method used the `getOptions()` to use specific configuration, as starting the browser maximized and others.
The `getOptions()` is also used for the remote execution as it is a subclass of the `AbstractDriverOptions` and can be
automatically accepted as either a `Capabilities` or `MutableCapabilities` class, which is required by the `RemoteWebDriver` class.

The pre-condition uses `@BeforeMethod` from TestNG creates the browser instance based on the values passed either local or remote execution.
The post-condition uses `@AfterMethod` to close the browser instance.
Both have the `alwaysRun` parameter as `true` to force the run on a pipeline.

Pay attention that it was designed to open a browser instance to each `@Test` located on the test class.


### Logging
All the log is done by the Log4J using the `@Log4j2` annotation.

The `log4j2.properties` has two strategies: console and file.
A file with all the log information will be automatically created on the user folder with `test_automation.log` filename.
If you want to change it, update the `appender.file.fileName` property value.

The `log.error` is used to log all the exceptions this architecture might throw. Use `log.info` or `log.debug` to log
important information, like the users, automatically generated by the factory


### Configuration files
You can find the class related to the property
file reader in the following classes:
* [Configuration] Configuration.java
* [ConfigurationManager] ConfigurationManager.java

There are 3 properties (configuration) files located on `src/test/java/resources/`:
* `general.properties`: general configuration as the target execution, base url, timeout, and faker locale
* `grid.properties`: url and port for the Selenium grid usage
* `local.properties`:  browser to use in the local execution

The properties were divided into three different ones to better separate the responsibilities and enable the changes easy
without have a lot of properties inside a single file.

### Test Data Factory
Dynamic Testdata for Email and Password are generated from TestData.java and TestDataBuilder.java

Reading reference: https://reflectoring.io/objectmother-fluent-builder

### Profiles executors on pom.xml

There is a profile called `web-execution` created to execute the test suite `local.xml` inside `src/test/resources/suites` folder.
To execute this suite, via the command line you can call the parameter `-P` and the profile id.

Eg: executing the multi_browser suite
``` bash
mvn test -Pweb-execution -Dtestng.dtd.http=true 
```

If you have more than one suite on _src/test/resources/suites_ folder you can parameterize the xml file name.
To do this you need:

* Create a property on `pom.xml` called _suite_

```xml
    <properties>
  <suite>local</suite>
</properties>
```

* Change the profile id

```xml
<profile>
  <id>web-execution</id>
</profile>   
```

* Replace the xml file name to `${suite}` on the profile

```xml
<configuration>
  <suiteXmlFiles>
    <suiteXmlFile>src/test/resources/suites/${suite}.xml</suiteXmlFile>
  </suiteXmlFiles>
</configuration>
```

* Use `-Dsuite=suite_name` to call the suite

````bash
mvn test -Pweb-execution -Dsuite=local -Dtestng.dtd.http=true 
````

Test results

![img.png](img.png)
