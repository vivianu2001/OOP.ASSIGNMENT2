# OOP.ASSIGNMENT 2 Part 1
The purpose of this project is counting number of lines in set of text files.
In class Ex2_1 we have the functions below:


# createTextFiles
first of all we make by request from the main n files, the seed and bound variables are for randomly choose the number of lines in each file. If file created, printed "file_x.txt created" if the file already exists also printed file_x.txt exists,For preventing errors.
The function returns array of strings,containing the file names.

 # getNumOfLines
The function do basic process of counting lines with while loop in each file till the end of the file. Calculating total number of lines in given files from the array.

# getNumOfLinesThreads
The propose of this function is also to calculate total number of lines using threads.
In this function we use LinesCounterThread class,extends from Thread.
Creating LinesCounterThread array, for each file we create object of LinesCounterThread to count the lines with a thread. Using join to wait for all calculates to complete.After all threads are completed 
sum the total lines.
This function using threads separately for each file,the process is correct organized and faster.
But in large numbers of files,make large number of thread  might have two negative effects. First, when a fixed quantity of work is divided among too many threads, each thread receives so little work that the overhead associated with initiating and stopping threads overwhelms the productive work. Second, running an excessive number of threads results in overhead due to the way they compete for limited hardware resources.


# Uml Diagram
![img.png](img.png)
