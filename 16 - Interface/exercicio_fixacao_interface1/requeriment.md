## Agora precisamos criar um serviço para gerar a fatura

CarRental cr = new CarRental...
RentalService = new RentalService...
service.processInvoice(cr);
---------------------------------------------------------
## Serve layer design (no interface)									// Aqui estou denpemdento esse servico referente ao imposto do brazil
		|RentalService												| BrazilTaxService
		- pricePerHour: Double	-------------------->	 ------------------
		- pricePerDay: Double										 + tax(amout: Double): Double
	----------------------------
	+ processInvoice(carRental:CarRental): void
----------------------------------------------------------------------------------------------------
