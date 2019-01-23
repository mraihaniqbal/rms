function toggleCheckboxes(source) {
    var checkboxes = document.getElementsByClassName('single-cb');
    for(let checkbox of checkboxes) {
        checkbox.checked = source.checked;
    }
}