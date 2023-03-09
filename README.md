# Frequency Analysis Project
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
python --version
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

(5) Apache Maven apache-maven-3.8.7<br>
https://maven.apache.org/download.cgi

(6) Installing Python also installs pip.
pip is the standard package manager for Python. It allows you to install and manage additional packages that are not part of the Python standard library.
```java
python -m pip --version
pip 22.3.1
```
(7) Installing matplotlib and pyperclip on Python
```java
python -m pip install matplotlib
py -m pip install pyperclip
```


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

# How to Call Python From Java

The best way is using Apache Commons Exec , It works without problems for Java 8 environments, because of the fact 
that it lets you execute any external process (including python, bash etc) in synchronous and asynchronous way by using watchdogs.
```java
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-exec</artifactId>
    <version>1.3</version>
</dependency>
```

# Cracking Caesar-Cipher

There are 2 types of approaches to crack Caesar-cipher:

1.) Brute-force attack: the number of possible key is 26  (English Alphabet) thats why 
considering all these cases (so check all the possible key values)


2.) Frequency-analysis: For example in an english language text some letters are more 
frequent than others  (E, A, O, I and T). Analyzing the ciphertext and based on the most frequent letter 
in the ciphertext we can predict the key (so the number of shifts)
