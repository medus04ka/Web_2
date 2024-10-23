function showNotification(message) {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.style.display = 'block';
    notification.style.opacity = 1;

    setTimeout(() => {
        notification.style.opacity = 0;
        setTimeout(() => {
            notification.style.display = 'none';
        }, 500);
    }, 3000);
}

let points = [];

function drawPoint(x, y, r) {
    const svg = document.querySelector('svg');
    const graphX = 150 + (x / r) * 100;
    const graphY = 150 - (y / r) * 100;

    const newDot = document.createElementNS("http://www.w3.org/2000/svg", "circle");
    newDot.setAttribute("cx", graphX);
    newDot.setAttribute("cy", graphY);
    newDot.setAttribute("r", 3);
    newDot.setAttribute("fill", "white");
    svg.appendChild(newDot);
}

document.querySelector('svg').addEventListener('click', function(event) {
    const svg = this;
    const point = svg.createSVGPoint();

    point.x = event.clientX;
    point.y = event.clientY;
    const cursorPoint = point.matrixTransform(svg.getScreenCTM().inverse());

    const r = parseFloat(document.querySelector('input[name="rval"]:checked')?.value);
    if (isNaN(r)) {
        showNotification("Выбери значение R перед добавлением точки, бро.");
        return;
    }

    const graphX = ((cursorPoint.x - 150) / 100) * r;
    const graphY = ((150 - cursorPoint.y) / 100) * r;

    drawPoint(graphX, graphY, r);
    points.push({ x: graphX, y: graphY, r: r });
    submitData(graphX, graphY, r);
});

function submitData(x, y, r) {
    const url = new URL(document.URL, window.location.href);
    url.searchParams.set('x', x);
    url.searchParams.set('y', y);
    url.searchParams.set('r', r);

    fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    })
        .then(response => response.json())
        .then(json => {
            json.serverTime = json.serverTime;
            json.executeTime = json.executeTime;
            updateResultsTable();
        })
        .catch(error => console.error('Error:', error));
}

function init() {
    const data = getResponsesFromLocalStorage();
    for (let i = 0; i < data.length; i++) {
        const response = data[i];
        drawPoint(response.x, response.y, response.r);
        showResponse(response);
    }
}

document.getElementById("input-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const xValue = document.getElementById('x-text-input').value;
    const yValue = document.querySelector('input[name="yval"]:checked')?.value;
    const rValue = document.querySelector('input[name="rval"]:checked')?.value;

    if (!xValue || !yValue || !rValue) {
        showNotification("Чета ты не прокликал(( прокликай пожалуйста");
        return;
    }

    const x = parseFloat(xValue);
    const y = parseFloat(yValue);
    const r = parseFloat(rValue);

    if (isNaN(x) || x < -3 || x > 3) {
        showNotification("не шути так(( в иксике онли -3 до 3");
        return;
    }

    submitData(x, y, r);
});

window.onload = function() {
    init();
};

function updateResultsTable() {
    fetch('jsp/results.jsp')
        .then(response => response.text())
        .then(html => {
            document.getElementById('results').innerHTML = html;
        })
        .catch(error => console.error('Ошибка при обновлении таблицы:', error));
}
