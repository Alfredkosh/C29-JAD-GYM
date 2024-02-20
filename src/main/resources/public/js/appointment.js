let baseUrl=`https://good-tan-jay.cyclic.app/`
let btnBook=document.getElementById("book_appointment");
btnBook.addEventListener("click",()=>{
    let date=document.getElementById("inputDate").value;
    let slot=document.getElementById("slot-select").value;
    let token=sessionStorage.getItem("token");
    let name=sessionStorage.getItem("name");
    let trainerId=sessionStorage.getItem("trainerId");

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

async function bookAnAppointment(obj,token,name){

    try {
        let res=await fetch(`${baseUrl}/booking/create`,{
         method:'POST',
         headers:{
             'Content-type':'application/json',
             Authorization:`${token}`
         },
         body:JSON.stringify(obj)
        })
        let out=await res.json();
        //console.log(out);
        if(out.msg=="This Slot is Not Available."){
         alert("This Slot is Not Available.")
        }else if(out.msg=="new booking created successfully"){
         alert("Hi, ${userID} Your booking is confirmed on ${obj.bookingDate}")
        }else{
         alert("Something went wrong")
        }
     } catch (error) {
         console.log("err",error)
         alert("Something went wrong!")
     }
}

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}