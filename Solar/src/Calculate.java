public class Calculate {
	static TdVector getFieldintense(TdVector r, double Gm){
		TdVector g = r.getUnitVec().multiply(-inver(r.sqrmagnitude(),Gm)) ;
		return g;
	}
	
	static TdVector getLocation(TdVector r, TdVector v, TdVector a, double inteval) {
		TdVector l =  r.sum(v.multiply(inteval)).sum(a.multiply(0.5).multiply(inteval*inteval));
		return l;
	}
	
	static TdVector getVelocity(TdVector v, TdVector a, double inteval) { 
		TdVector s = v.sum(a.multiply(inteval));
		return s;
	}

	
	static TdVector getB(TdVector r1, TdVector r2,double Gm) {
		return getFieldintense(r2,Gm).sum(getFieldintense(r1,Gm).getInverse());
		
	}
	
	
	static double inver(double x, double para) {
		double i = para/x;
		return i;
	}
	
	static TdVector getDistance(TdVector a,TdVector b) {
		return new TdVector((a.x-b.x),(a.y-b.y));
	}
}
