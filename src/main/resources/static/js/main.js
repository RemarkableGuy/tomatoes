window.onload = getdata(3);

function getdata(size){
    var xmlhttp = new XMLHttpRequest();
    var url = "/data?size=" + size;

    xmlhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var myArr = JSON.parse(this.responseText);
            show(myArr);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function show(arr) {
    document.getElementById("tbody").innerHTML = "";
    arr.forEach(function (element) {
        var date = ((new Date(element.timestamp)));
        document.getElementById("tbody").innerHTML += "<tr><td>" + element.provider + "</td><td>" + element.tomatoes + "</td><td>"+ date.toLocaleDateString("nl-NL") + "</td></tr>";
    });
}