import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//Class
public class OurSimulation
{
//Constructor
public OurSimulation(ArrayList<OurProcess> pr, int tq)
{
processArrayList = pr;
timeQuantum = tq;
cpu=new OurCPU(timeQuantum);
readyQueue = new LinkedList<OurProcess>();
clock = new OurClock();
completedProcesses = new ArrayList<OurProcess>();
totalNoOfProcessesInSystem = 4;
//Loop
for(int ii =0;ii<pr.size();ii++)
{
pr.get(ii).setArrivalTimeInitial();
pr.get(ii).setBurstTimeInitial();
}
}
//Method execRoundRobinSimulation()
public void execRoundRobinSimulation()
{
TheProcessCreator(null);
RoundRobin();
}
//Method TheProcessCreator()
public void TheProcessCreator(OurProcess presentProcess)
{
//Loop
for(int ii=0;ii<processArrayList.size();ii++)
{
OurProcess pr =processArrayList.get(ii);
//Check
if(pr.verifyIfReadytoExecute()==true && pr.verifyIfProcessFinished()==0 &&
(pr != presentProcess) && !readyQueue.contains(pr))
{
readyQueue.add(pr);
System.out.println("NEW OurProcess " + pr.getPNum() + " added to ready queue");
}
}
}
//Method RoundRobin()
public void RoundRobin()
{
boolean isOk = false;
//Loop
while(!isOk)
{
OurProcess presentProcess = readyQueue.peek();
//Check
if(presentProcess != null)
{
int runTimeOfProcessOnCPU=cpu.run(presentProcess);
clock.updateTimeSinceStartOfSimulation(runTimeOfProcessOnCPU);
clock.updateArrivalTimeOfProcessesWaiting2Get2ReadyQueue(processArrayList,runTimeOfProcessOnCPU);
clock.updateWaitingTimeOfProcessesInReadyQueue(readyQueue,runTimeOfProcessOnCPU,
presentProcess);
TheProcessCreator(presentProcess);
//Check
if(presentProcess.verifyIfProcessFinished()==1)
{
    System.out.println("OurProcess " +
    presentProcess.getPNum() + " completed execution");
    processArrayList.remove(presentProcess);
    System.out.println("OurProcess " +
    presentProcess.getPNum() + " removed from ready queue");
    completedProcesses.add(readyQueue.remove());
    //Check
    if(completedProcesses.size()==totalNoOfProcessesInSystem)
    {
    this.EndSimulation();
    isOk=true;
    }
    }
    //Otherwise
    else
    {
    presentProcess.updateContextSwitch();
    presentProcess.getPresentProcessInfo();
    readyQueue.remove();
    readyQueue.add(presentProcess);
    TheProcessCreator(presentProcess);
    }
    }
    //Otherwise
else
{
clock.updateTimeSinceStartOfSimulation(timeQuantum);
clock.updateArrivalTimeOfProcessesWaiting2Get2ReadyQueue(processArrayList,timeQuantum);
TheProcessCreator(null);
}
}
}
//Method EndSimulation()
public void EndSimulation()
{
int waitTimeOfAllProcessesTotal=0;
int turnAroundTimeOfAllProcessesTotal = 0;
int contextSwitchesOfAllProcessesTotal = 0;
int wait = 0;
//Loop
for(int ii =0;ii<completedProcesses.size();ii++)
{
completedProcesses.get(ii).setTurnAroundTime();
}
int pr1TurnAround= completedProcesses.get(0).getTurnAroundTime();
int pr2TurnAround= completedProcesses.get(1).getTurnAroundTime();
int pr3TurnAround= completedProcesses.get(2).getTurnAroundTime();
int pr4TurnAround= completedProcesses.get(3).getTurnAroundTime();
int maxTurnAround = Math.max( pr1TurnAround, Math.max( pr2TurnAround,
Math.max( pr3TurnAround, pr4TurnAround)));
turnAroundTimeOfAllProcessesTotal =
pr1TurnAround+pr2TurnAround+pr3TurnAround+pr4TurnAround;
//Loop
for(int ii =0;ii<completedProcesses.size();ii++)
{
wait = wait + completedProcesses.get(ii).getTotalWaitTime();
}
//Loop
for(int ii =0;ii<completedProcesses.size();ii++)
{
waitTimeOfAllProcessesTotal = wait;
contextSwitchesOfAllProcessesTotal = contextSwitchesOfAllProcessesTotal
+ completedProcesses.get(ii).getContextSwitch();
}
double avgWaitTime = waitTimeOfAllProcessesTotal/totalNoOfProcessesInSystem;
double avgTurnAroundTime =
turnAroundTimeOfAllProcessesTotal/totalNoOfProcessesInSystem;
//Display
System.out.println();
System.out.println();
System.out.println("*****RESULTS****");
System.out.println("Average wait time: " + avgWaitTime);
System.out.println("Average turnaround time: " + avgTurnAroundTime);
double finalthroughput=
((double)cpu.getNoOfCompletedProcesses()/clock.getTimeSinceStartOfSimulator()) *100.0;
System.out.println("Throughput: " + finalthroughput + "%");
double
runTimeMinusContextSwitch=clock.getTimeSinceStartOfSimulator()-contextSwitchesOfAllProcessesTotal;
double utilization=
(runTimeMinusContextSwitch/clock.getTimeSinceStartOfSimulator())*100.0;
System.out.println("CPU utilization: " + utilization + "%");
}
//Declare
private ArrayList<OurProcess> processArrayList;
private int timeQuantum;
private OurCPU cpu;
private Queue<OurProcess> readyQueue;
private OurClock clock;
private ArrayList<OurProcess> completedProcesses;
private static int totalNoOfProcessesInSystem;
}



    
