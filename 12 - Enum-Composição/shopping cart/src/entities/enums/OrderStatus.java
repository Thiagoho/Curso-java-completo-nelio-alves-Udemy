package entities.enums;


//Enumerações
/* E um tipo especial que server para especificar de forma literal um
 * conjunto de constantes relacionadas.
 * 
 * Palavra chave em Java : enum.
 * 
 *  --- Enumerations
 *  A special type used to specify a set of
 *  related constants literally.
 *  
 *  Java Keyword: enum;
 *  */
public enum OrderStatus {
	PRENDIG_PAYMENT, // Pagamento pendente
	PROCESSING, /// processamento
	SHIPPED, // Enviado
	DELIVERED // Entregue
}
