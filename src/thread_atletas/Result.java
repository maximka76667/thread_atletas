package thread_atletas;

public class Result {

	protected Atleta athlet;
	protected double runtime;

	public Result(Atleta athlet, double runtime) {
		this.athlet = athlet;
		this.runtime = runtime;
	}

	public Atleta getAthlet() {
		return athlet;
	}

	public void setAthlet(Atleta athlet) {
		this.athlet = athlet;
	}

	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return athlet + " - " + runtime + "s";
	}

}
