package graph;

public class Term {
	float coefficient;
	float degree;
	public Term(float coefficent, float degree) {
		this.coefficient=coefficent;
		this.degree=degree;
	}
	public String toString(){
		return(coefficient+"x^("+degree+")");
	}
	public float getValue(float x){
		return (float) (Math.pow(x, degree)*coefficient);
	}

}
