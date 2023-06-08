var addButton = document.querySelector("[name='add']>[name='addBtn']");

addButton.onclick = function() {

    var subVal = new Array();
    subVal.push(document.querySelector("[name='sno']").value);
    subVal.push(document.querySelector("[name='name']").value);
    subVal.push(document.querySelector("[name='gender']").value);
    subVal.push(document.querySelector("[name='age']").value);

    var parentNote = document.getElementById("sData");
    var newTr = document.createElement("tr");
    parentNote.appendChild(newTr);

    for (var i = 0; i < subVal.length; i++) {
        var newTd = document.createElement("td");
        newTd.innerHTML = subVal[i];
        newTr.appendChild(newTd);
    }

    var deleteButton = document.createElement("td");
    deleteButton.innerHTML = "<input type=\"button\" name=\"delBtn\" value=\"delete\">";
    newTr.appendChild(deleteButton);

    deleteButton.onclick = function() {
        this.parentElement.remove();
    }
}
