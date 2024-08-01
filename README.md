# Processing-files-project

## Project Description

This project is an application for working with and processing files in various formats, such as plain text, XML, and JSON. The application is implemented using both procedural and object-oriented programming (OOP) approaches. The project uses the Builder design pattern for comparison with classic approaches. The application supports both command-line interface (CLI) and graphical user interface (GUI).

## File Processing

The application can work with files in the following formats:
- **plain text (.txt)**
- **JSON (.json)**
- **XML (.xml)**

Files can be archived and/or encrypted using different algorithms. File processing involves reading data from an input file, performing specific operations on the file content, and writing the results to an output file.

File formats and the need for archiving or encryption are specified via command-line parameters. The application implements two methods for processing data:
1. **Manual Processing**: Uses standard logic and methods without external libraries.
2. **Library-Based Processing**: Utilizes specialized libraries for working with data formats, archiving, and encryption.

## Expression Evaluation

Files may contain mathematical expressions with variables. The application checks the correctness of expressions, including:
- Proper matching of opening and closing parentheses.
- Verification that all necessary variables are present.
- Validation of mathematical operations.

After checking and validating expressions, variables are replaced with their values, and the result is saved to a new file.

## Implementation and Design Patterns

The project was implemented in two ways:

1. **Without Design Patterns**: A classic procedural approach suitable for simple tasks.
2. **Using the Builder Design Pattern**: The Builder pattern is applied to improve the flexibility and scalability of the application.

The results of these two approaches were compared to assess their effectiveness.

## User Interface

The application provides two interface options:
1. **Command-Line Interface (CLI)**: Supports command and parameter input via the command line.
2. **Graphical User Interface (GUI)**: Implemented using one of the popular Java libraries for creating user interfaces.

## Conclusion

The project provides powerful tools for file processing and analysis, supporting flexibility in using various methods and approaches. It covers a broad range of knowledge and skills, from file handling and design patterns to user interface creation.