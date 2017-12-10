
public class Entity {
	
public TdVector r;
public TdVector v;
public TdVector a;
public double m;

Entity(TdVector location, TdVector velocity,double Gm){
	this.r=location;
	this.v=velocity;
	this.a=Calculate.getFieldintense(r, Gm);

}
void cleanAccer() {
	this.a=new TdVector(0,0);
};
}


