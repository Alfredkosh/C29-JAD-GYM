window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
    await generateQrCode(userId)
    await getUserProfile(token)
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
