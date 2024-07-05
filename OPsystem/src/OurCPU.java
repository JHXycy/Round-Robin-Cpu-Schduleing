public class OurCPU
{
//Constructor
public OurCPU(int tq)
{
timeQuantum = tq;
noOfCompletedProcesses = 0;
}
//Method run()
public int run(OurProcess pr)
{
//Check
if(pr.getBurstTimeRemaining()>timeQuantum)
{
pr.updateBurstTimeRemaining();
return timeQuantum;
}
//Check
else if(pr.getBurstTimeRemaining()<timeQuantum)
{
int run = pr.getBurstTimeRemaining();
pr.updateBurstTimeRemaining();
noOfCompletedProcesses++;
return run;
}
//Otherwise
else
{
pr.updateBurstTimeRemaining();
noOfCompletedProcesses++;
return timeQuantum;
}
}
//Method getNoOfCompletedProcesses()
public int getNoOfCompletedProcesses()
{
return noOfCompletedProcesses;
}
//Declare
private int timeQuantum;
private int noOfCompletedProcesses;
}