# Software-Testing-Mini-Campaign
The main variables to be edited are found in the java file present in the src folder. They are filePath1, filePath2 and filePathOut. filePath 1 and 2 indicate the location of the targeted CSV files. filePathOut indicate the location and name of the desired output file.

UML Diagram:
![image](https://user-images.githubusercontent.com/101720748/178131375-ab7d3c5d-81c3-422c-9541-ddefa4df6df1.png)

The following two sites were used as reference:

https://javaconceptoftheday.com/compare-two-text-files-in-java/#:~:text=Step%201%20%3A%20Define%20two%20BufferedReader,text%20files%20line%20by%20line.&text=Step%202%20%3A%20Initialize%20areEqual%20with,content%20of%20input%20files%20differ.

https://www.w3schools.com/java/java_files_create.asp


Equivalence Classes:
Files entered are invalid: 
File not a CSV: This enables us to return the correct error message so that the user is able to correctly identify the reason the program does not work.
 
Files entered are valid: 
No differences, half the file is different and file is completely different: This allows us to check to see if the algorithm itself is functional. As such, no difference and completely different are the boundary points, with half the file being different the middle value.

Files of different lengths:
File 1 is empty, File 2 is empty, File 1 is half the length of File 2, File 1 and 2 has random empty lines: This test the main while loop which should identify when one file ends and appends the remaining values as not present in the other file. File 1 and 2 being empty represent boundary points. Meanwhile, File 1 being half the length of File 2 (and a test case for vice versa) would be one middle point. The last middle point is if File 1 and 2 have random empty lines. This analysis was actually helpful as I have missed the potential of both files conicdentally containing a blank space at the same line in the middle of them. This would preemptively terminate the program and result in the identified errors being truncated too early.

Files compared have different variables: 

File 1 has some missing columns, File 2 has some missing columns, both files have some missing columns:
In this example, the output expected should contain all values for both files. File 1 and missing columns are considered the end cases while them both having some missing cases represent the middle value.
