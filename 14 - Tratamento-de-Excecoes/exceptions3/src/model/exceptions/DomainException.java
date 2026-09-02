package model.exceptions;

/*Agora estamos tratamento de exceções em vez de usar as exceções do java. 
 * Nós vamos fazer a nossas exceções.
 * 
 * Se você usar RuntimeException ele serva como tratamento sem try/catch, não faz diferenta sem or com try/catch.
 * 
 * Se usar o Exception o compilador vai obrigar a usar o try/catch.
 * */
public class DomainException extends RuntimeException/*Exception*/{ // Aqui vamos usar o RuntimeException 
	private static final long serialVersionUID = 1L;
	
	// Agora estamos passando nossa mensgem personalizada seria add no catch(IllegalAccessException e)
	public DomainException(String msg) {
		super(msg);
	}

}
