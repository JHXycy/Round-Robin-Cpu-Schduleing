public class OurProcess
{
//Constructor
public OurProcess(int pNum, int aT, int bT, int tq)
{
processNumber = pNum;
arrivalTime = aT;
burstTime = bT;
timeQuantum = tq;
contextSwitch=0;
waitTime = 0;
turnAroundTime=0;
arrivalTimeInitial =0;
burstTimeInitial=0;
}
//Method getPNum()
public int getPNum()
{
return processNumber;
}
//Method setArrivalTimeInitial()
public void setArrivalTimeInitial()
{
arrivalTimeInitial = arrivalTime;
}
//Method getArrivalTimeInitial()
public int getArrivalTimeInitial()
{
return arrivalTimeInitial;
}
//Method getPArrivalTime()
public int getPArrivalTime()
{
return arrivalTime;
}
//Method updateArrivalTime()
public void updateArrivalTime(int runtimeCPU)
{
arrivalTime = arrivalTime - runtimeCPU;
//Check
if(arrivalTime<0)
{
arrivalTime = 0;
}
}
//Method setBurstTimeInitial()
public void setBurstTimeInitial()
{
burstTimeInitial=burstTime;
}
//Method getBurstTimeInitial()
public int getBurstTimeInitial()
{
return burstTimeInitial;
}
//Method setPresentWaitTime()
public void setPresentWaitTime(int runtimeCPU)
{
waitTime = waitTime +runtimeCPU;
}
//Method getTotalWaitTime()
public int getTotalWaitTime()
{
return waitTime;
}
//Method updateBurstTimeRemaining()
public void updateBurstTimeRemaining()
{
burstTime=burstTime - timeQuantum;
//Check
if(burstTime<0)
{
burstTime=0;
}
}
//Method getBurstTimeRemaining()
public int getBurstTimeRemaining()
{
return burstTime;
}
//Method updateContextSwitch()
public void updateContextSwitch()
{
contextSwitch++;
}
//Method getContextSwitch()
public int getContextSwitch()
{
return contextSwitch;
}
//Method setTurnAroundTime()
public void setTurnAroundTime()
{
turnAroundTime = this.getTotalWaitTime() + this.getBurstTimeInitial();
}
//Method getTurnAroundTime()
public int getTurnAroundTime()
{
return turnAroundTime;
}
//Method getPresentProcessInfo()
public void getPresentProcessInfo()
{
//Display
System.out.println("-----------------------------------------");
System.out.println("Process Name:" + processNumber);
System.out.println("Process remaining burst time:" + getBurstTimeRemaining());
System.out.println("Time until ready to enter ready queue:" + getPArrivalTime());
System.out.println("Process ready to enter ready queue:" +
verifyIfReadytoExecute());
System.out.println("Process context switch:" + contextSwitch);
System.out.println("Process total waiting time:" + getTotalWaitTime());
System.out.println("Process total turnaround time:" + getTurnAroundTime());
System.out.println("-----------------------------------------");
System.out.println();
}
//Method verifyIfProcessFinished()
public int verifyIfProcessFinished()
{
//Check
if(getBurstTimeRemaining()==0)
{
return 1;
}
//Otherwise
else
return 0;
}
//Method verifyIfReadytoExecute()
public boolean verifyIfReadytoExecute()
{
//Check
if (getPArrivalTime() == 0)
{
return true;
}
//Otherwise
else
return false;
}
//Declare
private int processNumber;
private int arrivalTime;
private int burstTime;
private int timeQuantum;
private int contextSwitch;
private int waitTime;
private int turnAroundTime;
private int arrivalTimeInitial;
private int burstTimeInitial;
}