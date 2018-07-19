Feature: Product button

Scenario Outline: Promo code alert is visible when clicking on special offers
	Given the user is at the "<url>" page
	When the user clicks on "<button>"
	Then the user is presented with a promo alert
	
	Examples:
	|		url														|		button				|
	| http://webdriveruniversity.com/Page-Object-Model/products.html	| container-special-offers	|
