import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;

public class Core {
static int cp=2;
static double Interval = 0.0001;
static long Sampling = 1;
static double Gm = 1;
static int count=0;
static long time;

public static void main(String[] args) {
	
Timer timer = new Timer();
ScheduledExecutorService service =Executors.newSingleThreadScheduledExecutor();
Universe Uni = new Universe();
Entity e = new Entity(new TdVector(10,10),new TdVector(0,0),Gm);
Entity f = new Entity(new TdVector(-10,40),new TdVector(0,0),Gm);
Uni.addPlanet(e);
Uni.addPlanet(f);

TimerTask stop= new TimerTask() {
	public void run() {
		service.shutdown();
		System.out.println(count);
	}
};

Runnable run = new Runnable() {
	public void run() {
for(int i=0;i<cp;i++) {
Uni.planets[i].cleanAccer();
System.out.println(String.valueOf(Uni.planets[1].r.x)+" "+String.valueOf(Uni.planets[1].r.y)+" "+String.valueOf(Uni.planets[1].v.magnitude())+" "+String.valueOf(Uni.planets[1].r.magnitude())+"\n");

for(int d=0;d<cp;d++) {
	if(i!=d) {
		Uni.planets[i].a=Uni.planets[i].a.sum(Calculate.getFieldintense(Calculate.getDistance(Uni.planets[i].r, Uni.planets[d].r), Gm));
	}}

Uni.planets[i].r=Calculate.getLocation(Uni.planets[i].r, Uni.planets[i].v, Uni.planets[i].a, Interval);
Uni.planets[i].v =Calculate.getVelocity(Uni.planets[i].v, Uni.planets[i].a, Interval);
		}
count++;

	}};


timer.schedule(stop, 10000);
service.scheduleAtFixedRate(run, 0, Sampling, TimeUnit.NANOSECONDS);
}

}


