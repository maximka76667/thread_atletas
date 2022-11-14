package thread_atletas;

import java.util.ArrayList;

public class Carrera {

	protected boolean isStarted;
	protected ArrayList<Result> results;

	public Carrera() {
		this.isStarted = false;
		this.results = new ArrayList<Result>();
	}

	public synchronized void start() throws InterruptedException {
		System.out.println("Preparados!");
		Thread.sleep(1000);
		System.out.println("Listos!");
		Thread.sleep(1000);
		System.out.println("Ya!");

		isStarted = true;
		notifyAll();
	}

	public void run(Atleta atleta) throws InterruptedException {
		synchronized (this) {
			if (!isStarted) {
				wait();
			}
		}

		int runtime = (int) (9000 + Math.random() * 3000);
		Thread.sleep(runtime);

		double runtimeInSeconds = (double) runtime / 1000;

		System.out.println(atleta.getDorsal() + " tarda  " + runtimeInSeconds);
		results.add(new Result(atleta, runtimeInSeconds));
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

}
