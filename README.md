# Processing-files-project

**ATTENTION**: Before using the project, please ensure that a ***files*** directory is created in the root of the project. Additionally, *Rar.exe* and *UnRAR.exe* files must be present in the root directory.

## Project Description

This Java project is an application for processing and managing files in various formats, including plain text (.txt), JSON (.json), and XML (.xml). It supports file archiving (ZIP, RAR) and encryption using AES. The application incorporates object-oriented principles and offers two methods for file processing: manual and library-based. For encryption and decryption, it uses the Java Cryptography Architecture (JCA) with AES. It also includes functionality for evaluating mathematical expressions through three methods: using the Javaluator API, a custom function with Polish notation, and regular expressions. The project features both a Command-Line Interface (CLI) and a Graphical User Interface (GUI), created with JavaFX.

## File Processing

The application can work with files in the following formats:
- **plain text (.txt)**
- **JSON (.json)**
- **XML (.xml)**

Files can be archived and/or encrypted using different algorithms. File processing involves reading data from an input file, performing specific operations on the file content, and writing the results to an output file. File formats and the need for archiving or encryption are specified via command-line parameters.

### Working with file content

The application implements two methods for processing data:
1. **Manual Processing**: Uses standard logic and methods without external libraries.
2. **Library-Based Processing**: Utilizes specialized libraries for working with data formats.

For processing **JSON** files, the project uses the [JSON-Java](https://stleary.github.io/JSON-java/index.html) library, also known as `org.json`. This library provides convenient methods for parsing, processing, and generating JSON data, significantly simplifying work with JSON files in the project.

For processing **XML** files, the project utilizes the [JAXB API](https://javaee.github.io/jaxb-v2/). This API allows easy conversion between XML files and Java objects, making the work with XML data more convenient and structured.

For processing **TXT** files, the project uses standard Java language tools. These tools offer basic functions for reading, processing, and writing text data, ensuring simplicity and flexibility when working with text files.

### Archiving

This project implements support for working with two types of archives:
- **ZIP**
- **RAR**

For handling **ZIP** archives, the project uses the `java.util.zip` package. This package provides classes for reading and writing ZIP file formats, allowing the application to easily compress and decompress files in this format.

For processing **RAR** archives, the project utilizes process execution through `ProcessBuilder`. This approach enables the application to launch external processes, specifically *Rar.exe* and *UnRAR.exe*, to handle RAR files. This method allows the application to interact with RAR archives by leveraging existing command-line tools for compression and decompression.

### Encryption

The project implements file encryption and decryption using **Java Cryptography Architecture (JCA)**. The **AES (Advanced Encryption Standard)** algorithm was selected for encryption. This algorithm is used for symmetric block encryption of data.

Key components used in the encryption process include:

- **Cipher Class from the `javax.crypto` package**: This class is a core part of JCA and is used for performing cryptographic operations such as encryption and decryption.

- **SecretKeySpec Class from the `javax.crypto.spec` package**: This class is used to create a key object, which is then utilized by the Cipher for encryption and decryption operations. The key is provided as a string and converted to bytes for use with the AES algorithm.

The code also includes handling of various exceptions related to cryptographic operations, including `NoSuchAlgorithmException`, `InvalidKeyException`, `NoSuchPaddingException`, as well as input/output exceptions like `IOException`. All of these exceptions are processed and wrapped into a custom exception, `CryptoException`, to simplify error handling.

## Expression Evaluation

Files may contain mathematical expressions with variables. The application checks the correctness of expressions, including:
- Proper matching of opening and closing parentheses.
- Verification that all necessary variables are present.
- Validation of mathematical operations.

For evaluating mathematical expressions, users have three methods to choose from:

1. **Using an API**: The project uses the [Javaluator](https://github.com/fathzer/javaluator), a Java infix evaluator based on the "Shunting Yard" algorithm. This API simplifies the process of evaluating expressions by handling parsing and computation.

2. **Using a Function**: This method involves implementing the Polish notation (prefix notation). Before actual computation, expressions are converted to prefix notation to facilitate evaluation.

3. **Using Regular Expressions**: This approach searches for deepest nested expression of the type `(...)`. The deepest expression is evaluated first, and then replaced with its result in the original expression.

After selecting one of these methods, variables are replaced with their values, and the conditions described above are checked. During calculation process, if any errors occur with a particular expression, the user receives a specific error message, and that expression is not computed.

## Design Pattern

To familiarize with design patterns, the **Builder** pattern is implemented in this project. It is used in the `GeneralModifier` class to prevent the passing of unnecessary parameters when executing methods. Depending on the needs, parameters may include: archive name, save folder, archiving and encryption methods, and encryption password.

The Builder pattern is applied to improve the flexibility and scalability of the application. It allows for a more organized and manageable approach to constructing complex objects with various configurations, ensuring that only the necessary parameters are included in each instance.

## User Interface

The application provides two interface options:
1. **Command-Line Interface (CLI)**: Supports command and parameter input via the command line.
2. **Graphical User Interface (GUI)**: Implemented using [JavaFX](https://github.com/openjdk/jfx), a popular Java library for creating modern user interfaces. JavaFX provides rich user interface components and features to enhance the application's usability.

## Testing

The project utilizes [JUnit](https://github.com/junit-team/junit5/) for testing to ensure the correctness and reliability of its functionality. JUnit provides a framework for writing and running unit tests in Java, allowing for comprehensive verification of the application's features and logic. Tests are designed to cover various aspects of the application, including file processing, encryption, and expression evaluation, ensuring that all components perform as expected and any issues are promptly identified and addressed.

## Conclusion

The project provides powerful tools for file processing and analysis, supporting flexibility in using various methods and approaches. It covers a broad range of knowledge and skills, from file handling and design patterns to user interface creation.