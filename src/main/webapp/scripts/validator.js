

function validate() {
    let form = document.forms["frmProduct"];
    let name = form.name.value;
    let description = form.description.value;
    let value = form.value.value;
    let available = form.available.checked;

    if (name === "") {
        alert('Fill in the Name field');
        form.name.focus();
        return false;
    } else if (description === "") {
        alert('Fill in the Description field');
        form.description.focus();
        return false;
    } else if (value === "" || isNaN(value) || value <= 0) {
        alert('Fill in the Value field correctly (must be a positive number)');
        form.value.focus();
        return false;
	}else if (available === "") {
	    alert('Select product availability');
	    form.available.focus();
	    return false;
   }else{
		form.submit();
   }

    
}
