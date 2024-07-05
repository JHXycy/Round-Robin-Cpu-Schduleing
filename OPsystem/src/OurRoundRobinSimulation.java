import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//Class
public class OurRoundRobinSimulation
{
//Driver
public static void main(String[] args)
{
Scanner in = new Scanner(System.in);
//Prompt
System.out.print("Enter time quantum for processes: ");
//Read
int timeQuantum = in.nextInt();
//Prompt for file input
System.out.print("Enter file name: ");
ArrayList<OurProcess> pr = new ArrayList<OurProcess>();
//Try block
try
{
String fname = in.next();
File infile = new File(fname);
Scanner fileinput = new Scanner(infile);
//Loop
while(fileinput.hasNextLine())
{
String processLine = fileinput.nextLine();
int ii = 0;
String[] strarr=processLine.split(",");
int processNumber = Integer.parseInt(strarr[0]);
int processArrivalTime = Integer.parseInt(strarr[1]);
int processBurstTime = Integer.parseInt(strarr[2]);
pr.add(new
OurProcess(processNumber,processArrivalTime,processBurstTime,timeQuantum));
}
}
//Catch block
catch(FileNotFoundException e)
{
e.printStackTrace();
}
//Create instance
OurSimulation s = new OurSimulation(pr,timeQuantum);
//Run
s.execRoundRobinSimulation();
//End
System.out.println("End of simulation");
}
}

