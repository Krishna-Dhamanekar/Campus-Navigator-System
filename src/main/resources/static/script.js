async function findRoute() {

    const source =
        document.getElementById("source").value;

    const destination =
        document.getElementById("destination").value;

    try {

        const response =
            await fetch(
                `/api/route?source=${source}&destination=${destination}`
            );

        const data =
            await response.json();

        console.log(data);

        if(data.totalDistance === -1){

            document.getElementById("distance").innerText =
                "Distance : No Path";

            document.getElementById("time").innerText =
                "Estimated Time : --";

            document.getElementById("path").innerText =
                "No Path Found";

            return;
        }

        document.getElementById("distance").innerText =
            "Distance : " + data.totalDistance + " m";

        const minutes =
            (data.totalDistance / 80).toFixed(1);

        document.getElementById("time").innerText =
            "Estimated Time : " + minutes + " min";

        document.getElementById("path").innerText =
            data.path.join(" ➜ ");

    }
    catch(error){

        console.error(error);

        document.getElementById("path").innerText =
            "Error contacting server";
    }
}