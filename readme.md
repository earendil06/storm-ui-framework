Goal : Framework to easily write UI tests using JUnit and Selenium with headless browsers on docker

###### Deploy the docker selenium ecosystem with docker compose:
- hub
- clients (browsers)
```
version: '2'
services:
  hub:
    image: "selenium/hub"
    ports:
    - "4444:4444"
    
    
  selenium-chrome:
    image: "selenium/node-chrome"
    depends_on:
      - hub
    environment:
      HUB_HOST: hub
      
      
  selenium-OTHER:
    image: IMAGE_NAME
      depends_on:
        - hub
      environment:
        HUB_HOST: hub
```

(see selenium images on dockerhub)

###### Write tests with the framework :
- Compatibilities : junit 4.12 and selenium-java 3.141.59

```java
@UseBrowser(url = "http://localhost:4444/wd/hub", browser = "chrome") //url of the hub
@UseBrowser(url = "http://localhost:4444/wd/hub", browser = "chrome")
@RunWith(StormRunner.class) //Specify the runner
public class MainTest extends StormUITest { //extends StormUITest

    @Test
    public void test1() {
        ...
    }

    @Test
    public void test2() {
        ...
    }
}
```
