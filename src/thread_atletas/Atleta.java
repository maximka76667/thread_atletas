package thread_atletas;

public class Atleta implements Runnable {

	protected String name;
	protected int dorsal;
	protected Carrera carrera;

	public Atleta(String name, int dorsal, Carrera carrera) {
		this.name = name;
		this.dorsal = dorsal;
		this.carrera = carrera;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	@Override
	public String toString() {
		return "Atleta [name=" + name + ", dorsal=" + dorsal + "]";
	}

	@Override
	public void run() {
		try {
			carrera.run(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
