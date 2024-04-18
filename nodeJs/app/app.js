const express = require('express');
const app = express();

const PORT = process.env.PORT || 9000;

// Utiliza express.json() como una función para analizar el cuerpo de la solicitud JSON
app.use(express.json());

app.get('/error/condusef', (req, res) => {
    try {
        console.log(req.body);
        console.log("consumo");
        res.status(200).json('Consumo correcto');
    } catch (error) {
        console.error('¡Ocurrió una excepción!', error);
        res.status(500).json({ error: '¡Ha ocurrido un error en el servidor!' });
    }
});

app.listen(PORT, () => {
    console.log("API arriba en el puerto " + PORT);
});
