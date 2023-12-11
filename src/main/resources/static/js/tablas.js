function getData(endpoint) {
    fetch(`http://localhost:8080/${endpoint}`)
        .then(response => response.json())
        .then(data => {
            const resultadoDiv = document.getElementById('resultado');
            resultadoDiv.innerHTML = '';

            const tabla = document.createElement('table');

            const encabezados = tabla.insertRow(0);
                for (const key in data[0]) {
                    const th = document.createElement('th');
                    th.textContent = key;
                    encabezados.appendChild(th);
                }

            data.forEach(item => {
                const fila = tabla.insertRow();
                    for (const key in item) {
                        const celda = fila.insertCell();
                        celda.textContent = item[key];
                    }
            });

            resultadoDiv.appendChild(tabla);
        })
        .catch(error => console.error('Error! al enviar la petición', error));
}
