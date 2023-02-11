# Frequency_Analysis
Frequency analysis from various types of text in Python


Frequency analysis consists in determining the frequency of individual characters in the encrypted text. With its help, we can decipher a simple substitution cipher without a key. At first glance, this is a simple algorithm, but if we do not have a long enough text, a few percentage points in the number of characters can also play a role. It is therefore necessary to find specifics for different types of texts, or others, with which we can optimize the frequency analysis.

Objective of the thesis: 

The objective of the thesis is for the author to become familiar with the field of frequency analysis in the context of cryptanalysis and to create a cryptanalytic tool in the Python language for decrypting encrypted text using frequency analysis.

Nature of work: application

Content requirements according to the nature of the work: 
description of the solved problem, 
system/hardware solution design, etc. (models, ..), 
development/creation methodology, 
implementation, 
description of the created solution, 
testing;

Subject prerequisites:
Programming and data structures (1st, BC);
Programming Seminar 1 (1st, BC);
Cryptography (2nd, BC);
Computer data analysis (2., BC)

The most important competences acquired by processing the topic:
computer programming,
develop data processing applications,
software system for statistical analysis,
perform analytical mathematical calculations,
report on the results of the analysis



## Software

(1) Python Python 3.11.1: https://www.python.org/downloads/
```java
py --version
Python 3.11.1
```
(2) Eclipse 4.16: https://archive.eclipse.org/eclipse/downloads/drops4/R-4.16-202006040540/

(3) Java https://adoptium.net/temurin/releases/<br>
```java
java -version
openjdk version "1.8.0_362"
OpenJDK Runtime Environment (Temurin)(build 1.8.0_362-b09)
OpenJDK 64-Bit Server VM (Temurin)(build 25.362-b09, mixed mode)
```
(4) Git: https://git-scm.com/download/win

(5) Python IDE: Pycharm Community Version<br>
https://www.jetbrains.com/pycharm/download/other.html

(6) Apache Maven apache-maven-3.8.7<br>
https://maven.apache.org/download.cgi


## Custom Configuration
The plugins dependencies in our pom.xml.<br>
- The main class in the plugin's configuration is :
```java
	<plugin>
		<groupId>org.codehaus.mojo</groupId>
		<artifactId>exec-maven-plugin</artifactId>
		<version>3.0.0</version>
		<configuration>
			<mainClass>cryptanalytic.tool.ui.MainWindow</mainClass>
		</configuration>
	</plugin>
```
- Compiling and Executing the app<br>

Compiling
```java
mvn clean install -U
```
Executing
```java
mvn compile exec:java
```
