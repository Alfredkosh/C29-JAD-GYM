
window.addEventListener('load', async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
  await getAllGym(token);
} else {
  window.location.href = "/login"
} 
});

async function getAllGym(token) {
  const res = await fetch("/locations/gymlocation", {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
  const data = await res.json()
  if (res.ok) {
      const message = data.message
      const rows = data.data
      console.log(message)
      console.log(rows)

      const targetLatitude = rows.latitude
      const targetLongitude = rows.longitude

      return targetLatitude, targetLongitude
      
  } else {
      alert("Fail to fetch getAllLocation")
  }
  
}

function calculateDistance(currentLatitude, currentLongitude, targetLatitude, targetLongitude) {
  const earthRadius = 6371; // Earth's radius in kilometers
  const dLat = toRadians(targetLatitude - currentLatitude);
  const dLon = toRadians(targetLongitude - currentLongitude);

  const a =
    Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
    Math.sin(dLon / 2) * Math.sin(dLon / 2);

  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  const distance = earthRadius * c;

  console.log(distance)

  return distance;
}

function toRadians(degrees) {
  return degrees * (Math.PI / 180);
}



function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}