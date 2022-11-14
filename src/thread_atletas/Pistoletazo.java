package thread_atletas;

public class Pistoletazo implements Runnable {

	protected Carrera carrera;

	public Pistoletazo(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public void run() {
		try {
			carrera.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
