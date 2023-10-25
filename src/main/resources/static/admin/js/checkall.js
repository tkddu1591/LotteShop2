document.addEventListener('DOMContentLoaded', function() {
    var allCheckbox = document.querySelector("input[name='all']");
    allCheckbox.addEventListener('click', function() {
        var checkboxes = document.getElementsByName('chk');
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = allCheckbox.checked;
        }
    });
});