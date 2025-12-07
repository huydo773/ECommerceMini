document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();
    login();
});

async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const res = await fetch('/api/auth/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({userName: username, password: password})
    });
    const msgBox = document.getElementById("errorMsg");
    if (!res.ok) {
        const message = await res.text(); //lấy text từ backend
        msgBox.innerText = message;
        msgBox.style.display = "block";
        return;
    }

    const data = await res.json();
    localStorage.setItem("token", data.token);
    window.location.href = "/dashboard/home";
}