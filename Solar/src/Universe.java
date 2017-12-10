public class Universe{
	public int num=0;
	public Entity[] planets= new Entity[100];
	
	 void addPlanet(Entity planet) {
		planets[num++]=planet;
	}
	
}