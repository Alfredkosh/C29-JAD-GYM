window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
    await generateQrCode(userId)
    await getUserProfile(token)
    await getUserVisitTime(token)
    await getLastCheckInDate(token)
  } else {
    window.location.href = "/login"
  }
})

async function updateProfileElement(username, userId) {
    console.log({
        userId,
        username
    })
  document.querySelector(".client-name").innerHTML = username
  document.querySelector(".client-id").innerHTML = `Member Id: ${userId}`

}

async function getUserProfile(token) {
  const res = await fetch("/auth/profile", {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })
  if (res.ok) {
    const data = await res.json()
    const userProfile = data.data
    const userId = userProfile.id
    const username = userProfile.username

    await updateProfileElement(username, userId)
  }
}


async function updateOwnRecordElement(totalCheckInTime) {
    console.log({
        totalCheckInTime
    })
  document.querySelector(".twitt-left").innerHTML = `<h5>Total Check-in times</h5>
                                                                     <p>${totalCheckInTime}</p>`

}

async function getUserVisitTime(token) {
  const res = await fetch("/auth/ownrecord", {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })
  if (res.ok) {
    const data = await res.json()
    const OwnCheckInRecord = data.totalCheckInTimes
    const totalCheckInTime = OwnCheckInRecord.length

    console.log(OwnCheckInRecord);

    await updateOwnRecordElement(totalCheckInTime)
  }
}

async function updateLastCheckInRecordElement(lastCheckIn) {
    console.log({
        lastCheckIn
    })
  document.querySelector(".twitt-right").innerHTML = `<h5>Latest Check-in Date</h5>
                                                                     <p>${lastCheckIn}</p>`

}
async function getLastCheckInDate(token) {
  const res = await fetch("/auth/lastcheckindate", {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })
  if (res.ok) {
    const data = await res.json()
    const LastCheckInRecord = data.lastCheckInDate
    const lastCheckIn = LastCheckInRecord[LastCheckInRecord.length-1]

    console.log(LastCheckInRecord);

    await updateLastCheckInRecordElement(lastCheckIn)
  }
}

async function generateQrCode(userId) {
  let finalURL =
  'https://chart.googleapis.com/chart?cht=qr&chl=' +
       userId +
        '&chs=160x160&chld=L|0'
  
      // Replace the src of the image with
      // the QR code image
      $('.qr-code').attr('src', finalURL);  
} 

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}

function htmlEncode(value) {
  return $('<div/>').text(value)
    .html();
}
