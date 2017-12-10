
public interface Vector {
  TdVector sum( TdVector y);
  TdVector crossProduct();
  double sqrmagnitude();
  TdVector multiply(double x);
  public TdVector getUnitVec();
  double product(TdVector b);
}

class TdVector implements Vector{
	double x;
	double y;
	double magnitude() {
		 return Math.sqrt(this.x*this.x+this.y*this.y);
	} 
	TdVector(double a, double b){
		this.x=a;
		this.y=b;
	}
	public TdVector sum( TdVector b ) {
		TdVector s = new TdVector(this.x+b.x,this.y+b.y);
		return s;
	}
	
	public TdVector getUnitVec() {
		TdVector u = new TdVector(this.x/this.magnitude(),this.y/this.magnitude());
		return u;
		
	}

	public double product(TdVector b) {
		double p = this.x*b.x+this.y*b.y;
		return p ;
	}

	public TdVector crossProduct() {
	
		return null;
	}

	public double sqrmagnitude() {
		double m;
		m = this.x*this.x+this.y*this.y;
		return m;
	}

	public TdVector multiply(double a) {
		TdVector m = new TdVector(a*this.x,a*this.y); 
		return m;
	}
	public TdVector getInverse() {
		return new TdVector(-this.x,-this.y);
	}

	
}