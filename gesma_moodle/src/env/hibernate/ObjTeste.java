package hibernate;

public class ObjTeste {
	private int id;
	private String nome;
	private int salario;
	
	public ObjTeste() {}

	public ObjTeste(String nome, int salario) {
		this.nome = nome;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSalario() {
		return salario;
	}
	
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
}
