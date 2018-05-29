window.onload = getData(3);

function showData(data) {
    document.getElementById("tbody").innerHTML = "";
    data.forEach(function (element) {
        var date = new Date(element.timestamp);
        document.getElementById("tbody").innerHTML += "<tr><td>" + element.provider + "</td><td>" + element.tomatoes + "</td><td>"+ date.toLocaleDateString("nl-NL") + "</td></tr>";
    });
}

function getData(size) {
    var xmlhttp = new XMLHttpRequest();
    var url = "/data?size=" + size;

    xmlhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var data = JSON.parse(this.responseText);
            showData(data);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}