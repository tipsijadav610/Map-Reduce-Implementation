# Map Reduce Implementation

## Task 1
Write Map Reduce program to compute following from the file:\
`SELECT eno, name, gender from employee where salary > 30000;`

## Task 2
Considering same above, write map reduce program to compute following from the file:\ 
`SELECT dno, min(salary), avg(salary), max(salary) from employee group by dno;`

## Task 3
Create another Map Reduce program that reads from web access log file, and outputs following summaries on Monthly Basis –\
$~$ (a) Total number of requests.\
$~~~$ (b) Total downloaded size.\
It should output: <Year-Month, Number of Requests, Download Size> for every months like Dec-2016, Jan-2017, and so!

## Task 4
Create another Map Reduce program that lists Timestamp, URL for which http response status has been 404. 
