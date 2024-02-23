window.addEventListener("load", async () => {
  const token = localStorage.getItem("token");
  let userId;
  if (token) {
    const payload = parseJwt(token);
    userId = payload.userId;
  }
  const res = await fetch("/friends/friend", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  if (res.ok) {
    const drop4 = document.querySelector("#dropdown4-list");
    let html = "";
    console.log(data);

    for (const item of data) {
      const userAId = item.userAId;
      const userBId = item.userBId;
    
      const userAName = item.userAName;
      const userBName = item.userBName;
    
      const selectedUserId = userId === userAId ? userBId : userAId;
      const selectedUserName = userId === userAId ? userBName : userAName;
    
      console.log({
        userId,
        userAId,
        userBId,
        userAName,
        userBName,
        selectedUserId,
        selectedUserName
      })
      html += `<li data-value="${selectedUserId}">
        <span>${selectedUserName}</span>
      </li>`;
    }
    drop4.innerHTML = html

    $(".dropdown4-list li").click(function () {
      const selectedValue = $(this).data("value");
      $("#selectedFriend").val(selectedValue);
      $(".selLabel4").text($(this).text());
      $(".dropdown4").removeClass("active");
      $(".selected-listItem p span").text($(".selLabel4").text());
    }); 
  }
});
/* New list part js */

$(document).ready(function () {
  $(".selLabel").click(function () {
    $(".dropdown").toggleClass("active");
  });

  $(".dropdown-list li").click(function () {
    const selectedValue = $(this).data("value");
    $("#book-your-class").val(selectedValue);
    $(".selLabel").text($(this).text());
    $(".dropdown").removeClass("active");
    $(".selected-listItem p span").text($(".selLabel").text());
  });
});

$(document).ready(function () {
  $(".selLabel2").click(function () {
    $(".dropdown2").toggleClass("active");
  });

  $(".dropdown2-list li").click(function () {
    $(".selLabel2").text($(this).text());
    $(".dropdown2").removeClass("active");
    $(".selected-listItem p span").text($(".selLabel2").text());
  });
});

$(document).ready(function () {
  $(".selLabel3").click(function () {
    $(".dropdown3").toggleClass("active");
  });

  $(".dropdown3-list li").click(function () {
    $(".selLabel3").text($(this).text());
    $(".dropdown3").removeClass("active");
    $(".selected-listItem p span").text($(".selLabel3").text());
  });
});

$(document).ready(function () {
 $(".selLabel4").click(function () {
    $(".dropdown4").toggleClass("active");
  });

  $(".dropdown4-list li").click(function () {
    $(".selLabel4").text($(this).text());
    $(".dropdown4").removeClass("active");
    $(".selected-listItem p span").text($(".selLabel4").text());
  }); 
});
/* New list part js end */
// dropdown4-list
function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}
