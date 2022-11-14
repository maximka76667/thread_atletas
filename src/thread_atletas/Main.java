package thread_atletas;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		ArrayList<Thread> threads = new ArrayList<Thread>();
		Carrera carrera = new Carrera();

		// Atletas
		for (int i = 0; i < 8; i++) {
			Thread tAtleta = new Thread(new Atleta("A-" + i, i, carrera), "Atleta-" + i);
			tAtleta.start();
			threads.add(tAtleta);
		}

		// Pistoletazo
		Thread tPistoletazo = new Thread(new Pistoletazo(carrera), "Pistoletazo");
		tPistoletazo.start();
		threads.add(tPistoletazo);

		// Esperar hasta que todos los threads finalizan
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Resultados
		System.out.println("RESULTS");
		List<Result> results = carrera.getResults();

		for (int i = 1; i <= results.size(); i++) {
			System.out.println(i + ". " + results.get(i - 1));
		}

	}

}
