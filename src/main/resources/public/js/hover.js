const usernameDisplay = document.querySelector("#username-display");
const originalText = usernameDisplay.innerHTML;

usernameDisplay.addEventListener('mouseover', function() {
  usernameDisplay.innerHTML = `<li class="nav-item text-uppercase" >
    <a href="/profile" class="item-anchor btn btn-outline-primary rounded-pill">Profile</a>
  </li>`;
});

usernameDisplay.addEventListener('mouseout', function() {
  usernameDisplay.innerHTML = originalText;
});


