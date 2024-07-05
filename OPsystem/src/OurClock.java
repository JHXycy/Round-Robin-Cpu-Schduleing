import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
//Class
public class OurClock
{
//Constructor
public OurClock()
{
time = 0;
}
//Method updateTimeSinceStartOfSimulation()
public void updateTimeSinceStartOfSimulation(int runtimeCPU)
{
time = time + runtimeCPU;
}
//Method getTimeSinceStartOfSimulator()
public int getTimeSinceStartOfSimulator()
{
return time;
}
//Method updateArrivalTimeOfProcessesWaiting2Get2ReadyQueue()
public void
updateArrivalTimeOfProcessesWaiting2Get2ReadyQueue(ArrayList<OurProcess> listOfProcess, int
runtimeCPU)
{
//Loop
for(int ii=0;ii<listOfProcess.size();ii++)
{
OurProcess pr =listOfProcess.get(ii);
pr.updateArrivalTime(runtimeCPU);
}
}
//Method updateWaitingTimeOfProcessesInReadyQueue()
public void updateWaitingTimeOfProcessesInReadyQueue(Queue<OurProcess> q, int
runtimeCPU, OurProcess presentP)
{
Iterator<OurProcess> iter = q.iterator();
//Loop
while(iter.hasNext())
{
OurProcess pr = iter.next();
//Check
if(pr != presentP)
{
pr.setPresentWaitTime(runtimeCPU);
}
}
}
//Declare
private int time;
}