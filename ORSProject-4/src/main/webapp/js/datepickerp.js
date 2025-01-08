$(document).ready(function() {
	$("#pdate").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : '2023:2025',
		minDate : new Date(2023, 0, 1),
		maxDate : new Date(2025, 11, 31)
	});
});