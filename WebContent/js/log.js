/**
 *
 */
function Confirm() {
	if (confirm("実行してもよろしいですか？")) {
		return true;
	} else {
		return false;
	}
};


var selecterBox = document.getElementById('sample');

    function formSwitch() {
        check = document.getElementsByClassName('js-check')
        if (check[0].checked) {
            selecterBox.style.display = "none";

        } else if (check[2].checked) {
            selecterBox.style.display = "block";

        } else {
            selecterBox.style.display = "none";
        }
    }
    window.addEventListener('load', formSwitch());

function entryChange2(){
    if(document.getElementById('changeSelect')){
    id = document.getElementById('changeSelect').value;
}
}