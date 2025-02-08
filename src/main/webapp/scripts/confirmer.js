

function deleteContact(id) {
	let resposta = confirm("Delete this product?")
	if (resposta === true) {
		window.location.href = "delete?id=" + id
	}
}