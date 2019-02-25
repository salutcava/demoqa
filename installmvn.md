# Install Apache Maven

To install  [Apache Maven](http://maven.apache.org/)  on Windows, you just need to download the Maven’s zip file, unzip it to a folder, and configure the Windows environment variables.

Tested with :

1.  JDK 10
2.  Maven 3.6
3.  Windows 10

**Note**

1.  Maven 3.3+ requires JDK 1.7+
2.  Maven 3.2 requires JDK 1.6+
3.  Maven 3.0/3.1 requires JDK 1.5+

## 1. JDK and JAVA_HOME

Make sure JDK is installed, and  `JAVA_HOME`  environment variable is configured.

![image](/uploads/acad58c8e8b8384981b5c5455aee4571/image.png)

## 2. Download Apache Maven

2.1 Visit  [Maven official website](http://maven.apache.org/download.cgi), download the Maven zip file, for example :  `apache-maven-3.6.0-bin.zip`.

![image](/uploads/6c913cdac414dbabb14edf358d6ea951/image.png)

2.2 Unzip it to a folder. In this article, we are using  `c:\apache-maven-3.6.0`

![image](/uploads/a17884a351e8b3e3673e956ec5253fc8/image.png)

**Note**  
That’s all, just download and unzip, installation is NOT required.

## 3. Add MAVEN_HOME system variable

Add a  `MAVEN_HOME`  system variables, and point it to the Maven folder.

3.1 Press Windows key, type  `Afficher les paramètres système avancés`

![image](/uploads/c34f8b66783fbc81b3e0ed9dedea462c/image.png)

3.2 In System Properties dialog, select  `Paramètres système avancés`  tab and clicks on the  `Variables d'environnement...`  button.

![image](/uploads/9ffe5810ce2f210f0d4e46ecff94fcc3/image.png)

3.3 In “Variables d'environnement” dialog,  `Variables système`, Clicks on the  `Nouveau...`  button and add a  `MAVEN_HOME`  variable and point it to  `c:\apache-maven-3.6.0`

![image](/uploads/7376db6a48780416b14b6b3cd6c3e13a/image.png)

## 4. Add %MAVEN_HOME%\bin To PATH

In system variables, find  the `PATH` variable (can be Path), clicks on the  `Modifier...`  button. In “Modifier la variable d'environnemnet” dialog, clicks on the  `Nouveau`  button and add this  `%MAVEN_HOME%\bin`

![image](/uploads/2dd15de4b11215281f62815536d050b4/image.png)

## 5. Verification

Done, start a new command prompt, type  `mvn –version`  :

```bash
C:\>mvn -version
C:\Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: C:\apache-maven-3.6.0\bin\..
Java version: 1.8.0_191, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_191\jre
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

C:\>echo %MAVEN_HOME%
C:\apache-maven-3.6.0

```

### The Apache Maven is installed successfully on Windows.
