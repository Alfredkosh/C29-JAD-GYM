window.addEventListener("load", async () => {
  const token = localStorage.getItem("token");
  if (token) {
    getAllGym(token, null, null);
  } else {
    window.location.href = "/login";
  }
  getNearestGym();
});

async function successCallback(position) {
  const currentLatitude = position.coords.latitude;
  const currentLongitude = position.coords.longitude;
  const accuracy = position.coords.accuracy;

  const token = localStorage.getItem("token");
  if (token) {
    const payload = parseJwt(token);
  } else {
    window.location.href = "/login";
  }
  // Use the location data as needed
  console.log("Latitude:", currentLatitude);
  console.log("Longitude:", currentLongitude);
  console.log("Token:", token);

  await getAllGym(
    token,
    currentLatitude,
    currentLongitude
  );
}

function getNearestGym() {
  document.querySelector("#find-nearest").addEventListener("click", () => {
    // console.log("find-nearest")
    navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
  });
}

function errorCallback(error) {
  switch (error.code) {
    case error.PERMISSION_DENIED:
      console.log("User denied the request for Geolocation.");
      break;
    case error.POSITION_UNAVAILABLE:
      console.log("Location information is unavailable.");
      break;
    case error.TIMEOUT:
      console.log("The request to get user location timed out.");
      break;
    case error.UNKNOWN_ERROR:
      console.log("An unknown error occurred.");
      break;
  }
}

async function getAllGym(token, currentLatitude, currentLongitude) {
  const res = await fetch("/gym/details", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  let distanceArray = [];
  let minIndex = null;

  if (res.ok) {
    const message = data.message;
    const rows = data.data;

    console.log(rows)

    const courseContainerElem = document.querySelector("#HPCB");
    let html = "";
    for (let row of rows) {
      if (currentLatitude && currentLongitude) {
        const distance = calculateDistance(
          currentLatitude,
          currentLongitude,
          row.latitude,
          row.longitude
         

        );
        console.log(distance)
        distanceArray.push(distance);
        console.log(distanceArray)
      }
    }
    if (distanceArray.length > 0) {
      const min = Math.min(...distanceArray);
      minIndex = distanceArray.indexOf(min);

        console.log({distanceArray,
        min,
        minIndex})
    }

    for (let i = 0; i < rows.length; i++) {
        
        const row = rows[i]
        console.log(rows.length)
        console.log(minIndex)
      if (minIndex != null && minIndex !== i) {
        continue;
      }
      html += `<div class="right-map-w3-agile">
        <h2>Live Count : <span id=live-count-${row.id}>0</span> </h2>
        ${row.map}
        <ul class="add">
          <li class="dot">${row.locationName}</li>
          <li class="address"> Address : ${row.locationAddress}</li>
          <li class="mobile"> Tel : ${row.locationContact}</li>
          <li class="mes"> <a href="${row.locationEmail}"> Email : ${row.locationEmail}</a></li>
          <li class="mobile"> Max. Capacity : ${row.locationMaxPeople}</li>
        </ul>

        <div class="map-grid-right">
          <i class="fa fa-map-marker" aria-hidden="true"></i>
        </div>
        <div class="clear"></div>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
      </div>`;
    }
    courseContainerElem.innerHTML = html;
    await getLiveCount(token);
  } else {
    alert("Failed to fetch getAllGym");
  }
}

function calculateDistance(
  currentLatitude,
  currentLongitude,
  targetLatitude,
  targetLongitude
) {
  const earthRadius = 6371; // Earth's radius in kilometers
  const dLat = toRadians(targetLatitude - currentLatitude);
  const dLon = toRadians(targetLongitude - currentLongitude);

  const a =
    Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(toRadians(currentLatitude)) *
      Math.cos(toRadians(targetLatitude)) *
      Math.sin(dLon / 2) *
      Math.sin(dLon / 2);

  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  const distance = earthRadius * c;

  console.log(distance);

  return distance;
}

function toRadians(degrees) {
  return degrees * (Math.PI / 180);
}

function parseJwt(token) {
  var base64Url = token.split(".")[1];
  var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  var jsonPayload = decodeURIComponent(
    window
      .atob(base64)
      .split("")
      .map(function (c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}

async function getLiveCount(token) {
  const res = await fetch("/record/livecount", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  if (res.ok) {
    const visitors = data.data;

    for (let visitor of visitors) {
      const gymRoomId = visitor.gymRoomId;
      const count = visitor.count;
      const gymRoom = document.querySelector(`#live-count-${gymRoomId}`);
      if (gymRoom) {
        gymRoom.innerHTML = count;

      }
    }
  } else {
    alert("Fail to fetch getLiveCount");
  }
}
