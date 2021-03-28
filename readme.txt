** Johan Åström - Programming Test **

PREREQUISITES:
    Maven - https://maven.apache.org/install.html
    Selenium Web Driver - https://www.selenium.dev/documentation/en/selenium_installation/
    JDK 11 - https://jdk.java.net/java-se-ri/11

INSTRUCTIONS:
    - Create a folder where you want to store the project. In a terminal window, navigate to that folder.
    - Run the following commands:
        git init
        git pull https://github.com/johan-astrom/programming-test
        mvn package
        java -jar target/johan-astrom-programmingtest-1.0.jar
Press enter, and follow the instructions to use the calculators.
mvn package will compile the code and run the unit tests for the isAnagram method in the StringUtilities class.
    To only run the unit tests, type:
        mvn test

com.johanastrom.calculator contains the Calculator class
com.johanastrom.stringutilities contains the StringUtilities class, with the isAnagram method
com.johanastrom.userinteraction contains the CalculatorUserInteraction class, with the menu method for interacting with the calculator.
com.johanastrom.webutilites contains the WebUtilities class with the printWebLinks method, which uses the Selenium Web Driver to scan pages for weblinks.
