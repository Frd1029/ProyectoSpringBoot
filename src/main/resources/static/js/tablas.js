function getData(endpoint) {
    fetch(`http://localhost:8080/${endpoint}`)
        .then(response => response.json())
        .then(data => {
            const resultadoDiv = document.getElementById('resultado');
            resultadoDiv.innerHTML = ''; // Limpiar el contenido actual

            const table = document.createElement('table');

            const headerRow = table.insertRow(0);
            for (const key in data[0]) {
                const th = document.createElement('th');
                th.textContent = key;
                headerRow.appendChild(th);
            }

            data.forEach(item => {
                const row = table.insertRow();
                for (const key in item) {
                    const cell = row.insertCell();
                    cell.textContent = item[key];
                }
            });

            resultadoDiv.appendChild(table);
        })
        .catch(error => console.error('Error:', error));
}
