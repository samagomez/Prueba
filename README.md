# Project automation template

Installation and execution guide of the automation project whose scope is to automate Web projects (Local or virtualized), mobile (Android and iOS).

## ⚠️ Requirements ⚠️

1. Installing [Android Studio](https://developer.android.com/studio).

2. Install or update [NodeJS](https://nodejs.org/en/) to LTS version 16 or higher.

3. The environment variables must be added:

   3.1. **ANDROID_SDK_ROOT**=C:\Users\REDUSER\AppData\Local\Android\Sdk (Modify your network user) *

   3.2. Add in the environment variable **PATH** the path of the platform_tools= C:\Users\USER DERED\AppData\Local\Android\Sdk\platform-tools (Modify your network user) *

   3.3. **JAVA_HOME**=C:\Program Files\Java\JDK Folder (Modify with the version of the jdk that has been installed) *


4. The following commands must be executed in **cmd** to be able to install a local instance of selenium and appium:

   ```bash
   npm install -g node-modules
   npm install -g appium
   npm install -g selenium
   ```  
    
5. [Git](https://git-scm.co) * must be installed

6. [Eclipse](https://www.eclipse.org/downloads/) will need to be installed *

The points with this sign *, means that a ticket must be added to be able to carry out this action since administrator permission will be needed. As a recommendation, have the installers already downloaded, only **point 4**, no ticket or permission is needed.

## ⌨️Installation⌨️

1. You must clone the [repository](https://github.com/MiguelMirandaPRCR/JourneyPromericaJava) of the project and import the project into the IDE.

## ✔️Considerations✔️

1. The name of the project must be changed with the respective project that is being worked on.

2. After successfully cloning the project, you must disconnect from the repository and then create one in the repository of the project you are working on and upload the project with the modifications that are made to then start working on the automation of the system .

3. The tests that have been automated for the template do not have any asserts added, it will be the job of the QA Automator to add the asserts in your project.

4. You should implement a framework that best suits you for creating reports, it is recommended to use extent report, or the one you already have with testNG.

## 🚀Execution🚀

1. The execution of the automated tests will be done with TestNG using XML files.

2. For the execution of automated tests in apps, remember that the capabilities files must be modified with the corresponding data.

3. Remember that in the XML file that is created for the execution of the tests, the url parameter and the platform that is required to be executed must be specified. For the URL parameter when you want to run a test in an app, you must fill it with the value of **NA**.
