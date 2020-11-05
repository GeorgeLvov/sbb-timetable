function changeDepartureArrival() {

    let x = document.getElementById("departureTable");
    let y = document.getElementById("arrivalTable");

    if (x.style.display === "none") {
        x.style.display = "block";
        y.style.display = "none"
    } else {
        x.style.display = "none";
        y.style.display = "block";
    }
    setTimeout(changeDepartureArrival, 15000); // change departure/arrival table each 15 seconds
}

function currentTime() {
    let date = new Date();
    let hour = date.getHours();
    let min = date.getMinutes();
    let sec = date.getSeconds();
    hour = updateTime(hour);
    min = updateTime(min);
    sec = updateTime(sec);
    document.getElementById("clock").innerText = hour + ":" + min + ":" + sec; // adding clock to the page
    setTimeout(currentTime, 1000); // setting timer
}

function updateTime(n) { // adding leading zeros
    return n < 10 ? "0" + n : n;
}
