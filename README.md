# CE201 2021-2022 Group 07-3

The project itself is in the `project` folder, all required libraries are in the `project/lib` folder. The libraries
can alternatively be downloaded via Maven

## Libraries used

- jfreechart
- pdfbox-2.0.24
- fontbox-2.0.24
- pdfbox-app-2.0.25
- junit.jupiter

## How to run from source

The main function is located within `project/src/gui/MainGUI.java` and program execution is expected to begin here.

On application launch, the program will create a `resources` folder, which will be home to the cached CSV file it will
automatically download on first launch, as well as any PDF files generated.

## How to run via Jar

The final Jar can be found at https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/blob/aa6dbf9330957ce5f9a0cf9165694c100f6f6c27/FinalProduct/project.jar

This Jar will also create a `resources` folder at the same location it is launched from. This resources folder will
also contain any cached CSVs and generated PDF report documents. 
