async function fetchProtectedData() {
    const token = localStorage.getItem("token"); // 1. Lấy Token từ Local Storage

    if (!token) {
        window.location.href = "/auth/login";
        return;
    }

    const res = await fetch('/api/dashboard/data', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            // <<< ĐÂY LÀ NƠI GỬI TOKEN >>>
            'Authorization': `Bearer ${token}`
        }
    });

    if (!res.ok) {
        if (res.status === 401 || res.status === 403) {
            localStorage.removeItem("token");
            window.location.href = "/auth/login";
            return;
        }
    }

    const data = await res.json();
    console.log(data);
}
const canvas = document.getElementById("myChart");
const ctx = canvas.getContext("2d");

let sales = [10, 20, 15, 30, 25, 40, 50];

function drawChart() {
    ctx.beginPath();
    ctx.moveTo(50, 200 - sales[0]);

    for (let i = 1; i < sales.length; i++) {
        ctx.lineTo(50 + i * 80, 200 - sales[i]);
    }

    ctx.strokeStyle = "blue";
    ctx.lineWidth = 3;
    ctx.stroke();

    ctx.fillStyle = "red";
    for (let i = 0; i < sales.length; i++) {
        ctx.beginPath();
        ctx.arc(50 + i * 80, 200 - sales[i], 5, 0, Math.PI * 2);
        ctx.fill();
    }
}

drawChart();