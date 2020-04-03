# aliexpress-demo

## Main components

The code in this demo is based upon a Test Automation Framework (TAF) which uses the following stack:

* Selenium WebDriver
* Java
* Cucumber

Selenium WebDriver is the set of libraries that automate browser interaction, meanwhile Cucumber is the Behaviour Driven 
Development (BDD) approach to specify Software Acceptance Criteria in the form of Scenarios writen in plain language 
(though using a format named Gherkin).

By this [project sample, Gherkin formatted scenarios are written in the src/test/resources/features folder.  Step definition classes are 
placed in the src/test/java folder, in the steps package.  In the step definition methods (which link to gherkin steps via a regular expression),
one can find a set of instructions using site objects, which in turn links to page objects and their methods, containing the selenium
webdriver instructions to drive the browser.

Other important classes are:

* AliExpressRunner:  Runs the features by setting feature location, reporting options and glue code.
* Hooks:  creates the setup and teardown methods, by starting the browser, initializing the site object and fetching properties.
* Utils such as Constants, Locators and Util classes.

##Running test

Follow these steps to run the project:

* Copy the properties.example file @ src/test/resources/props folder, and remove the .example extension.
* introduce the url parameter
* make sure you have appropriate chromedriver executable placed in the PATH
* Run the AliExpress class in the 'runners' package.
